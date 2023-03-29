package com.example.newapp;

import java.io.Serializable;

public class FoodModel  implements Serializable {

    public int id;

    public String name;

    public String categoryName;

    public Double price;

    public String image;

    public FoodModel() {
    }

    public FoodModel(int id, String name, String categoryName, Double price, String image) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
        this.image=image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
