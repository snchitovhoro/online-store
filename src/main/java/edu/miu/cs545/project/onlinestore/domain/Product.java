package edu.miu.cs545.project.onlinestore.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 7359591984285268537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "producer")
    private String producer;

    @Column(name = "description", length=500)
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "size", length=5)
    private String size;

    @Column(name = "price", columnDefinition = "double default 0.0" )
    private Double price;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "photo")
    private String photo;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "num_reviews")
    private Integer numReviews;

    @OneToMany(mappedBy="product")
    private List<Review> reviews = new ArrayList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seller_id")
    Seller seller;
}
