package org.anefdef.consumer.operation;

public class ReverseOperation implements StringOperation{

    @Override
    public String operate(String line) {
        StringBuilder sb = new StringBuilder(line);
        return sb.reverse().toString();
    }

    @Override
    public String getOperationName() {
        return "reverse";
    }
}
