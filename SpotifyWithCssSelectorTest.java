package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyWithCssSelectorTest {

    private WebDriver getSpotifyDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }

    @Test
    public void spotifyByPlaceHolder() throws InterruptedException {

        WebDriver driver = getSpotifyDriver();
        driver.findElement(By.cssSelector("input[placeholder=\"Introduce tu correo electrónico.\"]")).sendKeys("gala123@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=\"Vuelve a introducir tu correo electrónico.\"]")).sendKeys("gala123@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=\"Crea una contraseña.\"]")).sendKeys("hellopassword");
        driver.findElement(By.cssSelector("input[placeholder=\"Introduce un nombre de perfil.\"]")).sendKeys("galampasutti");

        driver.findElement(By.cssSelector("input[placeholder=\"DD\"]")).sendKeys("09");

        WebElement month = driver.findElement(By.cssSelector("select[name=\"month\"]"));
        Select monthSelector = new Select(month);
        monthSelector.selectByValue("05");
        driver.findElement(By.cssSelector("input[placeholder=\"AAAA\"]")).sendKeys("1994");

        /** DE LA CONSULTA VÍA EMAIL:
        List<WebElement> genderList = driver.findElements(By.name("gender"));
        Assert.assertEquals(genderList.size(),3);

        WebElement femaleGender = genderList.get(1);
        femaleGender.click();
         */

    }

}
