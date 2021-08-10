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
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name="street", columnDefinition = "VARCHAR(255)")
    private String street;
    @Column(name="city", columnDefinition = "VARCHAR(20)")
    private String city;
    @Column(name="state", columnDefinition = "VARCHAR(20)")
    private String state;
    @Column(name="country", columnDefinition = "VARCHAR(20)")
    private String country;
    @Column(name="zipcode", columnDefinition = "int(5)")
    private Integer zipcode;
}
