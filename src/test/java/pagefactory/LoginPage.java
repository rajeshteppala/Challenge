package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.BaseClass;

public class LoginPage extends BaseClass {

    /***
     * Text box - Login username
     */
    @FindBy(id = "login_email_login")
    private WebElement userNameTextBox;

    /***
     * Text box - Login password
     */
    @FindBy(id = "login_email_password")
    private WebElement passwordTextBox;

    /***
     * Button - login button
     */
    @FindBy(id = "btn_signin")
    private WebElement loginButton;

    /***
     * Button- Accept all button
     */
    @FindBy(id = "cb-btn-ok")
    private WebElement acceptAllButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String loginName) {
        actions.enter(userNameTextBox, loginName);
    }

    public void enterPassword(String loginPassword) {
        actions.enter(passwordTextBox, loginPassword);
    }

    public void clickLoginButton() {
        actions.click(acceptAllButton);
        actions.click(loginButton);
    }

    public void isLoginScreenDisplayed() {
        actions.verifyIfElementDisplayed(loginButton);
    }
}
