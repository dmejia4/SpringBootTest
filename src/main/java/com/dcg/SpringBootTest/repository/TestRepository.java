package com.dcg.SpringBootTest.repository;

import com.dcg.SpringBootTest.model.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Person, String> {
}
