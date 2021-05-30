package clase7.Ejercicio4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    }

    @Test
    public void orangeTest() throws InterruptedException {

        OrangeLoginPage orangeLoginPage = new OrangeLoginPage(driver);

        OrangeMainPage orangeMainPage = orangeLoginPage.login();

        OrangeTimesheetsToApprove orangeTimesheetsToApprove = orangeMainPage.clickOnTimeSheetsToApprove();

        orangeTimesheetsToApprove.validateTitleAndURL();
        orangeTimesheetsToApprove.validateElementsQuantity();

    }


}
