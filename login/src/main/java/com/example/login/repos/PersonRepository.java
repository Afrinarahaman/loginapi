package com.example.login.repos;

import com.example.login.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findOneByEmailAndPassword(String email, String password);

    Person findByEmail(String email);
}
