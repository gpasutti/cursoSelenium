package clase7.Ejercicio2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SpotifyLandingPage {

    public WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public void validateTitleAndUrlLandingPage(){
        String landingTitle = driver.getTitle();
        String landingURL = driver.getCurrentUrl();

        Assert.assertEquals(landingTitle,"Escuchar es todo - Spotify", "Se esperaba otro título");
        Assert.assertEquals(landingURL, "https://www.spotify.com/ar/", "Se esperaba otra URL");
    }

    public SpotifyRegistrationPage clickOnRegistrarse (){
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        SpotifyRegistrationPage spotifyRegistrationPage = new SpotifyRegistrationPage(driver);
        return spotifyRegistrationPage;
    }
}
