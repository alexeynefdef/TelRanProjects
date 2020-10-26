package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IPersonRepo extends CrudRepository<Person, Integer> {

    Collection<Person> findAll();
}
