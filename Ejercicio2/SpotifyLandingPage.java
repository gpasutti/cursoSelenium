package clase7.Ejercicio2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SpotifyLandingPage {

    public WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public String getTitle(){
        String landingTitle = driver.getTitle();
        return landingTitle;
    }

    public String getURL(){
        String landingURL = driver.getCurrentUrl();
        return landingURL;
    }

    public SpotifyRegistrationPage clickOnRegistrarse (){
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        SpotifyRegistrationPage spotifyRegistrationPage = new SpotifyRegistrationPage(driver);
        return spotifyRegistrationPage;
    }
}
