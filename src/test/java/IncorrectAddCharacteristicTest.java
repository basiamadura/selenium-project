import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class IncorrectAddCharacteristicTest extends SeleniumBaseTest{

    @Test
    public void incorrectAddCharacteristicTest(){
        String characteristicName = UUID.randomUUID().toString().substring(0,2);
        String lslName = "8";
        String uslName = "10";
        String errorShortName = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToCharacteristics()
                .addNewCharacteristic()
                .selectProcess("DEMO PROJECT")
                .typeCharacteristicName(characteristicName)
                .typeLslName(lslName)
                .typeUslName(uslName)
                .submitWrongCreateCharacteristic()
                    .assertErrorShortCharacteristicName(errorShortName);
    }
}
