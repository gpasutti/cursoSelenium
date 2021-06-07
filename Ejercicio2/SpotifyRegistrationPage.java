package clase7.Ejercicio2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SpotifyRegistrationPage {
 WebDriver driver;

 public SpotifyRegistrationPage(WebDriver remoteDriver){
     this.driver = remoteDriver;
 }

    public String getTitle(){
        String registerTitle = driver.getTitle();
        return registerTitle;
    }

    public String getURL(){
        String registerURL = driver.getCurrentUrl();
        return registerURL;
    }

    public void completeEmailField (){
        driver.findElement(By.id("email")).sendKeys("@@@.com");
        driver.findElement(By.id("confirm")).click();
    }

    public String getEmailError(){
        String emailError = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]")).getText();
        return emailError;
    }

}
