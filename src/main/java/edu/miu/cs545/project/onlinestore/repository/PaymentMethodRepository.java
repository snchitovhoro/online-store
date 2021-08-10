package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Address;
import edu.miu.cs545.project.onlinestore.domain.PaymentMethod;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PaymentMethodRepository extends ReactiveCrudRepository<PaymentMethod, Long> {

}
