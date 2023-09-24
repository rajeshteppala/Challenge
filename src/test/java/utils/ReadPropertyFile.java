package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {

    Properties propertyFile;
    FileInputStream fileDate;

    public ReadPropertyFile() {
        File src = new File("./config/config.properties");

        try {
            fileDate = new FileInputStream(src);
            propertyFile = new Properties();
            propertyFile.load(fileDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (null != fileDate)
            {
                try
                {
                    fileDate.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getApplicationURL() {
        String url = propertyFile.getProperty("baseUrl");
        System.out.println(url);
        return url;
    }

    public String userName() {
        String driverPath = propertyFile.getProperty("userName");
        return driverPath;
    }
}
