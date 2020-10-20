package de.telran.person.repo;

import de.telran.person.model.Person;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryPersonRepo implements IPersonRepo{

    Map<Integer,Person> persons = new HashMap<>();
    AtomicInteger currentID = new AtomicInteger();

    @Override
    public void save(Person person) {
        int id = person.getId();
        if (id == 0) {
            id = currentID.incrementAndGet();
            person.setId(id);
        } else {
            persons.put(id,person);
        }
    }

    @Override
    public Person find(int id) {
        return persons.get(id);
    }

    @Override
    public Person remove(int id) {
        return persons.remove(id);
    }

    @Override
    public List<Person> findAll() {
        return persons.values().stream().collect(Collectors.toList());
    }
}
