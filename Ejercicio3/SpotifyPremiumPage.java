package clase7.Ejercicio3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SpotifyPremiumPage {

    WebDriver driver;

    public SpotifyPremiumPage (WebDriver remoteDriver){
        this.driver=remoteDriver;
    }

    public void validateH1Elements(){
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));

        System.out.println("Los H1 de la página son: ");
        for (WebElement element : h1List){
            System.out.println(element.getText());
        }

        boolean title1present = false;

        for (WebElement element : h1List){
            if (element.getText().equals("Disfruta 3 meses de Premium gratis")){
                title1present = true;
            }
        }

        boolean title2present = false;
        for (WebElement element : h1List){
            if (element.getText().equals("Beneficios de Premium")){
                title2present = true;
            }
        }

        Assert.assertTrue(title1present);
        Assert.assertTrue(title2present);
    }
}
