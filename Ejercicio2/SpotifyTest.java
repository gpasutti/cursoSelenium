package clase7.Ejercicio2;

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
    public void spotifyTest() throws InterruptedException {

        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        spotifyLandingPage.validateTitleAndUrlLandingPage();

        Thread.sleep(3000);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnRegistrarse();

        Thread.sleep(3000);
        spotifyRegistrationPage.validateTitleAndUrlRegistrationPage();

        spotifyRegistrationPage.completeEmailField();
        spotifyRegistrationPage.validateEmailError();

    }

}
