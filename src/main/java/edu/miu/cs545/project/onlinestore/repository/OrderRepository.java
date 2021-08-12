package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    public List<Order> findAllByBuyerId(long buyerId);

    public Optional<Order> findById(Long Id);

    public List<Order> findAll();

    public Order findOrderById(Long id);

    @Query(value = "UPDATE Order o SET o.status = 'Cancelled' WHERE o.id = :orderId")
    public Order cancelOrder(long orderId);
}
