package edu.miu.cs545.project.onlinestore.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderlines")
public class OrderLine implements Serializable {
    private static final long serialVersionUID = 7359591984285268537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id", nullable = false)
    private long id;

    @Column(name = "quantity", nullable = false, columnDefinition = "int default 0")
    private int quantity;

    @Column(name = "price", nullable = false, columnDefinition = "double default 0.0")
    private Double price;

    @Column(name = "line_total", columnDefinition = "double default 0.0")
    private Double lineTotal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    Product product;

}
