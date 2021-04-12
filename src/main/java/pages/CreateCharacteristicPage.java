package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCharacteristicPage extends HomePage{

    public CreateCharacteristicPage(WebDriver driver){

        super(driver);
    }

    @FindBy(css = "#ProjectId")
    public WebElement selectProcessELm;

    @FindBy(css = "#Name")
    public WebElement characteristicNameTxt;

    @FindBy(css = "#LowerSpecificationLimit")
    public WebElement lslTxt;

    @FindBy(css = "#UpperSpecificationLimit")
    public WebElement uslTxt;

    @FindBy(css = "#HistogramBinCount")
    public WebElement hbcTxt;

    @FindBy(css = "input[type=submit]")
    public WebElement createCharacteristicBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    public WebElement actErrorShortCharacteristicName;

    public CreateCharacteristicPage typeCharacteristicName(String characteristicName){
        characteristicNameTxt.sendKeys(characteristicName);

        return this;
    }

    public CreateCharacteristicPage selectProcess(String processName){
        new Select(selectProcessELm).selectByVisibleText(processName);

        return this;
    }

    public CreateCharacteristicPage typeLslName(String lslName){
        lslTxt.sendKeys(lslName);

        return this;
    }

    public CreateCharacteristicPage typeUslName(String uslName){
        uslTxt.sendKeys(uslName);

        return this;
    }

    public CreateCharacteristicPage typeHbcName(String hbcName){
        hbcTxt.sendKeys(hbcName);

        return this;
    }

    public CharacteristicsPage submitCreateCharacteristic(){
        createCharacteristicBtn.click();

        return new CharacteristicsPage(driver);
    }

    public CreateCharacteristicPage submitWrongCreateCharacteristic(){
        createCharacteristicBtn.click();

        return new CreateCharacteristicPage(driver);
    }

    public CreateCharacteristicPage assertErrorShortCharacteristicName(String expErrorShortName){
        Assert.assertEquals(actErrorShortCharacteristicName.getText(), expErrorShortName);

        return this;
    }
}
