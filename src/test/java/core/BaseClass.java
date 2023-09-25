package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ReadPropertyFile;
import webActions.Actions;
import webActions.WebActions;

public class BaseClass{

    ReadPropertyFile readConfig = new ReadPropertyFile();
    public String baseURL = readConfig.baseURL;
    public String userName = readConfig.userName;
    public String password = readConfig.password;
    public WebDriver  driver;
    public WebActions actions = new Actions();

    public void initialBrowserSetUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("enable-automation");
        driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    public void tearDown() {
        driver.quit();
    }
}
