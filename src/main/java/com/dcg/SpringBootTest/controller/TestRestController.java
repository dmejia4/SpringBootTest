package com.dcg.SpringBootTest.controller;

import com.dcg.SpringBootTest.PersonService;
import lombok.extern.java.Log;
import com.dcg.SpringBootTest.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/api/v1/people")
public class TestRestController {

    @Autowired
    PersonService personSvc;

    @PostMapping({""})
    public ResponseEntity<String> persistPerson (@RequestBody Person person) {
        String personId = personSvc.persistPerson(person);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", personId);
        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @GetMapping({"/{personId}"})
    public ResponseEntity<Person> retrievePerson (@PathVariable String personId) {
        Person person = personSvc.retrievePerson(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping({"/{personId}"})
    public ResponseEntity<Person> updatePerson (@PathVariable String personId, @RequestBody Person person) {
        int status = personSvc.updatePerson(personId, person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{personId}"})
    public ResponseEntity<Void> deletePerson (@PathVariable String personId) {
        int status = personSvc.deletePerson(personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
