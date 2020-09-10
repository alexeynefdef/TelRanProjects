package new_tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HobaSkobaTest {

    HobaSkoba hobaSkoba;

    @BeforeEach
    void init() {
        hobaSkoba = new HobaSkoba();
    }

    @Test
    void testBracketsAreCorrect_true1() {
        assertTrue(hobaSkoba.bracketsAreCorrect("[][][]"));
    }

    @Test
    void testBracketsAreCorrect_true2() {
        assertTrue(hobaSkoba.bracketsAreCorrect("[{[[([])]]}]"));
    }

    @Test
    void testBracketsAreCorrect_true3() {
        assertTrue(hobaSkoba.bracketsAreCorrect("[]"));
    }

    @Test
    void testBracketsAreCorrect_false1() {
        assertFalse(hobaSkoba.bracketsAreCorrect("([]"));
    }

    @Test
    void testBracketsAreCorrect_false2() {
        assertFalse(hobaSkoba.bracketsAreCorrect("([]){}["));
    }

    @Test
    void testBracketsAreCorrect_false3() {
        assertFalse(hobaSkoba.bracketsAreCorrect("[))("));
    }

    @Test
    public void testBracesChecker_correctOrder_true() {
        assertTrue(hobaSkoba.bracketsAreCorrect("[[]{()}]"));
    }

    @Test
    public void testBracesChecker_wrongOrder_false() {
        assertFalse(hobaSkoba.bracketsAreCorrect("[]{(}]]"));
    }

    @Test
    public void testBracesChecker_startsWithClosing_false() {
        assertFalse(hobaSkoba.bracketsAreCorrect("]()"));
    }

    @Test
    public void testBracesChecker_oddNumber_false() {
        assertFalse(hobaSkoba.bracketsAreCorrect("(()"));
    }
}