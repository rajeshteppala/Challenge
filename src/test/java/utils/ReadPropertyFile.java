package utils;

import org.openqa.selenium.NoSuchElementException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadPropertyFile {

    Logger logger = Logger.getLogger(ReadPropertyFile.class.getName());
    Properties testData = loadPropertyFile("./src//test//resources//TestData//testdata.properties");
    Properties configData = loadPropertyFile("./config//config.properties");


    public Properties loadPropertyFile(String propertyFile) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(propertyFile);
            properties.load(fileInputStream);
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
        return properties;
    }

    public String getApplicationData(String variableName) {
        String value = testData.getProperty(variableName);
        logger.info("Retrieved value from test data property files " + variableName + " is " + value);
        return value;
    }

    public String getConfigData(String variableName) {
        String value = configData.getProperty(variableName);
        logger.info("Retrieved value from config property files " + variableName + " is " + value);
        return value;
    }

}
