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

    public  List<WebElement> getH1elements() {
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));

        System.out.println("Los H1 de la página son: ");
        for (WebElement element : h1List) {
            System.out.println(element.getText());
        }
        return h1List;
    }

}
