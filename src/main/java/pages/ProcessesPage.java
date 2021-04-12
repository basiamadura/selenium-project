package pages;

import com.sun.deploy.util.URLUtil;
import com.sun.deploy.util.Waiter;
import com.sun.org.glassfish.gmbal.util.GenericConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProcessesPage extends HomePage {

    WebElement waiter;
    private String GENERIC_PROCESS_ROW_XPATH_PROCESS = "//td[text()='%s']/..";

    public ProcessesPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".title_left h3")
    public WebElement actProcessesHeader;

    @FindBy(linkText = "Add new process")
    public WebElement addNewProcessBtn;

    public CreateProcessPage addNewProcess() {
        addNewProcessBtn.click();

        return new CreateProcessPage(driver);
    }

    public ProcessesPage assertProcessesUrl(String processesUrl){
        Assert.assertEquals(driver.getCurrentUrl(), processesUrl);

        return this;
    }

    public ProcessesPage assertProcessesHeader(String expProcessesHeader){
        Assert.assertEquals(actProcessesHeader.getText(), expProcessesHeader);

        return this;
    }

    public ProcessesPage assertProcess (String expProcessName){
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH_PROCESS, expProcessName);
        WebElement processRow = driver.findElement(By.xpath(processXpath));

        return this;
    }
}
