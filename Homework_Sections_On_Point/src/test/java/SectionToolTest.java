import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionToolTest {

    SectionTool sectionTool = new SectionTool();

    List<Double> points;
    List<Section> sections;

    @BeforeEach
    void init() {
        points = new ArrayList<>();
        sections = new LinkedList<>();
    }

    @Test
    void testGetMaxPointCovers_emptyEmpty_exception() {
        assertThrows(EmptySourceException.class, () -> sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_emptyOneSection_exception() {
        sections.add(new Section(1.1,2.3));
        assertThrows(EmptySourceException.class, () -> sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_onePointEmpty_exception() {
        points.add(0.7);
        assertThrows(EmptySourceException.class, () -> sectionTool.getMaxPointCovers(points,sections));

    }

    @Test
    void testGetMaxPointCovers_onePointOneSectionNotCovered_zero() {
        points.add(0.7);
        sections.add(new Section(1.1,2.3));
        assertEquals(0,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_onePointOneSectionCovered_one() {
        points.add(0.7);
        sections.add(new Section(0.3,2.3));
        assertEquals(1,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_3Points3SectionsCovered_three() {
        points.add(0.7);
        points.add(1.5);
        points.add(3.0);
        sections.add(new Section(0.3,2.3));
        sections.add(new Section(0.9,2.1));
        sections.add(new Section(1.1,4.7));
        assertEquals(3,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_3EqualPoints3EqualSectionsCovered_three() {
        points.add(0.7);
        points.add(0.7);
        points.add(0.7);
        sections.add(new Section(0.3,2.3));
        sections.add(new Section(0.3,2.3));
        sections.add(new Section(0.3,2.3));
        assertEquals(3,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_3Points_3Sections_1CoverEach_one() {
        points.add(1.45);
        points.add(2.45);
        points.add(3.45);
        sections.add(new Section(1,2));
        sections.add(new Section(2,3));
        sections.add(new Section(3,4));
        assertEquals(1,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_10Points16SectionsCovered_4() {
        for (int i = 0; i < 10; i++) {
            points.add(i + 0.45);
        }
        sections.add(new Section(0.31,2.301));
        sections.add(new Section(1.011,2.75));
        sections.add(new Section(1.354,3.35));
        sections.add(new Section(2.293,4.105));
        sections.add(new Section(3.012,4.88));
        sections.add(new Section(3.999,5.015));
        sections.add(new Section(4.339,6.012));
        sections.add(new Section(4.671,6.991));
        sections.add(new Section(4.144,4.995));
        sections.add(new Section(4.678,5.311));
        sections.add(new Section(5.345,6.666));
        sections.add(new Section(5.001,5.999));
        sections.add(new Section(5.677,6.679));
        sections.add(new Section(6.001,7.011));
        sections.add(new Section(6.788,7.012));
        sections.add(new Section(7.671,8.991));

        assertEquals(4,sectionTool.getMaxPointCovers(points,sections));
    }

    @Test
    void testGetMaxPointCovers_10Points16EqualSectionsCovered_16() {
        for (int i = 0; i < 10; i++) {
            points.add(i + 0.45);
        }
        for (int i = 0; i < 16; i++) {
            sections.add(new Section(0.31,2.301));
        }
        assertEquals(16,sectionTool.getMaxPointCovers(points,sections));
    }















}