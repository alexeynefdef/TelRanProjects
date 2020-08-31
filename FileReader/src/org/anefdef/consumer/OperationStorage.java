package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStorage {

    Map<String, StringOperation> operationByName;

    public void init(List<String> paths) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        operationByName = new HashMap<>();
        for (String path:paths) {
            StringOperation operation = (StringOperation)
                    Class.forName(path).getConstructor().newInstance();
            operationByName.put(operation.getOperationName(),operation);
        }
    }

    public StringOperation getByName(String name) {
        return operationByName.get(name);
    }
}
