import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class TestReportTest extends SeleniumBaseTest {

    @Test
    public void testReportTest(){
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lslName = "8";
        String uslName = "10";
        String hbcName = "33";
        String sampleName = "Test";
        String results = "8.0;9.0";
        String expMean = "8.5000";

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
                .goToResults(characteristicName)
                .addResults()
                .typeSampleName(sampleName)
                .typeResults(results)
                .submitCreateResults()
                .backToCharacteristics()
                .goToReport(characteristicName)
                    .assertMean(expMean);
    }
}
