package ru.ibs.framework.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropManager {

    private static PropManager propManager = null;

    private Properties properties = new Properties();

    private PropManager() {
        loadProperties();
        loadCustomProperties();
    }

    public static PropManager getPropManager() {
        if (propManager == null) {
            propManager = new PropManager();
        }
        return propManager;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomProperties() {
        for (Map.Entry<Object, Object> propertyFromFile : properties.entrySet()) {
            for (Map.Entry<Object, Object> systemProperty : System.getProperties().entrySet()) {
                if ((propertyFromFile.getKey().toString()).equals(systemProperty.getKey().toString())
                        &&
                        !((propertyFromFile.getValue().toString()).equals(systemProperty.getValue().toString()))
                ) {
                    properties.setProperty(propertyFromFile.getKey().toString(), systemProperty.getValue().toString());
                }
            }
        }
    }
}
