import org.testng.annotations.Test;
import pages.LoginPage;

public class IncorrectLoginTest extends SeleniumBaseTest{

    @Test
    public void incorrectLoginTest(){
        new LoginPage(driver)
                .incorrectTypeEmail("ssss")
                .typePassword(config.getApplicationPassword())
                .incorrectSubmitLogin()
                .assertErrorEmail();
    }
}
