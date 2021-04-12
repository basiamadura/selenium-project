import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CorrectRegisterTest extends SeleniumBaseTest{

    @DataProvider
    public Object [][] correctEmail(){
        return new Object[][]{
                {"esty@test.com"},
                {"tests@test.com"},
                {"test1222@test.com"}
        };
    }

    @Test(dataProvider = "correctEmail")
    public void correctRegister(String correctEmails){
        new LoginPage(driver)
                .newRegister()
                .typeRegisterEmail(correctEmails)
                .typeRegisterPassword("Test123$")
                .typeRegisterConfirmPassword("Test123$")
                .submitRegister()
                    .assertWelcome();
    }
}
