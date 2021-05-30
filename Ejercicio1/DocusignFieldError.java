package clase7.Ejercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DocusignFieldError {

    WebDriver driver;


    public DocusignFieldError(WebDriver remoteDriver){
        this.driver= remoteDriver;
    }

    public void clickGetStartedButton(){
        driver.findElement(By.id("submitMainText_0")).click();
    }

    public void validateErrors() throws InterruptedException {
        List<WebElement> errorList = driver.findElements(By.className("invalid"));
        Thread.sleep(3000);
        Assert.assertEquals(errorList.size(),6, "Se esperaban 6 errores");
    }

}
