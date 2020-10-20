package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    IPersonRepo repo;
    PersonService service;
    int currentID = 0;

    @BeforeEach
    void init() {
        repo = mock(IPersonRepo.class);
        service = new PersonService(repo);
    }

    @Test
    void testCreate() {
        doAnswer(
                invocation -> {
                   Person person = (Person) invocation.getArguments()[0];
                   person.setId(++currentID);
                   return null;
                }).when(repo).save(any(Person.class));

        String firstname = "name";
        String lastname = "lastName";
        int age = 20;

        Person createdPerson = service.create(firstname,lastname,age);
        assertEquals(firstname, createdPerson.getFirstName());
        assertEquals(lastname, createdPerson.getLastName());
        assertEquals(age, createdPerson.getAge());
        assertNotEquals(0,createdPerson.getId());

        verify(repo, times(1)).save(argThat(argument -> argument == createdPerson));
    }

}