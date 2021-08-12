package edu.miu.cs545.project.onlinestore.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review implements Serializable {
    private static final long serialVersionUID = 7359591984285268537L;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "review_date", nullable = false)
    private LocalDate date;
    @Column(name = "content", nullable = false, length = 500)
    private String content;
    @Column(name = "stars")
    private int numberOfStars;
    @Column(name = "approved")
    private boolean approved;
}
