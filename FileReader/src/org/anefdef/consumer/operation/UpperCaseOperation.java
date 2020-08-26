package org.anefdef.consumer.operation;

public class UpperCaseOperation implements StringOperation{

    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getOperationName() {
        return "upper_case";
    }
}
