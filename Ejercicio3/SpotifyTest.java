package clase7.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        List<WebElement> h1ElementsList= spotifyPremiumPage.getH1elements();

        boolean title1present = false;
        boolean title2present = false;

        for (WebElement element : h1ElementsList){
            if (element.getText().equals("Disfruta 3 meses de Premium gratis")){
                title1present = true;
            }
            if (element.getText().equals("Beneficios de Premium")){
                title2present = true;
            }
        }

        Assert.assertTrue(title1present);
        Assert.assertTrue(title2present);

    }

}
