package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.TODOPage;

import java.util.List;

public class TODO {

    public WebDriver driver = null;

    TODOPage todo;

    @Given("I am navigated to  TODO application page")
    public void todoApplicationPage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/chromedriver 6");
        driver = new ChromeDriver();
        System.out.println("open application page");
        driver.navigate().to("https://todomvc.com/examples/vue/");
        driver.manage().window().maximize();
    }

    @When("I add new task {string}")
    public void addNewTask(String task) {
        todo = new TODOPage(driver);
        todo.enterTaskAndEnter(task);
    }

    @And("New task is added to TODO list")
    public void verifyNewTaskAdded() throws InterruptedException {
        todo.verifyTaskIsAdded();
        Thread.sleep(2000);
    }

    @And("I click on Active option")
    public void clickActiveButton() {
        todo.clickActiveButton();
    }

    @Then("Newly added task is displayed under active section")
    public void verifyTaskInActiveSection() throws InterruptedException {
        Thread.sleep(2000);
        todo.verifyTaskIsAdded();
    }

    @When("I click on Completed option")
    public void clickCompletedButton() {
        todo.clickCompletedButton();
    }

    @Then("Newly added task is not  under completed section")
    public void verifyTaskNotDisplayedInCompletedSection() throws Exception {
       todo.verifyTaskIsNotDisplayed();
       Thread.sleep(2000);
    }

    @When("I click on check box")
    public void clickCheckBox() {
        todo.clickCheckBox();
    }

    @Then("Task is displayed under completed section")
    public void verifyTaskInCompletedSection() {
        todo.clickCompletedButton();
        todo.verifyTaskIsAdded();
    }

    @Then("Task is not displayed under Active section")
    public void verifyTaskNotDisplayedInActiveSection() throws Exception {
        todo.verifyTaskIsNotDisplayed();
        Thread.sleep(2000);
    }

    @When("I click on checkbox and clear the task")
    public void clearTask() throws InterruptedException {
        todo.clickCheckBox();
        todo.clearTask();
    }

    @Then("Task is not displayed in the list")
    public void verifyTaskIsNotDisplayed() throws Exception {
        todo.verifyTaskIsNotDisplayed();
        Thread.sleep(2000);
    }

    @When("I add more than one task")
    public void addMultipleTask(DataTable task) throws InterruptedException {
        List<String> addTask = task.asList(String.class);
        for (String newTask : addTask) {
            todo.enterTaskAndEnter(newTask);
        }
        Thread.sleep(2000);
    }

    @Then("All the task is displayed in the TODO list")
    public void verifyAllTaskIsDisplayed() {
        int taskSize = todo.getTheCountOfLabel();
        if (taskSize > 0) {
            System.out.println("Multiple task are added");
        } else {
            System.out.println("Tasks are not added");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
