package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testGetPerson() {
        Person person = new Person("Name","Surname",45);
        person.setId(1);
        when(repo.find(1)).thenReturn(person);
        assertEquals(person,service.getPerson(1));
    }

    @Test
    void testGetAll() {
        Person person1 = new Person("Name","Surname",45);
        person1.setId(1);
        Person person2 = new Person("Name","Surname",45);
        person2.setId(2);
        Person person3 = new Person("Name","Surname",45);
        person3.setId(3);
        when(repo.findAll()).thenReturn(List.of(person1,person2,person3));
        assertEquals(List.of(person1,person2,person3),service.getAll());
    }

    @Test
    void testRemovePerson_1el() {
        Person person1 = new Person("Name","Surname",45);
        person1.setId(1);
        when(repo.remove(1)).thenReturn(person1);
        assertEquals(person1,service.removePerson(1));
    }

    @Test
    void testRemovePerson_3el() {
        Person person1 = new Person("Name","Surname",45);
        person1.setId(1);
        Person person2 = new Person("Name","Surname",45);
        person2.setId(2);
        Person person3 = new Person("Name","Surname",45);
        person3.setId(3);
        when(repo.remove(2)).thenReturn(person2);
        assertEquals(person2,service.removePerson(2));
    }
}