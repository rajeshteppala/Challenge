package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.BaseClass;

public class HomePage extends BaseClass {

    /***
     *Button - Header button for adding task
     */
    @FindBy(xpath = "//div[@data-test-id='header-button-add-task']")
    private WebElement addTaskButton;

    /***
     *Textbox - Task title
     */
    @FindBy(xpath = "//input[@data-test-id='dialog-task-adder-name-input']")
    private WebElement taskTitle;

    /***
     *Button - Creat task
     */
    @FindBy(xpath = "//div[@data-test-id='task-adder-dialog-submit']")
    private WebElement createTaskButton;

    /***
     *Button - All open task
     */
    @FindBy(xpath = ".//div[@class='kr-text' and contains(text(),'All open task') ]")
    private  WebElement allOpenTaskButton;

    /***
     *Label - Dashboard
     */
    @FindBy(xpath = ".//div[@class='kr-text' and contains(text(),'Dashboard') ]")
    private WebElement dashboardLabel;

    /***
     *Label - Reports option
     */
     @FindBy(xpath = ".//div[@class='kr-view' and @data-test-id='sidebar-nav-item-reports']")
     private  WebElement reportsLabel;

    /***
     *Label - Quick reports
     */
    @FindBy(xpath = ".//div[@data-test-id='collapsiblesidebar-reports-header-quickReports']")
    private WebElement quickReport;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddTaskButton() {
        actions.click(addTaskButton);
    }

    public void enterTaskTitle(String taskName) {
        actions.enter(taskTitle, taskName);
    }

    public void clickCreateTaskButton() {
        actions.click(createTaskButton);
    }

    public void clickAllOpenTasksOption() {
        actions.click(allOpenTaskButton);
    }

    public void isDashboardScreenDisplayed() {
        actions.verifyIfElementDisplayed(dashboardLabel);
    }

    public void clickReportsOptions(){
        actions.click(reportsLabel);
    }

    public void clickQuickReportsOptions(){
        actions.click(quickReport);
    }
}

