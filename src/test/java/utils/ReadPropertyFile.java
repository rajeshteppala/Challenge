package utils;

import org.openqa.selenium.NoSuchElementException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadPropertyFile {

    Logger logger = Logger.getLogger(ReadPropertyFile.class.getName());
    public String baseURL;
    public String userName;
    public String password;

    public ReadPropertyFile() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("./config//config.properties");
            properties.load(fileInputStream);

            // Get a specific property
             baseURL = properties.getProperty("baseUrl");
             userName = properties.getProperty("userName");
             password = properties.getProperty("password");

            logger.info("The base URL: " + baseURL);
            logger.info("Login username: " + userName);
            logger.info("Login password: " + password);
        } catch (IOException e) {
            throw new NoSuchElementException("Issue in reading the value from property file");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close(); // Close the file
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
