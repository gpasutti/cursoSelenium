package clase7.Ejercicio1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DocuSignTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.docusign.com/");
    }


    @Test
    public void docuSignTest() throws InterruptedException {

        DocusignLandingPage docusignLandingPage = new DocusignLandingPage(driver);

        DocusignFreeTrialPage docusignFreeTrial = docusignLandingPage.goToFreeTrial();

        docusignFreeTrial.fillFirstName("Gala");
        docusignFreeTrial.fillLastName("Gomez");
        docusignFreeTrial.fillEmail("test@test.com");
        docusignFreeTrial.fillPhone("011423252621");
        docusignFreeTrial.fillJobTitle("Engineer");
        docusignFreeTrial.selectIndustry();

        List<WebElement> errorList= docusignFreeTrial.getErrorList();

        Assert.assertEquals(errorList.size(),0, "Se esperaba no obtener errores");
    }

    @Test
    public void docuSignFailTest() throws InterruptedException {
        DocusignLandingPage docusignLandingPage = new DocusignLandingPage(driver);

        DocusignFreeTrialPage docusignFreeTrial = docusignLandingPage.goToFreeTrial();
        docusignFreeTrial.clickGetStartedButton();
        List<WebElement> errorList = docusignFreeTrial.getErrorList();

        Thread.sleep(3000);
        Assert.assertEquals(errorList.size(),6, "Se esperaban 6 errores");
    }


}
