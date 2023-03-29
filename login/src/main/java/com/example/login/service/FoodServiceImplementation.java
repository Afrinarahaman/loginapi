package com.example.login.service;

import com.example.login.entity.Food;
import com.example.login.entity.Person;
import com.example.login.repos.FoodRepository;
import com.example.login.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService {

    @Autowired
    private FoodRepository foodRepo;
    @Override
    public List<Food> getAllFoods() {
        var list = (List<Food>) foodRepo.findAll();
        return list;
    }
}
