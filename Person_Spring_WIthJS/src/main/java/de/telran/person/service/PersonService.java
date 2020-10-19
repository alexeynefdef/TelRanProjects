package de.telran.person.service;

import de.telran.person.dto.PersonDto;
import de.telran.person.model.Person;
import de.telran.person.repo.MemoryPersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final MemoryPersonRepo repo;

    public PersonService(MemoryPersonRepo repo) {
        this.repo = repo;
    }

    public Person create(String firstname, String lastname, int age) {
        Person person = new Person(firstname);
        person.setAge(age);
        person.setLastName(lastname);
        return person;
    }

    public List<PersonDto> getAll() {
        return null;
    }

    public Person getPerson(int id) {
        return repo.find(id);
    }

    public Person removePerson(int id) {
        return repo.remove(id);
    }

    public void updatePerson(Person person) {
        repo.save(person);
    }
}

