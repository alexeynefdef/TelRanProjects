package org.anefdef.test;

import org.anefdef.task.LogEntry;
import org.anefdef.task.UniqueUsersCollector;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniqueUsersCollectorTest {

    @Test
    void testUniqueUsersCollector1() {
        Stream<LogEntry> toTest = Stream.of(
                new LogEntry("Vasya","pornhub.com"),
                new LogEntry("Vasya","pornhub.com"),
                new LogEntry("Petya","pornhub.com")
        );
        assertEquals(2,toTest.collect(new UniqueUsersCollector()));
    }

    @Test
    void testUniqueUsersCollector2() {
        Stream<LogEntry> toTest = Stream.of(
                new LogEntry("Vasya","pornhub.com"),
                new LogEntry("Masha","pornhub.com"),
                new LogEntry("Petya","pornhub.com")
        );
        assertEquals(3,toTest.collect(new UniqueUsersCollector()));
    }

    @Test
    void testUniqueUsersCollector3() {
        Stream<LogEntry> toTest = Stream.of(
                new LogEntry("Vasya","pornhub.com"),
                new LogEntry("Vasya","pornhub.com"),
                new LogEntry("Vasya","pornhub.com")
        );
        assertEquals(1,toTest.collect(new UniqueUsersCollector()));
    }

}