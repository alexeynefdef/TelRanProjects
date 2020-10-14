package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryContactRepo implements IContactRepo {

    Map<Integer, Contact> source = new HashMap<>();
    private AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(Contact contact) {
        contact.setId(currentId.incrementAndGet());
        source.put(contact.getId(), contact);
    }

    @Override
    public Contact getById(int id) {
        return source.get(id);
    }

    @Override
    public void edit(Contact contact) {
        source.replace(contact.getId(), contact);
    }

    @Override
    public void removeById(int id) {
        source.remove(id);
    }

    @Override
    public List<Contact> getAll() {
        return source.values()
                .stream()
                .sorted(Comparator.comparingInt(Contact::getId))
                .collect(Collectors.toList());
    }
}

