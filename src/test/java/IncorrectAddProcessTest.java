import org.testng.annotations.Test;
import pages.LoginPage;

public class IncorrectAddProcessTest extends SeleniumBaseTest{

    @Test
    public void incorrectAddProcessTest(){
        String shortProcessName = "ab";
        String expErrorProcessName = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess()
                .typeProcessName(shortProcessName)
                .submitWrongCreateProcess()
                    .assertErrorProcessName(expErrorProcessName);
    }
}
