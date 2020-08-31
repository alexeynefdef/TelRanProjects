package org.anefdef.test;

import org.anefdef.consumer.operation.LowerCaseOperation;
import org.anefdef.consumer.operation.StringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseOperationTest {

    StringOperation operation = new LowerCaseOperation();

    @Test
    void testOperate_emptyString_emptyString() {
        assertEquals("", operation.operate(""));
    }

    @Test
    void testOperate_upperCaseString_lowerCaseString() {
        assertEquals("string", operation.operate("STRING"));
    }

    @Test
    void testOperate_mixedCaseString_lowerCaseString() {
        assertEquals("string", operation.operate("StRiNg"));
    }

    @Test
    void testOperate_mixedCharString_lowerCaseMixString() {
        assertEquals("dfg8975()()p&3e6", operation.operate("DfG8975()()P&3e6"));
    }


}