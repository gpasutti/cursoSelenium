package clase7.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
    }


    @Test
    public void spotifyPremiumTest() throws InterruptedException {

        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        Thread.sleep(2000);
        SpotifyPremiumPage spotifyPremiumPage = spotifyLandingPage.clickOnPremium();

        spotifyPremiumPage.validateH1Elements();

    }

}
