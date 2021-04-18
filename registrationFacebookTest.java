package clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    private WebDriver getFacebookDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        return driver;
    }

    @Test
    public void fullRegistrationTest() throws InterruptedException {

        WebDriver driver = getFacebookDriver();
        driver.findElement(By.linkText("Create New Account")).click();

        Thread.sleep(4000);

        WebElement firstname= driver.findElement(By.name("firstname"));
        firstname.sendKeys("John");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Smith");

        WebElement emailMobile = driver.findElement(By.name("reg_email__"));
        emailMobile.sendKeys("555555555");

        WebElement pass = driver.findElement(By.name("reg_passwd__"));
        pass.sendKeys("123456789");

        setBirthdate(driver, "Jun", "26", "1980");

        List <WebElement> genderList = driver.findElements(By.name("sex"));
        WebElement maleGender = genderList.get(1);
        maleGender.click();

    }

    private void setBirthdate(WebDriver driver, String mes, String dia, String año){

        WebElement mesElement = driver.findElement(By.name("birthday_month"));
        Select mesSelector = new Select(mesElement);
        mesSelector.selectByVisibleText(mes);

        WebElement diaElement = driver.findElement(By.name("birthday_day"));
        Select diaSelector = new Select(diaElement);
        diaSelector.selectByVisibleText(dia);

        WebElement yearElement = driver.findElement(By.name("birthday_year"));
        Select añoSelector = new Select(yearElement);
        añoSelector.selectByVisibleText(año);

    }

}
