package team.opay.internal.config;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static Properties instance = null;

    private AppProperties() {
    }

    @SneakyThrows
    public static synchronized Properties getInstance() {
        if (instance == null) {
            Properties properties = new Properties();
            try (InputStream stream = AppProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
                properties.load(stream);
            }
            instance = properties;
        }
        return instance;
    }
}