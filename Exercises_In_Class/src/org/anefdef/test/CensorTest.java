package org.anefdef.test;

import org.anefdef.task.censor.Censor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CensorTest {

    Censor censor;

    @BeforeEach
    void init() {
        Set<String> explicit = Set.of("Bad","BadWord","Worst","Terrible","Disgusting");
        censor = new Censor(explicit);
    }

    @Test
    void testParentalAdvisory() {
        String toTest = "Bad bad BAD word one two one two TERRIBLE Bad woRSt";
        List<String> expected = List.of("Bad","Terrible","Worst");
        assertEquals(expected,censor.parentalAdvisory(toTest));
    }

    @Test
    void testParentalAdvisory_repeatedWord_ListOFOneE() {
        String toTest = "Bad Bad BAD Bad bad bad bAd Bad Bad";
        List<String> expected = List.of("Bad");
        assertEquals(expected,censor.parentalAdvisory(toTest));
    }

    @Test
    void testParentalAdvisory_cleanText_emptyList() {
        String toTest = "word one two one two";
        List<String> expected = new ArrayList<>();
        assertEquals(expected,censor.parentalAdvisory(toTest));
    }

}