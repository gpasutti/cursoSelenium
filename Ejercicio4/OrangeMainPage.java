package clase7.Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OrangeMainPage {

    WebDriver driver;

    public OrangeMainPage (WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public void validateQuickActions (){
        List<WebElement> quickActionsList = driver.findElements(By.xpath("//*[@class='quick-access-item-container']"));

        for (WebElement element : quickActionsList ) {
            System.out.println("--> "+ element.getText());
        }

        Assert.assertEquals(quickActionsList.size(),8, "Se esperaban obtener 8 elementos");
    }

    public OrangeTimesheetsToApprove clickOnTimeSheetsToApprove() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains (text (), 'Timesheets to Approve')]")).click();

        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(7000);

        OrangeTimesheetsToApprove orangeTimesheetsToApprove = new OrangeTimesheetsToApprove(driver);
        return orangeTimesheetsToApprove;
    }



}
