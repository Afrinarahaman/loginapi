package com.example.login.repos;

import com.example.login.entity.Food;
import com.example.login.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
}
