package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    WebElement emailTxt;

    @FindBy(css = "#Password")
    WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    WebElement loginBtn;

    @FindBy(css = "#Email-error")
    WebElement emailErrorTxt;

    @FindBy(css = "a[href^=\"/Account/Register\"")
    WebElement newRegisterElm;

    public LoginPage typeEmail(String email){
        emailTxt.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password){
        passwordTxt.sendKeys(password);

        return this;
    }

    public HomePage submitLogin(){
        loginBtn.click();

        return new HomePage(driver);
    }

    public LoginPage incorrectTypeEmail(String incorrectEmail){
        emailTxt.sendKeys(incorrectEmail);

        return this;
    }

    public LoginPage incorrectSubmitLogin(){
        loginBtn.click();

        return this;
    }

    public CreateAccountPage newRegister(){
        newRegisterElm.click();

        return new CreateAccountPage(driver);
    }

    public LoginPage assertErrorEmail(){
        Assert.assertTrue(emailErrorTxt.isDisplayed(), "The Email field is not a valid e-mail address.");

        return this;
    }
}
