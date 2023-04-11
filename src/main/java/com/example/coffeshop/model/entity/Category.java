package com.example.coffeshop.model.entity;
import com.example.coffeshop.model.enums.NameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NameEnum name;
    @Column(nullable = false)
    private int neededTime;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public NameEnum getName() {
        return name;
    }

    public Category setName(NameEnum name) {
        this.name = name;
        return this;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(int neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
