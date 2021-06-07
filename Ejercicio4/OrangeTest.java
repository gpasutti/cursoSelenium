package clase7.Ejercicio4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        List<WebElement> quickActionList = orangeMainPage.getQuickActionsList();
        Assert.assertEquals(quickActionList.size(),8, "Se esperaban obtener 8 elementos");

        OrangeTimesheetsToApprovePage orangeTimesheetsToApprove = orangeMainPage.clickOnTimeSheetsToApprove();

        String timesheetPageTitle = orangeTimesheetsToApprove.getTimesheetTitle();
        Assert.assertEquals(timesheetPageTitle, "TITULO ESPERADO", "Se esperaba otro título");

        String timesheetPageURL = orangeTimesheetsToApprove.getTimesheetPageURL();
        Assert.assertEquals(timesheetPageURL, "URL ESPERADA", "Se esperaba otra URL");

        orangeTimesheetsToApprove.getElementsQuantity();

    }


}
