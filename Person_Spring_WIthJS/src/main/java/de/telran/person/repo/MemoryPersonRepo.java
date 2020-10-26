
package de.telran.person.repo;
/*
import de.telran.person.model.Person;
import org.springframework.lang.NonNull;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class MemoryPersonRepo implements IPersonRepo{

    Map<Integer,Person> persons = new HashMap<>();
    AtomicInteger currentID = new AtomicInteger();

    @Override
    public void save(@NonNull Person person) {
        int id = person.getId();
        if (id == 0) {
            id = currentID.incrementAndGet();

            try {
               Field fieldId = Person.class.getDeclaredField("id");
               fieldId.setAccessible(true);
               fieldId.setInt(person,id);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        persons.put(id,person);

    }

    @Override
    public Optional<Person> findById(int id) {
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
*/