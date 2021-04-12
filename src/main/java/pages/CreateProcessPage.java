package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProcessPage extends HomePage{

    public CreateProcessPage(WebDriver driver){

        super(driver);
    }

    @FindBy(css = "#Name")
    public WebElement processNameTxt;

    @FindBy(css = "input[type=submit]")
    public WebElement createProcessBtn;

    @FindBy(css = ".text-danger[data-valmsg-for]")
    public WebElement errorProcessName;

    public CreateProcessPage typeProcessName(String processName){
        processNameTxt.sendKeys(processName);

        return this;
    }

    public ProcessesPage submitCreateProcess(){
        createProcessBtn.click();

        return new ProcessesPage(driver);
    }

    public CreateProcessPage submitWrongCreateProcess(){
        createProcessBtn.click();

        return this;
    }

    public CreateProcessPage assertErrorProcessName(String expErrorProcessName){
        Assert.assertEquals(errorProcessName.getText(), expErrorProcessName);

        return this;
    }
}
