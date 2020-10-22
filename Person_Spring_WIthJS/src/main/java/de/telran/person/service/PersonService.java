package de.telran.person.service;

import de.telran.person.exception.PersonNotFoundException;
import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final String PERSON_NOT_FOUND = "No such person found";
    private final IPersonRepo repo;

    public PersonService(IPersonRepo repo) {
        this.repo = repo;
    }

    public Person create(String firstname, String lastname, int age) {
        Person person = new Person(firstname);
        person.setAge(age);
        person.setLastName(lastname);
        repo.save(person);
        return person;
    }

    public void edit(int id, String firstname, String lastname, int age) {
        Person personToUpdate = get(id);
        personToUpdate.setFirstName(firstname);
        personToUpdate.setLastName(lastname);
        personToUpdate.setAge(age);
        repo.save(personToUpdate);
    }

    public Person remove(int id) {
        Person personToRemove = repo.remove(id);
        if (personToRemove == null) {
            throw new PersonNotFoundException(PERSON_NOT_FOUND);
        } else {
            return personToRemove;
        }
    }

    public Person get(int id) {
        Person person = repo.find(id);
        if (person == null) {
            throw new PersonNotFoundException(PERSON_NOT_FOUND);
        } else {
            return person;
        }
    }

    public List<Person> getAll() {
        return repo.findAll();
    }
}

