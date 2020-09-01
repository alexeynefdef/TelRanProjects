package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStorage {

    Map<String, StringOperation> operationByName;

    public void init(List<String> paths) throws ClassNotFoundException {
        operationByName = new HashMap<>();
        try{
            for (String path:paths) {
                StringOperation operation = (StringOperation)
                        Class.forName(path).getConstructor().newInstance();
                operationByName.put(operation.getOperationName(),operation);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new OperationStorageInstantiationException(e.getMessage(), e);
        }
    }

    public StringOperation getByName(String name) {
        return operationByName.get(name);
    }
}
