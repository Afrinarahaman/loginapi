package com.example.login.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Food", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" )
    private Integer id;
    @Column(name="Name",unique = true, nullable = false, length = 100)
    private String name;
    @Column(name="CategoryName", nullable = false, length = 100)
    private String categoryName;
    @Column(name="Price", nullable = false)
    private Double price;

    @Column(name="Image",  length = 100)
    private String image;

}
