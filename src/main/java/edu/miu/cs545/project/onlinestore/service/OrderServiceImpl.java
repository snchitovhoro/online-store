package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.*;
import edu.miu.cs545.project.onlinestore.repository.BuyerRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderLineRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderRepository;
import edu.miu.cs545.project.onlinestore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    private OrderRepository orderRepository;
    //@Autowired
    //private JavaMailSender javaMailSender;
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private IShippingService shippingService;
    @Autowired
    private IPaymentService paymentService;
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

    @Override
    public String getOrderStatus(long orderId) {//checked
        return String.valueOf(orderRepository.findById(orderId).get().getStatus());
    }

    @Override
    public Order createOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    } //checked

    @Override
    public List<Order> getOrderForBuyer(long buyerId) {
        return (List<Order>) orderRepository.findAllById(Collections.singleton(buyerId));
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

//    @Override
//    public List<OrderLine> getOrderForBuyer(long orderId){
//        List<OrderLine> buyerOrderLine = new ArrayList<OrderLine>();
//        buyerOrderLine = orderRepository.getOrderForBuyer(orderId);
//        return buyerOrderLine;
//    }

    @Override
    public Optional<OrderLine> getOrderLineById(long orderId) {
        List<OrderLine> listOrderLine = new ArrayList<>();
        return orderLineRepository.findById(orderId);
    }

    @Override
    public List<Order> getOrderBySellerId(long sellerId) {
        return orderRepository.findAllByBuyerId(sellerId);
    }

//    @Override
//    public List<Order> getOrderBySellerId(long sellerId) {
//
//        List<OrderLine> lines = orderLineRepository.findAll().stream().filter(ol -> ol.getProduct().getSeller().getId() == sellerId).collect(Collectors.toList());
//
//        List<Long> ids = lines.stream().map(l -> l.getId()).collect(Collectors.toList());
//        List<Order> orders = orderRepository.findAll().stream().filter(o -> ids.contains(o.getId())).collect(Collectors.toList());
//        return orders;
//    }

    @Override
    public Boolean cancelOrder(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order != null) {
            Order savedOrder = order.get();
            savedOrder.setStatus(Status.valueOf("CANCELLED"));
            orderRepository.save(savedOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean shippedOrder(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order != null) {
            Order shippedOrder = order.get();
            shippedOrder.setStatus(Status.valueOf("SHIPPED"));
            orderRepository.save(shippedOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deliveredOrder(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order != null) {
            Order deliveredOrder = order.get();
            deliveredOrder.setStatus(Status.valueOf("DELIVERED"));
            orderRepository.save(deliveredOrder);
            return true;
        }
        return false;
    }

    @Override
    public void createOrderFromCart(Long cartId, Shipping shipping, Payment payment) {

    }

//    void sendEmail(String emailAddress, Order order) {
//        try {
//            SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setTo(emailAddress, emailAddress);
//
//            msg.setSubject("Purchase successfully");
//            String content = "";
//            content += order.getId() + "\n";
//            content += order.getDate().toString() + "\n";
//            content += order.getPayment().getPaymentMethod() + "\n";
//            content += order.getTotalMoney().toString() + "\n";
//            content += order.getShipping().toString() + "\n";
//            content += "THANK YOU FOR SHOPPING.";
//            msg.setText(content);
//
//            javaMailSender.send(msg);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

//    public void createOrderFromCart(Long cartId, Shipping shipping, Payment payment) {
//        Order order = new Order();
//        Shipping shipping1 = shippingService.createShipping(shipping);
//        Payment payment1 = paymentService.createPayment(payment);
//        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCart(cartId);
//        if (cart.isPresent()) {
//            ShoppingCart cart1 = cart.get();
//            order.setStatus("NEW");
//            order.setDate(LocalDate.now());
//            order.setShipping(shipping1);
//            order.setPayment(payment1);
//            order.setTotalMoney(cart1.getTotalMoney());
//            order.setBuyer(cart1.getBuyer());
//            List<ShoppingCartLine> cartLines = shoppingCartService.getLinesByShoppingCart(cartId);
//            cartLines.forEach(cartline -> {
//                OrderLine orderLine = createOrderLineFromCartLine(cartline);
//                orderLine.setOrder(order);
//                orderLineRepository.save(orderLine);
//            });
//
//            Order order1 = orderRepository.save(order);
//
//            cart1.setCompleted(true);
//            Buyer buyer = cart1.getBuyer();
//            buyer.setAccumulatedPoints(buyer.getAccumulatedPoints() + 10);
//            buyerRepository.save(buyer);//gain point for buyer.
//
//            shoppingCartRepository.save(cart1);
//            sendEmail(buyer.getUser().getEmail(), order1);
//        }
//    }

//    private OrderLine createOrderLineFromCartLine(ShoppingCartLine cartLine) {
//        OrderLine line = new OrderLine();
//        line.setProduct(cartLine.getProduct());
//        line.setPrice(cartLine.getPrice());
//        line.setLineTotal(cartLine.getLineTotal());
//        line.setQuantity(cartLine.getQuantity());
//        return line;
//    }

}
