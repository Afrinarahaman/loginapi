package com.example.login.controller;

import com.example.login.DTO.LoginRequest;
import com.example.login.DTO.PersonRequest;
import com.example.login.DTO.PersonResponse;
import com.example.login.entity.Person;
import com.example.login.service.PersonService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")


public class PersonController {
    @Autowired
    private  PersonService personService ;

    @PostMapping("/register")
    @ResponseBody

    public ResponseEntity<PersonResponse> registrarPerson(@RequestBody PersonRequest personRequest)
    {
        PersonResponse o = new PersonResponse();
        String email = "before catch";
        try{
            email=personService.addPerson(personRequest);

            o.setMessage(email);
            o.setStatus(true);
        }catch (Exception e){
            o.setMessage("Failure " + email);
            o.setStatus(false);
        }

        //parse id to json then return
        return ResponseEntity.ok(o);
    }

    @GetMapping("/personsList")
    @ResponseBody
    public ResponseEntity<List<Person>> getAllPersons(){

        List<Person> personsList=personService.getAllPersons();
        return new ResponseEntity<List<Person>>(personsList,HttpStatus.OK);
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> loginPerson(@RequestBody LoginRequest loginRequest)
    {
        PersonResponse personResponse=personService.loginPerson(loginRequest);
        return ResponseEntity.ok(personResponse);
    }
}
