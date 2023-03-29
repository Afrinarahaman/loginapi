package com.example.login.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Person", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" )
    private Integer id;
    @Column(name="Email",unique = true, nullable = false, length = 100)
    private String email;
    @Column(name="Password", nullable = false, length = 100)
    private String password;

    public Person() {
    }

    public Person(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
