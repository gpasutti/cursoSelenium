package clase7.Ejercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DocusignFreeTrial {

    public WebDriver driver;

    public DocusignFreeTrial (WebDriver remoteDriver){
        this.driver= remoteDriver;
    }

    public void fillFirstName(String aName){
        driver.findElement(By.name("first_name")).sendKeys(aName);
    }

    public void fillLastName (String aLastName){
        driver.findElement(By.name("last_name")).sendKeys(aLastName);
    }

    public void fillEmail (String anEmail){
        driver.findElement(By.name("email")).sendKeys(anEmail);
    }

    public void fillPhone (String aPhone){
        driver.findElement(By.name("phone")).sendKeys(aPhone);
    }

    public void fillJobTitle (String aJob){
        driver.findElement(By.name("title")).sendKeys(aJob);
    }

    public void selectIndustry (){
        WebElement industry = driver.findElement(By.name("ds_industry"));
        Select industrySelector = new Select(industry);
        industrySelector.selectByValue("Government");
    }

    public void validateNoErrors (){
        List<WebElement> errorList = driver.findElements(By.className("invalid"));
        Assert.assertEquals(errorList.size(),0, "Se esperaba no obtener errores");
    }



}
