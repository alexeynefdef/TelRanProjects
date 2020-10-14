package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryContactRepoTest {

    MemoryContactRepo repository;
    Contact vasya;
    Contact petya;
    Contact masha;

    @BeforeEach
    void init() {
        repository = new MemoryContactRepo();

        vasya = new Contact("Vasya","123456");

        petya = new Contact("Petya","098765");

        masha = new Contact("Masha","111222333");
    }

    @Test
    void testGetAll_EmptySource_EmptyList() {
        assertEquals(Collections.EMPTY_LIST,repository.getAll());
    }

    @Test
    void testAddAndGetAll_OneEl_OneElList() {
        repository.add(vasya);
        Contact fromRepo = repository.getById(1);
        assertEquals(1,repository.getAll().size());
        assertEquals(vasya.name, fromRepo.name);
        assertEquals(vasya.number, fromRepo.number);
    }

    @Test
    void testAddAndGetAll_threeEl_threeElList() {
        repository.add(vasya);
        repository.add(petya);
        repository.add(masha);
        Contact fromRepo = repository.getById(1);
        assertEquals(3,repository.getAll().size());
        assertEquals(List.of(vasya,petya,masha),repository.getAll());
        List<Contact> contacts = repository.getAll();
        Contact vasyaFromRepo = contacts.stream()
                .filter(contact -> contact.id == vasya.id)
                .findFirst()
                .get();
        Contact petyaFromRepo = contacts.stream()
                .filter(contact -> contact.id == petya.id)
                .findFirst()
                .get();
        Contact mashaFromRepo = contacts.stream()
                .filter(contact -> contact.id == masha.id)
                .findFirst()
                .get();
        assertEquals(vasya.name, vasyaFromRepo.name);
        assertEquals(vasya.number, vasyaFromRepo.number);
        assertEquals(petya.name, petyaFromRepo.name);
        assertEquals(petya.number, petyaFromRepo.number);
        assertEquals(masha.name, mashaFromRepo.name);
        assertEquals(masha.number, mashaFromRepo.number);
    }

    @Test
    void testGet_threeEl_exists() {
        repository.add(vasya);
        repository.add(petya);
        repository.add(masha);

        Contact mashaFromRepo = repository.getById(3);
        assertEquals(masha.name, mashaFromRepo.name);
        assertEquals(masha.number, mashaFromRepo.number);
    }

    @Test
    void testGet_threeEl_notExists() {
        repository.add(vasya);
        repository.add(petya);
        repository.add(masha);

        Contact fromRepo = repository.getById(-1);
        assertNull(fromRepo);
    }

    @Test
    void testRemoveById_threeEl_exists() {
        repository.add(vasya);
        repository.add(petya);
        repository.add(masha);

        repository.removeById(vasya.id);
        Contact removed = repository.getById(vasya.id);
        assertNull(removed);
        assertEquals(2,repository.getAll().size());
        assertFalse(repository.getAll().contains(vasya));
    }

    @Test
    void testRemoveById_threeEl_notExists() {
        repository.add(vasya);
        repository.add(masha);

        repository.removeById(petya.id);
        Contact removed = repository.getById(petya.id);
        assertNull(removed);
        assertEquals(2,repository.getAll().size());
        assertFalse(repository.getAll().contains(petya));
    }

    @Test
    void testEdit_threeEl_exists() {
        repository.add(vasya);
        repository.add(petya);
        repository.add(masha);

        Contact petyaToChange = new Contact("pet", "5544");
        petyaToChange.setId(petya.id);

        repository.edit(petyaToChange);

        Contact petyaFromRepo = repository.getById(petya.id);
        assertEquals(petyaToChange.name, petyaFromRepo.name);
        assertEquals(petyaToChange.number, petyaFromRepo.number);

        assertEquals(petyaToChange,repository.getById(petyaToChange.id));
    }







}