package clase7.Ejercicio4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrangeTimesheetsToApprove {
    WebDriver driver;

    public OrangeTimesheetsToApprove(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public void validateTitleAndURL(){
        String timesheetPageTitle = driver.getTitle();
        String timesheetPageURL = driver.getCurrentUrl();

        // NO PUDE VALIDAR URL Y TITULO YA QUE EL SITIO PRESENTA VARIOS PROBLEMAS Y ERRORES AL CARGAR
        // por esto, no pude validar cual es el verdadero título y correcta URL, la página no cargó
        // SE DEJAN PLANTEADOS LOS MÉTODOS

        Assert.assertEquals(timesheetPageTitle, "TITULO ESPERADO", "Se esperaba otro título");
        Assert.assertEquals(timesheetPageURL, "URL ESPERADA", "Se esperaba otra URL");
    }

    public void validateElementsQuantity(){
        WebElement quantityElement = driver.findElement(By.xpath("//*[@class='summary']"));
        String elementsToBeDisplayed = quantityElement.getText();
        System.out.println("Cantidad de elementos a desplegar: "+elementsToBeDisplayed);
    }



}
