import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSeparatorTest {

    StringSeparator separator;

    @BeforeEach
    void init() {
        separator = new StringSeparator();
    }

    @Test
    void testIsValid_emptyString_false() {
        assertFalse(separator.isValid(""));
    }

    @Test
    void testIsValid_uniqueString_false() {
        assertFalse(separator.isValid("abcd"));
    }

    @Test
    void testIsValid_validString_true() {
        assertTrue(separator.isValid("abcc"));
    }

    @Test
    void testIsValid_HelloString_true() {
        assertTrue(separator.isValid("Hello"));
    }

    @Test
    void testDoStuff_emptyString_null() {
        assertNull(separator.doStuff(2, ""));
    }

    @Test
    void testDoStuff_emptyStringAndZero_null() {
        assertNull(separator.doStuff(0, ""));
    }

    @Test
    void testDoStuff_oneCharString_null() {
        assertNull(separator.doStuff(2, "a"));
    }

    @Test
    void testDoStuff_HelloString_2ElList() {
        var expected = new ArrayList<>(List.of("ell", "llo"));
        assertEquals(expected,separator.doStuff(3,"Hello"));
    }

    @Test
    void testDoStuff_HelloString_2elList() {
        var expected = new ArrayList<>(List.of("Hell", "ello"));
        assertEquals(expected,separator.doStuff(4,"Hello"));
    }

    @Test
    void testDoStuff_HelopdfString_2elList() {
        var expected = new ArrayList<>(Collections.emptyList());
        assertEquals(expected,separator.doStuff(3,"Helopdf"));
    }

    @Test
    void testDoStuff_mixedString_emptyList() {
        var expected = new ArrayList<>(Collections.emptyList());
        assertEquals(expected,separator.doStuff(3,"He3lo4p56df"));
    }

    @Test
    void testDoStuff_mixedString_2eList() {
        var expected = new ArrayList<>(List.of("o44","44p"));
        assertEquals(expected,separator.doStuff(3,"He3lo44p56df"));
    }








}