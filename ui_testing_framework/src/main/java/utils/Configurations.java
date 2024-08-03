package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    public static String BASE_URL;
    public static String BROWSER;
    public static String ENV;
    static FileInputStream inputStream;
    static Properties props;

    static {
        try {
            props = new Properties();
            inputStream = new FileInputStream("src/main/resources/configs/configuration.properties");
            props.load(inputStream);
            BROWSER = System.getProperty("browser", props.getProperty("browser"));
            BASE_URL = System.getProperty("base.url", props.getProperty("base.url"));
            ENV = System.getProperty("env", props.getProperty("env"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
