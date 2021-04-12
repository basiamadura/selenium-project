import org.testng.annotations.Test;
import pages.LoginPage;

public class MenuTest extends SeleniumBaseTest{

    @Test
    public void menuTest(){
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                    .assertProcessesUrl("http://localhost:4444/Projects")
                    .assertProcessesHeader("Processes")
                .goToCharacteristics()
                    .assertCharacteristicsUrl("http://localhost:4444/Characteristics")
                    .assertCharacteristicsHeader("Characteristics");
                




    }

}