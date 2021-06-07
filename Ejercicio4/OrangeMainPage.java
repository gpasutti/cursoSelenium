package clase7.Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeMainPage {

    WebDriver driver;

    public OrangeMainPage (WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public List<WebElement> getQuickActionsList (){
        List<WebElement> quickActionsList = driver.findElements(By.xpath("//*[@class='quick-access-item-container']"));

        for (WebElement element : quickActionsList ) {
            System.out.println("Quick Actions List:");
            System.out.println("--> "+ element.getText());
        }
        return quickActionsList;
    }

    public OrangeTimesheetsToApprovePage clickOnTimeSheetsToApprove() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains (text (), 'Timesheets to Approve')]")).click();

        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(7000);

        OrangeTimesheetsToApprovePage orangeTimesheetsToApprove = new OrangeTimesheetsToApprovePage(driver);
        return orangeTimesheetsToApprove;
    }



}
