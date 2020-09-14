package org.anefdef.test;

import org.anefdef.task.LogEntry;
import org.anefdef.task.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class LogServiceTest {

    LogService service;

    @BeforeEach
    void init() {
        service = new LogService();
    }

    @Test
    void testSumOfEntriesByUrl0() {
        List<LogEntry> logg = List.of();
        var expected = Map.of();
        assertEquals(expected,service.sumOfEntriesByUrl(logg));
    }

    @Test
    void testSumOfEntriesByUrl1() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org"),
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",2L,"petrosyan-fanclub.ru",1L,"kotyatki.io",1L);
        assertEquals(expected,service.sumOfEntriesByUrl(logg));
    }

    @Test
    void testSumOfEntriesByUrl2() {
        var logg = List.of(
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",1L,"petrosyan-fanclub.ru",1L,"kotyatki.io",1L);
        assertEquals(expected,service.sumOfEntriesByUrl(logg));
    }

    @Test
    void testSumOfEntriesByUrl3() {
        var logg = List.of(
                new LogEntry("Petya","bash.org")
                ,new LogEntry("Petya","bash.org")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",3L);
        assertEquals(expected,service.sumOfEntriesByUrl(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrl0() {
        List<LogEntry> logg = List.of();
        var expected = Map.of();
        assertEquals(expected,service.sumOfUniqueUsersByUrl(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrl1() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org"),
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",2,"petrosyan-fanclub.ru",1,"kotyatki.io",1);
        assertEquals(expected,service.sumOfUniqueUsersByUrl(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrl2() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org")
                , new LogEntry("Vasya","bash.org")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",3);
        assertEquals(expected,service.sumOfUniqueUsersByUrl(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrl3() {
        var logg = List.of(
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",1,"petrosyan-fanclub.ru",1,"kotyatki.io",1);
        assertEquals(expected,service.sumOfUniqueUsersByUrl(logg));
    }

    @Test
    void testSumOfUniqueUrlEntriesByUsers0() {
        List<LogEntry> logg = List.of();
        var expected = Map.of();
        assertEquals(expected,service.sumOfUniqueUrlEntriesByUsers(logg));
    }

    @Test
    void testSumOfUniqueUrlEntriesByUsers1() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org"),
                new LogEntry("Oleg","kotyatki.io"),
                new LogEntry("Manya","bash.org"),
                new LogEntry("Oleg","petrosyan-fanclub.ru"),
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("Oleg",3,"Manya",2,"Vasya",1,"Petya",1);
        assertEquals(expected,service.sumOfUniqueUrlEntriesByUsers(logg));
    }

    @Test
    void testSumOfUniqueUrlEntriesByUsers2() {
        var logg = List.of(
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("Manya",1,"Vasya",1,"Petya",1);
        assertEquals(expected,service.sumOfUniqueUrlEntriesByUsers(logg));
    }

    @Test
    void testSumOfUniqueUrlEntriesByUsers3() {
        var logg = List.of(
                new LogEntry("Petya","bash.org")
                ,new LogEntry("Petya","bash.org")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("Petya",1);
        assertEquals(expected,service.sumOfUniqueUrlEntriesByUsers(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrlWithCustomCollector0() {
        List<LogEntry> logg = List.of();
        var expected = Map.of();
        assertEquals(expected,service.sumOfUniqueUsersByUrlWithCustomCollector(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrlWithCustomCollector1() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org"),
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",2,"petrosyan-fanclub.ru",1,"kotyatki.io",1);
        assertEquals(expected,service.sumOfUniqueUsersByUrlWithCustomCollector(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrlWithCustomCollector2() {
        var logg = List.of(
                new LogEntry("Oleg","bash.org")
                , new LogEntry("Vasya","bash.org")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",3);
        assertEquals(expected,service.sumOfUniqueUsersByUrlWithCustomCollector(logg));
    }

    @Test
    void testSumOfUniqueUsersByUrlWithCustomCollector3() {
        var logg = List.of(
                new LogEntry("Vasya","petrosyan-fanclub.ru")
                ,new LogEntry("Manya","kotyatki.io")
                ,new LogEntry("Petya","bash.org"));
        var expected = Map.of("bash.org",1,"petrosyan-fanclub.ru",1,"kotyatki.io",1);
        assertEquals(expected,service.sumOfUniqueUsersByUrlWithCustomCollector(logg));
    }
}