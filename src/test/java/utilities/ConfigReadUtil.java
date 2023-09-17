package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReadUtil {


    public static Properties loadPropertyFile(String filePath) throws IOException {
        // Read from properties file
        File file = new File(filePath);
        Properties prop = new Properties();

        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(file);
        prop.load(fileInputStream);

        return prop;

    }

    public static String getPropertyValue(String key) throws IOException {

        Properties prop = loadPropertyFile("src/main/resources/config.properties");
        return prop.getProperty(key);
    }
}
