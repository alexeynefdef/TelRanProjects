package org.anefdef.consumer.operation;

public class ReverseOperation implements StringOperation{

    private final String NAME = "reverse";

    @Override
    public String operate(String line) {
        StringBuilder sb = new StringBuilder(line);
        return sb.reverse().toString();
    }

    @Override
    public String getOperationName() {
        return NAME;
    }
}
