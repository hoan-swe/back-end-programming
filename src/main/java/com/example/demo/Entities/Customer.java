package com.example.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address cannot be blank!")
    private String address;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "customer_first_name", nullable = false)
    @NotBlank(message = "First name cannot be blank!")
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    @NotBlank(message = "Last name cannot be blank!")
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "phone", nullable = false)
    @NotBlank(message = "Phone number cannot be blank!")
    private String phone;

    @Column(name = "postal_code", nullable = false)
    @NotBlank(message = "Postal code cannot be blank!")
    private String postal_code;

    // Relationships:
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }

            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
