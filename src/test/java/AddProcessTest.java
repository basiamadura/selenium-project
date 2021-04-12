import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class AddProcessTest extends SeleniumBaseTest{

    @Test
    public void addProcess(){
        String processname = UUID.randomUUID().toString().substring(0,10);

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess()
                .typeProcessName(processname)
                .submitCreateProcess()
                    .assertProcess(processname);
    }
}
