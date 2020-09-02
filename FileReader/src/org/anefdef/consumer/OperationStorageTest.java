package org.anefdef.consumer;

import org.junit.jupiter.api.Test;
import org.anefdef.consumer.operation.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OperationStorageTest {

    OperationStorage storage = new OperationStorage();

    @Test
    void testInit_oneExistingOperation_filledStorage() throws ClassNotFoundException,OperationStorageInstantiationException {
        storage.init(Collections.singletonList("org.anefdef.consumer.operation.LowerCaseOperation"));
        assertEquals(1,storage.operationByName.size());
        StringOperation operation = storage.operationByName.get("lower_case");
        assertTrue(operation instanceof LowerCaseOperation);
    }

    @Test
    void testInit_threeExistingOperations_filledStorage() throws ClassNotFoundException,OperationStorageInstantiationException {
        storage.init(Arrays.asList("org.anefdef.consumer.operation.LowerCaseOperation","org.anefdef.consumer.operation.UpperCaseOperation","org.anefdef.consumer.operation.ReverseOperation"));
        assertEquals(3,storage.operationByName.size());
        StringOperation operation1 = storage.operationByName.get("lower_case");
        StringOperation operation2 = storage.operationByName.get("upper_case");
        StringOperation operation3 = storage.operationByName.get("reverse");

        assertTrue(operation1 instanceof LowerCaseOperation);
        assertTrue(operation2 instanceof UpperCaseOperation);
        assertTrue(operation3 instanceof ReverseOperation);
    }

    @Test
    void testInit_oneExistingOperations_filledStorage_noSuchClass() throws ClassNotFoundException,OperationStorageInstantiationException {
        storage.init(Collections.singletonList("org.anefdef.consumer.operation.UpperCaseOperation"));
        assertEquals(1,storage.operationByName.size());
        StringOperation operation = storage.getByName("lower_case");
        assertFalse(operation instanceof UpperCaseOperation);
    }

    @Test
    void testInit_noExistingOperations_throwsExceptionOnInit() throws OperationStorageInstantiationException {
        assertThrows(ClassNotFoundException.class, () -> storage.init(Collections.singletonList("")));
    }
}