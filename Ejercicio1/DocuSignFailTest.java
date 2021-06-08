package clase7.Ejercicio1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocuSignFailTest {

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

        DocusignFreeTrial docusignFreeTrial = docusignLandingPage.goToFreeTrial();

        DocusignFieldError docusignFieldError = new DocusignFieldError(driver);

        docusignFieldError.clickGetStartedButton();
        docusignFieldError.validateErrors();

    }
}
