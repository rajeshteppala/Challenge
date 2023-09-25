package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.BaseClass;

public class OpenTasksPage extends BaseClass {

    /***
     *Button - open task
     */
    private WebElement selectOpenTask(String openTask) {
        return driver.findElement(By.xpath(".//div[@class='kr-text' and contains(text(),'" + openTask + "')]"));
    }

    public OpenTasksPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOpenTask(String openTask) {
        actions.click(selectOpenTask(openTask));
    }
}

