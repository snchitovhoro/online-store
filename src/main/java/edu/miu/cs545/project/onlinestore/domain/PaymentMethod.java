package edu.miu.cs545.project.onlinestore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paymentmethods")
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 7359591984285268537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private long id;

    @Column(name = "payment_method_name", nullable = false)
    private String paymentMethod;

}
