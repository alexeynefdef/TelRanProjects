package org.anefdef.test;

import org.anefdef.consumer.operation.StringOperation;
import org.anefdef.consumer.operation.UpperCaseOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperCaseOperationTest {

    StringOperation operation = new UpperCaseOperation();

    @Test
    void testOperate_emptyString_emptyString() {
        assertEquals("", operation.operate(""));
    }

    @Test
    void testOperate_upperCaseString_lowerCaseString() {
        assertEquals("STRING", operation.operate("string"));
    }

    @Test
    void testOperate_mixedCaseString_lowerCaseString() {
        assertEquals("STRING", operation.operate("StRiNg"));
    }

    @Test
    void testOperate_mixedCharString_lowerCaseMixString() {
        assertEquals("DFG8975()()P&3E6", operation.operate("DfG8975()()P&3e6"));
    }
}