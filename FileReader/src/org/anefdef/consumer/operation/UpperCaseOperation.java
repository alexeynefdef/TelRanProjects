package org.anefdef.consumer.operation;

public class UpperCaseOperation implements StringOperation{

    private final String NAME = "upper_case";

    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
