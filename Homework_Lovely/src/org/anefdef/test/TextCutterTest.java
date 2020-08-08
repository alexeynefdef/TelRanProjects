package org.anefdef.test;

import org.anefdef.TextCutter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextCutterTest {

    String input = "У нас было два пакетика травы, семьдесят пять ампул мескалина, " +
            "5 пакетиков диэтиламида лизергиновой кислоты или ЛСД, солонка, наполовину наполненная кокаином," +
            " и целое море разноцветных амфетаминов, барбитуратов и транквилизаторов, " +
            "а так же литр текилы, литр рома, ящик «Бадвайзера», пинта чистого эфира," +
            " и 12 пузырьков амилнитрита. Не то, чтобы всё это было категорически необходимо в поездке, " +
            "но если уж начал собирать коллекцию, то к делу надо подходить серьёзно.";

    TextCutter cutter = new TextCutter();

    @Test
    void testCutTheText_emptyTextAnd0() {
        assertEquals(null,cutter.cutTheText("",0));
    }

    @Test
    void testCutTheText_emptyTextAnd5() {
        assertEquals(null,cutter.cutTheText("",5));
    }

    @Test
    void testCutTheText_textAnd0() {
        assertEquals(null,cutter.cutTheText(input,0));
    }

    @Test
    void testCutTheText_textAnd2() {
        assertEquals("У",cutter.cutTheText(input,2));
    }

    @Test
    void testCutTheText_textAnd10() {
        assertEquals("У нас было",cutter.cutTheText(input,10));
    }

    @Test
    void testCutTheText_textAnd20() {
        assertEquals("У нас было два",cutter.cutTheText(input,20));
    }

    @Test
    void testCutTheText_textAnd200() {
        assertEquals("У нас было два пакетика травы, " +
                "семьдесят пять ампул мескалина, " +
                "5 пакетиков диэтиламида лизергиновой кислоты или ЛСД," +
                " солонка, наполовину наполненная кокаином," +
                " и целое море разноцветных амфетаминов",cutter.cutTheText(input,200));
    }


}