package edu.miu.cs545.project.onlinestore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "date",columnDefinition = "timestamp default current_timestamp")
    private LocalDate date;

    @Column(name = "amount", columnDefinition = "double default 0.0")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "default 'NEW")
    private Status status;
}
