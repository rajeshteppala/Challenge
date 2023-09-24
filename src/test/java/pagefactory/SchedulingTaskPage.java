package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class SchedulingTaskPage extends BaseClass {

    /***
     * Label - not schedule
     */
    @FindBy(xpath = "//*[@class='kr-text' and contains(text(),'Not')]")
    private WebElement notScheduleText;

    /***
     * Label - schedule date
     * @param  date Scheduling date
     * @return the xpath value
     */
    private WebElement selectDate(int date) {
        String xpathExpression = "//*[@class='kr-text' and contains(text(),'" + date + "')]";
        return driver.findElement(By.xpath(xpathExpression));
    }

    /***
     * Button - Save
     */
    @FindBy(xpath = "//*[@class='kr-text' and contains(text(),'Save')]")
    private WebElement saveButton;

    /***
     * Button - Close
     */
    @FindBy(xpath = "//*[@class='kr-view' and @data-test-id='button-close']")
    private WebElement closeButton;

    /***
     * Label - schedule date range
     * @param  date1,date2
     * @return the xpath value
     */
    private WebElement verifySelectedDateRange(int date1, int date2) {
        String xpathExpression = ".//div[@class='kr-text' and contains(text(),'Sep " + date1 + "') and contains(text(),'Sep " + date2 + "')]";
        return driver.findElement(By.xpath(xpathExpression));
    }

    public SchedulingTaskPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNotScheduleText() {
        actions.click(notScheduleText);
    }

    public void selectSchedulingDate(int date) {
        actions.click(selectDate(date));
    }

    public void clickSaveButton() {
        actions.click(saveButton);
    }

    public void clickCloseButton() {
        actions.click(closeButton);
    }

    public void checkSelectedDateRange(int date1, int date2) {
        actions.verifyIfElementDisplayed(verifySelectedDateRange(date1, date2));
    }
}

