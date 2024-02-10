package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private float excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "vacation_id")
    private long vacation_id;

    // Relationships:
    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    private Vacation vacation;
}