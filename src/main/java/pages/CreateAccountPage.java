package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends LoginPage {

    public CreateAccountPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "button[type=submit]")
    WebElement registerBtn;

    @FindBy(css = "#ConfirmPassword")
    WebElement confirmPasswordTxt;

    public CreateAccountPage typeRegisterEmail(String email){
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public CreateAccountPage typeRegisterPassword(String password){
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public CreateAccountPage typeRegisterConfirmPassword(String confirmPassword){
        confirmPasswordTxt.sendKeys(confirmPassword);

        return this;
    }

    public HomePage submitRegister(){
        registerBtn.click();

        return new HomePage(driver);
    }
}
