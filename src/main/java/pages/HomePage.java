package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends LoginPage {

    public HomePage(WebDriver driver){

        super(driver);
    }

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;

    @FindBy(css = ".menu-workspace")
    public WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    public WebElement processesMenu;

    @FindBy(css = "a[href$=Characteristics")
    public WebElement characteristicsMenu;

    @FindBy(css = ".menu-home")
    public WebElement homeNav;

    @FindBy(css = "a[href$=Dashboard")
    public WebElement menuDashboard;

    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));

        return parent.getAttribute("class").contains("active");
    }

    public ProcessesPage goToProcesses() {
        if (!isParentExpanded(workspaceNav))
            workspaceNav.click();

        processesMenu.click();

        return new ProcessesPage(driver);
    }

    public HomePage assertWelcome(){
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"));

        return this;
    }

    public CharacteristicsPage goToCharacteristics(){
        if(!isParentExpanded(workspaceNav))
            workspaceNav.click();

        characteristicsMenu.click();

        return new CharacteristicsPage(driver);
    }
}
