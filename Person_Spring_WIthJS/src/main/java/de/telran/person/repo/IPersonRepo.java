package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IPersonRepo extends CrudRepository<Person, Integer> {

    @Override
    Collection<Person> findAll();

    Collection<Person> findAllByFirstName(String name);

    Collection<Person> findAllByAgeBefore(int age);

    Collection<Person> findAllByAgeGreaterThanEqualAndAgeIsLessThanEqual(int from, int to);

}
