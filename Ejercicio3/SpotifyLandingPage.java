package clase7.Ejercicio3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyLandingPage {
    WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public SpotifyPremiumPage clickOnPremium (){
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/premium/']")).click();
        SpotifyPremiumPage spotifyPremiumPage = new SpotifyPremiumPage(driver);
        return spotifyPremiumPage;
    }
}
