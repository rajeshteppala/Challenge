package webActions;

import org.openqa.selenium.WebElement;

public interface WebActions {

    /***
     * Enter the value in the text box
     * @param element Standard Webelement
     * @param value Value to be entered
     */
    void enter(WebElement element, String value);

    /***
     * Verify if the element is displayed in the page
     * @param element Standard Webelement
     */
    void verifyIfElementDisplayed(WebElement element);

    /***
     * Click the element
     * @param element Standard Webelement
     */
    void click(WebElement element);
}
