package com.dcg.SpringBootTest;

import com.dcg.SpringBootTest.model.person.Person;

public interface PersonService {
    /**
     * CREATE
     * @return String
     */
    String persistPerson(Person person);

    /**
     * RETRIEVE
     * @return Person
     *
     */
    Person retrievePerson(String personId);

    /**
     * UPDATE
     * @param id, person
     * @return int
     */
    int updatePerson(String id, Person person);

    /**
     * DELETE
     */
    int deletePerson(String id);

}
