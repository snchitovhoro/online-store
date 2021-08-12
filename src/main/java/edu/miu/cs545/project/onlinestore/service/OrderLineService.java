package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.*;

import java.util.Collection;
import java.util.Optional;

public interface OrderLineService {
    public Optional<Order> getOrderById(long orderId);

//    public Order cancelOrder(long id);

    public Status getOrderStatus(long orderId);

    public Order createOrder(Order newOrder);

    Collection<Order> getOrderForBuyer(long buyerId);

    Collection<Order> getAll();

    public Collection<OrderLine> getOrderLineById(long orderId);

    Collection<Order> getOrderBySellerId(long sellerId);

    Boolean cancelOrder(long orderId);

    Boolean shippedOrder(long orderId);

    Boolean deliveredOrder(long orderId);

    void createOrderFromCart(Long cartId, Shipping shipping, Payment payment);
}
