package org.anefdef.test;

import org.anefdef.consumer.operation.ReverseOperation;
import org.anefdef.consumer.operation.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOperationTest {

    StringOperation operation = new ReverseOperation();

    @Test
    void testOperate_emptyString_emptyString() {
        assertEquals("",operation.operate(""));
    }

    @Test
    void testOperate_oneChar_oneChar() {
        assertEquals("e",operation.operate("e"));
    }

    @Test
    void testOperate_simpleLine_reversedLine() {
        assertEquals("olleH",operation.operate("Hello"));
    }

    @Test
    void testOperate_mixedLine_reversedLine() {
        assertEquals("$eerf6jF4",operation.operate("4Fj6free$"));
    }

    @Test
    void testOperate_mixedLineWithSpace_reversedLine() {
        assertEquals("eno rehtona dna $eerf6jF4",operation.operate("4Fj6free$ and another one"));
    }



}











