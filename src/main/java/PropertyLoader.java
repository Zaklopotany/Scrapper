import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static Properties properties ;


    static {
        initializeResources();
    }

    private static void initializeResources() {

        try (FileInputStream inputStream = new FileInputStream("my.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);

            if (prop != null) {
                properties = prop;
                System.out.println("properties loaded");
            } else {
                System.out.println("properties null");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
