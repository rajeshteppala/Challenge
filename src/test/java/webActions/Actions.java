package webActions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pagefactory.LoginPage;

import java.util.logging.Logger;

public class Actions implements WebActions {

    Logger logger = Logger.getLogger(LoginPage.class.getName());

    @Override
    public void enter(WebElement element, String value) {
        try{
            element.sendKeys(value);
            logger.info(value + " is entered successfully");
        } catch (NoSuchElementException e){
           throw new NoSuchElementException("Value is not entered and the message is" + e.getMessage());
        }

    }

    @Override
    public void verifyIfElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            logger.info("Element is displayed in the screen");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element is not displayed");
        }
    }

    @Override
    public void click(WebElement element) {
        try {
            element.click();
            logger.info("Element is successfully clicked");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Unble to click the element and the message is" + e.getMessage());
        }
    }
}
