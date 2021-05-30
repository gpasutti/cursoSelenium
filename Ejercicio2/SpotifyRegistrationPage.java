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

    public void validateTitleAndUrlRegistrationPage(){
        String registroTitle = driver.getTitle();
        String registroURL = driver.getCurrentUrl();

        Assert.assertEquals(registroTitle,"Registrarte - Spotify", "Se esperaba otro título");
        Assert.assertEquals(registroURL, "https://www.spotify.com/ar/signup/", "Se esperaba otra URL");
    }

    public void completeEmailField (){
        driver.findElement(By.id("email")).sendKeys("@@@.com");
        driver.findElement(By.id("confirm")).click();
    }

    public void validateEmailError(){
        WebElement emailError = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        Assert.assertEquals(emailError.getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba otro texto de error");

    }

}
