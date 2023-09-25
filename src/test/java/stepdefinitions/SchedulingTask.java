package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.OpenTasksPage;
import pagefactory.SchedulingTaskPage;

import java.time.Duration;

public class SchedulingTask{

    public WebDriver driver ;
    BaseClass baseClass = new BaseClass();
    LoginPage loginPage;
    HomePage homePage;
    SchedulingTaskPage schedulingTaskPage;
    OpenTasksPage openTasksPage;

   @Before
   public void launchBrowserApplication(){
       baseClass.initialBrowserSetUp();
       driver = baseClass.driver;
   }
    @Given("User navigates to the application")
    public void isLoginScreenDisplayed(){
        loginPage = new LoginPage(driver);
        loginPage.isLoginScreenDisplayed();
    }

    @When("User enters the username")
    public void enterUsername() {
        loginPage.enterUsername(baseClass.userName);
    }

    @And("User enters the password")
    public void enterPassword() {
        loginPage.enterPassword(baseClass.password);
    }

    @And("Clicks on the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User navigates to the application dashboard")
    public void verifyDashboardScreen() {
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.isDashboardScreenDisplayed();
   }

    @And("User clicks on add button")
    public void clickAddButton(){
       homePage.clickAddTaskButton();
    }

    @And("User enters the title '{}'")
    public void enterTaskTitle(String taskTitle){
       homePage.enterTaskTitle(taskTitle);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @And("User clicks on create task button")
    public void clickCreateTaskButton(){
       homePage.clickCreateTaskButton();
    }

    @And("User clicks on the no schedule option")
    public void clickNoScheduleOption(){
       schedulingTaskPage = new SchedulingTaskPage(driver);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       schedulingTaskPage.clickNotScheduleText();
    }

    @And("User selects the start date '{int}'")
        public void selectTheStartDate(int startDate){
        schedulingTaskPage.selectSchedulingDate(startDate);
        }

    @And("user Selects the end date '{int}'")
    public void selectTheEndDate(int endDate){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        schedulingTaskPage.selectSchedulingDate(endDate);
    }

    @And("User clicks on close button")
    public void clickCloseButton(){
       schedulingTaskPage.clickSaveButton();
       schedulingTaskPage.clickCloseButton();
    }

    @And("User clicks on record option")
    public void clickRecordButton(){
       homePage.clickReportsOptions();
    }

    @And("User clicks on quick records option")
    public void clickQuickRecordsOption(){
       homePage.clickQuickReportsOptions();
    }

    @And("User clicks on open all task option")
    public void clickOpenAllTaskButton(){
        homePage.clickAllOpenTasksOption();
    }

    @And("User clicks on existing task '{}'")
    public void clickOnExistingTask(String existingTask){
       openTasksPage = new OpenTasksPage(driver);
       openTasksPage.clickOpenTask(existingTask);
    }

    @And("Verify the scheduled date range is from '{int}' to '{int}'")
    public void verifyScheduledDateRange(int date1, int date2){
       schedulingTaskPage.checkSelectedDateRange(date1,date2);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void closeBrowser(){
        baseClass.tearDown();
    }
}
