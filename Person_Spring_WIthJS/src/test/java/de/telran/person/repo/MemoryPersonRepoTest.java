package de.telran.person.repo;

import de.telran.person.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryPersonRepoTest {

    MemoryPersonRepo repo;

    @BeforeEach
    void init() {
        repo = new MemoryPersonRepo();
    }

    @Test
    void save_1el_size1() {
        Person toTest = new Person("Vasya","Pupkin",35);
        repo.save(toTest);
        assertEquals(1,repo.persons.size());
    }

    @Test
    void save_3el_size3() {
        Person toTest1 = new Person("Vasya","Pupkin",35);
        Person toTest2 = new Person("Vasya","Pupkin",35);
        Person toTest3 = new Person("Vasya","Pupkin",35);
        repo.save(toTest1);
        repo.save(toTest2);
        repo.save(toTest3);
        assertEquals(3,repo.persons.size());
    }

    @Test
    void save_100el_size100() {
        for (int i = 0; i < 100; i++) {
            repo.save(new Person("Vasya","Pupkin"+i,20+i));
        }
        assertEquals(100,repo.persons.size());
    }

    @Test
    void find_1el_El() {
        Person toTest = new Person("Vasya","Pupkin",35);
        repo.save(toTest);
        assertEquals(toTest,repo.find(toTest.getId()));
    }

    @Test
    void find_3el_El() {
        Person toTest = new Person("Vasya","Pupkin",35);
        Person toTest2 = new Person("Vasya","Pupkin",35);
        Person toTest3 = new Person("Vasya","Pupkin",35);
        repo.save(toTest);
        repo.save(toTest2);
        repo.save(toTest3);
        assertEquals(toTest3,repo.find(3));
    }

    @Test
    void find_100el_elFromTheMiddle() {
        for (int i = 0; i < 100; i++) {
            repo.save(new Person("Vasya","Pupkin"+i,20+i));
        }
        Person expected = new Person("Vasya", "Pupkin49",69);
        expected.setId(50);
        assertEquals(expected,repo.find(50));
    }

    @Test
    void remove_1el_size0() {
        Person toTest = new Person("Vasya","Pupkin",35);
        repo.save(toTest);
        assertEquals(toTest,repo.remove(toTest.getId()));
        assertEquals(0,repo.persons.size());
    }

    @Test
    void remove_3el_size2() {
        Person toTest = new Person("Vasya","Pupkin",35);
        Person toTest1 = new Person("Vasya","Pupkin",35);
        Person toTest2 = new Person("Vasya","Pupkin",35);
        repo.save(toTest);
        repo.save(toTest1);
        repo.save(toTest2);
        assertEquals(toTest1,repo.remove(toTest1.getId()));
        assertEquals(2,repo.persons.size());
    }

    @Test
    void remove_100el_remove99_size1() {
        for (int i = 0; i < 100; i++) {
            repo.save(new Person("Vasya","Pupkin"+i,20+i));
        }
        for (int i = 1; i < 100; i++) {
            assertEquals(repo.find(i),repo.remove(i));
        }
        assertEquals(1,repo.persons.size());
    }

    @Test
    void findAll_100el_ListSize100() {
        for (int i = 0; i < 100; i++) {
            repo.save(new Person("Vasya","Pupkin"+i,20+i));
        }
        for (int i = 1; i < repo.findAll().size(); i++) {
            assertTrue(repo.findAll().contains(repo.find(i)));
        }
        assertEquals(100,repo.findAll().size());
    }
}