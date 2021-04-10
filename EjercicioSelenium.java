import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class EjercicioSelenium {

    @Test //Ejercicio 14
        public void ejercicio14Selenium(){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://www.netflix.com/uy/");

            List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
            List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));

            System.out.println("**** Elementos h1 ****");
            for (WebElement h1: listaH1s){
                System.out.println("Elemento h1 --> "+h1.getText());
            }

            System.out.println("**** Elementos h2 ****");
            for (WebElement h2: listaH2s){
                System.out.println("Elemento h2 --> "+h2.getText());
            }

            System.out.println("Refrescando el sitio....");
            driver.navigate().refresh();

            System.out.println("**** Botones ****");
            List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
            for (WebElement botones: listaBotones){
                System.out.println("Botón ---> "+botones.getText());
            }

            List<WebElement> divs = driver.findElements(By.tagName("div"));
            System.out.println("La cantidad de elementos div es: "+ divs.size());

            String tituloDeLaPagina = driver.getTitle();
            System.out.println("El título de la página es: "+tituloDeLaPagina);

            List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
            System.out.println("La cantidad de links es: "+listaLinks.size());

            driver.close();

    }



}
