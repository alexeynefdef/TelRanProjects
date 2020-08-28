package org.anefdef.consumer.operation;

public class LowerCaseOperation implements StringOperation{

    private final String NAME = "lower_case";

    @Override
    public String operate(String line) {
       return line.toLowerCase();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
