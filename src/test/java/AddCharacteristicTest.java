import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class AddCharacteristicTest extends SeleniumBaseTest {

    @Test
    public void addCharacteristic(){
        String characteristicName = UUID.randomUUID().toString().substring(0,5);
        String lslName = "8";
        String uslName = "10";
        String hbcName = "33";

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
                .typeHbcName(hbcName)
                .submitCreateCharacteristic()
                    .assertCharacteristic(characteristicName, lslName, uslName, hbcName);
    }
}
