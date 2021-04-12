import org.testng.annotations.Test;
import pages.LoginPage;

public class HomePageMenuTest extends SeleniumBaseTest {

    @Test
    public void homeMenu(){
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses();
    }
}
