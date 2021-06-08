package clase7.Ejercicio1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocusignLandingPage {

    public WebDriver driver;

    public DocusignLandingPage (WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public DocusignFreeTrialPage goToFreeTrial (){
        driver.findElement(By.xpath("//*[@href='https://go.docusign.com/o/trial']")).click();
        DocusignFreeTrialPage docusignFreeTrial = new DocusignFreeTrialPage(driver);
        return docusignFreeTrial;
    }
}
