package com.example.login.service;

import com.example.login.entity.Food;
import com.example.login.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoodService {
    public List<Food> getAllFoods();
}
