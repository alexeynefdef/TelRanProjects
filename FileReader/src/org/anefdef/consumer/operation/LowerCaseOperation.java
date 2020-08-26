package org.anefdef.consumer.operation;

public class LowerCaseOperation implements StringOperation{

    @Override
    public String operate(String line) {
       return line.toLowerCase();
    }

    @Override
    public String getOperationName() {
        return "lower_case";
    }
}
