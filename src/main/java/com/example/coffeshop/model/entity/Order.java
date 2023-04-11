package com.example.coffeshop.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Positive
    private BigDecimal price;
    @Column
    @DateTimeFormat
    private Date orderTime;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private User employee;
    @ManyToOne
    private Category category;


    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public Order setEmployee(User employee) {
        this.employee = employee;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }
}
