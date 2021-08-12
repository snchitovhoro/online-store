package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.*;
import edu.miu.cs545.project.onlinestore.repository.BuyerRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderLineRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderRepository;
import edu.miu.cs545.project.onlinestore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderRepository orderRepository;
//    @Autowired
//    private JavaMailSender javaMailSender;

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Autowired
    private IShippingService shippingService;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    @Override
    public Optional<Order> getOrderById(long orderId) {
        return orderRepository.findById(orderId);   //checked
    }

//    @Override
//    public Order cancelOrder(long orderId){
//        return orderRepository.cancelOrder(orderId);
//    }

    public Status getOrderStatus(long orderId) {//checked
        return orderRepository.findById(orderId).get().getStatus();
        //return orderRepository.getOrderStatus(orderId);
    }

    @Override
    public Order createOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    } //checked

    @Override
    public Collection<Order> getOrderForBuyer(long buyerId) {
        return orderRepository.findAllByBuyerId(buyerId);
    }

    @Override
    public Collection<Order> getAll() {
        return orderRepository.findAll();
    }

//    @Override
//    public Collection<OrderLine> getOrderForBuyer(long orderId){
//        Collection<OrderLine> buyerOrderLine = new ArrayCollection<OrderLine>();
//        buyerOrderLine = orderRepository.getOrderForBuyer(orderId);
//        return buyerOrderLine;
//    }

    @Override
    public Collection<OrderLine> getOrderLineById(long orderId) {
        Collection<OrderLine> listOrderLine = new ArrayList<>();
        return orderLineRepository.getOrderLineById(orderId);
    }

    @Override
    public Collection<Order> getOrderBySellerId(long sellerId) {

        Collection<OrderLine> lines = (Collection<OrderLine>) orderLineRepository.findAll();
//        .stream().filter(ol -> ol.getProduct().getSeller().getId() == sellerId).collect(Collectors.toCollection());
//
//        Collection<Long> ids = lines.stream().map(l -> l.getId()).collect(Collectors.toCollection());
//        Collection<Order> orders = orderRepository.findAll().stream().filter(o -> ids.contains(o.getId())).collect(Collectors.toCollection());
        return null;
    }

    @Override
    public Boolean cancelOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order != null) {
            order.setStatus(Status.CANCELLED);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public Boolean shippedOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order != null) {
            order.setStatus(Status.SHIPPED);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deliveredOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order != null) {
            order.setStatus(Status.DELIVERED);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    void sendEmail(String emailAddress, Order order) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(emailAddress, emailAddress);

            msg.setSubject("Purchase successfully");
            String content = "";
            content += order.getId() + "\n";
            content += order.getDate().toString() + "\n";
            content += order.getPayment().getPaymentMethod() + "\n";
            content += order.getAmount().toString() + "\n";
            content += order.getShipping().toString() + "\n";
            content += "THANK YOU FOR SHOPPING.";
            msg.setText(content);

            //javaMailSender.send(msg);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createOrderFromCart(Long cartId, Shipping shipping, Payment payment) {
        Order order = new Order();
        Shipping shipping1 = shippingService.createShipping(shipping);
        Payment payment1 = paymentService.createPayment(payment);
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCart(cartId);
        if (cart.isPresent()) {
            ShoppingCart cart1 = cart.get();
            order.setStatus(Status.NEW);
            order.setDate(LocalDate.now());
            order.setShipping(shipping1);
            order.setPayment(payment1);
            order.setAmount(cart1.getTotalMoney());
            order.setBuyer(cart1.getBuyer());
            Collection<ShoppingCartLine> cartLines = shoppingCartService.getLinesByShoppingCart(cartId);
            cartLines.forEach(cartline -> {
                OrderLine orderLine = createOrderLineFromCartLine(cartline);
                orderLine.setOrder(order);
                orderLineRepository.save(orderLine);
            });

            Order order1 = orderRepository.save(order);

            cart1.setCompleted(true);
            Buyer buyer = cart1.getBuyer();
            buyer.setAccumulatedPoints(buyer.getAccumulatedPoints() + 10);
            buyerRepository.save(buyer);//gain point for buyer.

            shoppingCartRepository.save(cart1);
            sendEmail(buyer.getUser().getEmail(), order1);
        }
    }

    private OrderLine createOrderLineFromCartLine(ShoppingCartLine cartLine) {
        OrderLine line = new OrderLine();
        line.setProduct(cartLine.getProduct());
        line.setAmount(cartLine.getPrice());
        line.setTotal(cartLine.getLineTotal());
        line.setQuantity(cartLine.getQuantity());
        return line;
    }

}
