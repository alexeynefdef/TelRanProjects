package de.telran.person.service;

import de.telran.person.model.Person;
import de.telran.person.repo.IPersonRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
        Person personToRemove = get(id);
        repo.delete(personToRemove);
        return personToRemove;
    }

    public Person get(int id) {
        return repo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(PERSON_NOT_FOUND));
    }

    public List<Person> getAll() {
        return new ArrayList<>(repo.findAll());
    }

    public List<Person> getAllByName(String name) {
        return new ArrayList<>(repo.findAllByFirstName(name));
    }

    public List<Person> getAllByAgeBefore(int age) {
        return new ArrayList<>(repo.findAllByAgeBefore(age));
    }

    public List<Person> getAllByAgeBetween(int from, int to) {
        return new ArrayList<>(repo.findAllByAgeGreaterThanEqualAndAgeIsLessThanEqual(from, to));
    }

    public List<Person> getAllByLastnameLike(String lastname) {
        return new ArrayList<>(repo.findAllByLastNameLike(lastname));
    }

}

