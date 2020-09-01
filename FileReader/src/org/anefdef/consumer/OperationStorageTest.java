package org.anefdef.consumer;

import org.anefdef.consumer.operation.LowerCaseOperation;
import org.anefdef.consumer.operation.StringOperation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OperationStorageTest {

    OperationStorage storage = new OperationStorage();

    @Test
    void testInit_oneExistingOperation_filledStorage() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        storage.init(Collections.singletonList("org.anefdef.consumer.operation.LowerCaseOperation"));
        assertEquals(1,storage.operationByName.size());
        StringOperation operation = storage.operationByName.get("lower_case");
        assertTrue(operation instanceof LowerCaseOperation);
    }
}