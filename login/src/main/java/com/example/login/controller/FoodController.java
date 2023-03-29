package com.example.login.controller;

import com.example.login.entity.Food;
import com.example.login.entity.Person;
import com.example.login.service.FoodService;
import com.example.login.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class FoodController {
    @Autowired
    private FoodService foodService ;

    @GetMapping("/foods")
    @ResponseBody
    public ResponseEntity<List<Food>> getAllFoods(){

        List<Food> foodsList=foodService.getAllFoods();
        return new ResponseEntity<List<Food>>(foodsList, HttpStatus.OK);
    }
}
