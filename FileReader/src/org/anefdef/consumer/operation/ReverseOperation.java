package org.anefdef.consumer.operation;

public class ReverseOperation implements StringOperation{

    private static final String NAME = "reverse";

    @Override
    public String operate(String line) {
        return new StringBuilder(line).reverse().toString();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
