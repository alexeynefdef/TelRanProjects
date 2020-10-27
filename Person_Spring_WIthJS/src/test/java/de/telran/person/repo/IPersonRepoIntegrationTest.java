package de.telran.person.repo;

import de.telran.person.model.Person;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJdbcTest
public class IPersonRepoIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepo personRepo;

    @Test
    void testFindAllByName_1person_existing(){
        Person person = new Person("Vasya","Pupkin",35);
        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> fromDB = personRepo.findAllByFirstName("Vasya");

        assertEquals(1,fromDB.size());

        Iterator<Person> iterator = fromDB.iterator();
        Person personFromDB = iterator.next();

        assertEquals(person.getAge(),personFromDB.getAge());
        assertEquals(person.getFirstName(), personFromDB.getFirstName());
        assertEquals(person.getLastName(), personFromDB.getLastName());

        assertTrue(personFromDB.getId() > 0);
    }
}
