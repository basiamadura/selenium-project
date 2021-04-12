package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CharacteristicsPage extends HomePage {
    public CharacteristicsPage(WebDriver driver){

        super(driver);
    }

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//tbody//td[text()='%s']/..";
    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";
    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";

    @FindBy(css = ".title_left h3")
    public WebElement actCharacteristicsHeader;

    @FindBy(linkText = "Add new characteristic")
    public WebElement createCharacteristicBtn;

    public CreateCharacteristicPage addNewCharacteristic(){
        createCharacteristicBtn.click();
        return new CreateCharacteristicPage(driver);
    }

    public ResultsPage goToResults(String characteristicName){
        String resultsBtnXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);
        driver.findElement(By.xpath(resultsBtnXpath)).click();

        return new ResultsPage(driver);
    }

    public ReportPage goToReport(String characteristicName){
        String reportXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH,characteristicName);
        driver.findElement(By.xpath(reportXpath)).click();

        return new ReportPage(driver);
    }

    public CharacteristicsPage assertCharacteristicsUrl(String characteristicsUrl){
        Assert.assertEquals(driver.getCurrentUrl(), characteristicsUrl);

        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader(String expCharacteristicsHeader){
        Assert.assertEquals(actCharacteristicsHeader.getText(), expCharacteristicsHeader);

        return this;
    }

    public CharacteristicsPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount){
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(String.format(characteristicXpath)));

        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);

        return this;
    }
}
