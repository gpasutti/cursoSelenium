package clase7.Ejercicio2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        String landingTitle = spotifyLandingPage.getTitle();
        String landingURL = spotifyLandingPage.getURL();
        Assert.assertEquals(landingTitle,"Escuchar es todo - Spotify", "Se esperaba otro título");
        Assert.assertEquals(landingURL, "https://www.spotify.com/ar/", "Se esperaba otra URL");

        Thread.sleep(3000);
        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnRegistrarse();

        Thread.sleep(3000);

        String registerTitle = spotifyRegistrationPage.getTitle();
        String registerURL = spotifyRegistrationPage.getURL();

        Assert.assertEquals(registerTitle,"Registrarte - Spotify", "Se esperaba otro título");
        Assert.assertEquals(registerURL, "https://www.spotify.com/ar/signup/", "Se esperaba otra URL");

        spotifyRegistrationPage.completeEmailField();
        String emailError = spotifyRegistrationPage.getEmailError();

        Assert.assertEquals(emailError, "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba otro texto de error");


    }

}
