package de.telran.person.repo;

import de.telran.person.model.Person;

import java.util.List;

public interface IPersonRepo {

    void save(Person person);

    Person find(int id);

    Person remove(int id);

    List<Person> findAll();

}
