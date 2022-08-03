package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    private static String getPropertyFromFile(String propertyName) throws RuntimeException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = Files.newInputStream(Paths.get("src/test/resources/framework.properties"));
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("Cannot read property value for " +
                    propertyName);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }

    public static String getBaseUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }

    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

}
