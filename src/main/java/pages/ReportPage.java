package pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends HomePage{

    public ReportPage(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;

    public ReportPage assertMean(String expMean){
        Assert.assertEquals(meanCell.getText(), expMean);

        return this;
    }
}
