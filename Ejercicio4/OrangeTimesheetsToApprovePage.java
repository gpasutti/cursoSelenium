package clase7.Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrangeTimesheetsToApprovePage {
    WebDriver driver;

    public OrangeTimesheetsToApprovePage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public String getTimesheetTitle(){
        String timesheetPageTitle = driver.getTitle();
        return timesheetPageTitle;
    }

    public String getTimesheetPageURL(){
        String timesheetPageURL = driver.getCurrentUrl();
        return timesheetPageURL;
    }

    public void getElementsQuantity(){
        WebElement quantityElement = driver.findElement(By.xpath("//*[@class='summary']"));
        String elementsToBeDisplayed = quantityElement.getText();
        System.out.println("Cantidad de elementos a desplegar: "+elementsToBeDisplayed);
    }



}
