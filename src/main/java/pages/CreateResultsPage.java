package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateResultsPage extends HomePage{

    public CreateResultsPage (WebDriver driver){

        super(driver);
    }

    @FindBy(css = "#Sample")
    public WebElement sampleNameTxt;

    @FindBy(css = "#Values" )
    public WebElement resultsTxt;

    @FindBy(css = "input[type=submit]")
    WebElement createResultsBtn;

    public CreateResultsPage typeSampleName(String sampleName){
        sampleNameTxt.sendKeys(sampleName);

        return this;
    }

    public CreateResultsPage typeResults(String results){
        resultsTxt.sendKeys(results);

        return this;
    }

    public ResultsPage submitCreateResults(){
        createResultsBtn.click();

        return new ResultsPage(driver);
    }
}
