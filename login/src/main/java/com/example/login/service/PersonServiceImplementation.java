package com.example.login.service;


import com.example.login.DTO.LoginRequest;
import com.example.login.DTO.PersonRequest;
import com.example.login.DTO.PersonResponse;
import com.example.login.entity.Person;
import com.example.login.repos.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements PersonService {
    @Autowired
    private PersonRepository personRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Person> getAllPersons() {
        var s = (List<Person>) personRepo.findAll();
        return s;
    }


    @Override
    public String addPerson(PersonRequest personRequest) {
        Person person=new Person(
                personRequest.getId(),
                personRequest.getEmail(),
               this.passwordEncoder.encode(personRequest.getPassword())
        );
        personRepo.save(person);

        return person.getEmail();
    }



    @Override
    public PersonResponse loginPerson(LoginRequest loginRequest) {

        String msg = "";
        Person person1 = personRepo.findByEmail(loginRequest.getEmail());
        if (person1 != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = person1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<Person> person = personRepo.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);
                if (person.isPresent()) {
                    return new PersonResponse("Success", true);
                } else {
                    return new PersonResponse("Failure", false);
                }
            } else {

                return new PersonResponse("password Not Match", false);
            }
        }else {
            return new PersonResponse("Email not exits", false);
        }
    }



}
