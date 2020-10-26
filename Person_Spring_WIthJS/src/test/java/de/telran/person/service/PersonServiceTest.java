package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    IPersonRepo repo;

    @InjectMocks
    PersonService service;

    @Test
    void testCreate() {
        String firstname = "name";
        String lastname = "lastName";
        int age = 20;

        Person createdPerson = service.create(firstname, lastname, age);
        assertEquals(firstname, createdPerson.getFirstName());
        assertEquals(lastname, createdPerson.getLastName());
        assertEquals(age, createdPerson.getAge());
        verify(repo, times(1)).save(argThat(argument -> argument == createdPerson));
    }

    @Test
    void testGet() {
        Person person = new Person("Name", "Surname", 45);
        when(repo.findById(1)).thenReturn(Optional.of(person));
        assertEquals(person, service.get(1));
    }

    @Test
    void testGet_notExists_throwsPNFE() {
        assertThrows(EntityNotFoundException.class, () -> service.get(2));
    }

    @Test
    void testGetAll() {
        Person person1 = new Person("Name", "Surname", 45);
        Person person2 = new Person("Name", "Surname", 45);
        Person person3 = new Person("Name", "Surname", 45);
        when(repo.findAll()).thenReturn(List.of(person1, person2, person3));
        assertEquals(List.of(person1, person2, person3), service.getAll());
    }

    @Test
    void testRemovePerson_1el() {
        Person person1 = new Person("Name", "Surname", 45);
        when(repo.findById(1)).thenReturn(Optional.of(person1));
        assertEquals(person1, service.remove(1));
        verify(repo, times(1)).delete(person1);
    }

    @Test
    void testRemovePerson_notExists_throwsPNFE() {
        assertThrows(EntityNotFoundException.class, () -> service.remove(2));
    }

    @Test
    void testEdit_notExists_throwsPNFE() {
        assertThrows(EntityNotFoundException.class, () -> service.edit(2, "Petya", "Vasin", 25));
    }

    @Test
    void testEdit_existingPerson_editedPerson() {
        Person person1 = new Person("Name", "Surname", 45);
        service = spy(service);
        doReturn(person1).when(service).get(12);
        service.edit(12, "Vasya", "Pupkin", 35);
        verify(repo, times(1)).save(argThat(person ->
                        person.getFirstName().equals("Vasya") &&
                        person.getLastName().equals("Pupkin") &&
                        person.getAge() == 35));
    }
}
























