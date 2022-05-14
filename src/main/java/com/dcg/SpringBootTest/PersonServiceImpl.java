package com.dcg.SpringBootTest;

import com.dcg.SpringBootTest.model.person.Person;
import com.dcg.SpringBootTest.repository.TestRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Log
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    TestRepository testRepo;

    @Override
    public String persistPerson(Person person) {
        person.setPersonCode(UUID.randomUUID().toString());
        log.info("PersonCode = " + person.getPersonCode());
        testRepo.save(person);
        return person.getPersonCode();
    }

    @Override
    public Person retrievePerson(String personId) {
        Optional<Person> person = testRepo.findById(personId);
        return person.get();
    }

    @Override
    public int updatePerson(String id, Person person) {
        Optional<Person> tempPerson = testRepo.findById(id);
        Person personToUpdate = tempPerson.get();
        personToUpdate.setPersonName(person.getPersonName());
        personToUpdate.setBirthDay(person.getBirthDay());
        testRepo.save(personToUpdate);
        return 1;
    }

    @Override
    public int deletePerson(String id) {
        testRepo.deleteById(id);
        return 1;
    }
}
