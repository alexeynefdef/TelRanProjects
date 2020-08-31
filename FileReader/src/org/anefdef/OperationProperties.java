package org.anefdef;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class OperationProperties {

    Properties properties;
    String filePath;
    private static final String OPERATIONS_KEY = "operations";

    public OperationProperties(String filePath) {
        this.properties = new Properties();
        this.filePath = filePath;
    }

    public void load() throws IOException {
        properties.load(new FileReader(filePath));
    }

    public List<String> getOperationPath() {
        String stringPath = properties.getProperty(OPERATIONS_KEY);
        return Arrays.asList(stringPath.split(","));
    }
}
