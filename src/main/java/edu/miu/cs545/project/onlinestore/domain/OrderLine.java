package edu.miu.cs545.project.onlinestore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_lines")
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "quantity", nullable = false, columnDefinition = "int default 0")
    private Integer quantity;
    @Column(name = "amount", nullable = false, columnDefinition = "double default 0.0")
    private Double amount;
    @Column(name = "total", columnDefinition = "double default 0.0")
    private Double total;

}
