package com.example.login.service;

import com.example.login.DTO.LoginRequest;
import com.example.login.DTO.PersonRequest;
import com.example.login.DTO.PersonResponse;
import com.example.login.entity.Person;

import java.util.List;

public interface PersonService {
    String addPerson(PersonRequest personRequest);

   public List<Person> getAllPersons();

   PersonResponse loginPerson(LoginRequest loginRequest);
}
