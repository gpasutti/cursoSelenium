package clase7.Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLoginPage {

    WebDriver driver;

    public OrangeLoginPage (WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public OrangeMainPage login() throws InterruptedException {
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        OrangeMainPage orangeMainPage = new OrangeMainPage(driver);
        return orangeMainPage;

    }
}
