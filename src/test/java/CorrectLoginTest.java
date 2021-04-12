import org.testng.annotations.Test;
import pages.LoginPage;

public class CorrectLoginTest extends SeleniumBaseTest {

    @Test
    public void correctLoginTest(){
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                    .assertWelcome();
    }
}
