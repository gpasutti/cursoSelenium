package ExamenSeleniumBasico;

import clase8.PageObject.SalesforceLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void landingPageTest(){

        WebElement element1 = driver.findElement(By.className("entry-title"));
        System.out.println(element1.getText());

        List<WebElement> titles = driver.findElements(By.tagName("h3"));

        System.out.println("5 primeros títulos y preguntas:");
        for (int i =0; i<=4; i++){
            if (titles.get(i).getText().isEmpty() == false){
                System.out.println("--> "+titles.get(i).getText());
            }
        }

        String URL = "https://allstq.com/most-popular-testng-interview-questions/";
        String title = "Most popular TestNG interview questions - Software Testing Questions";

        Assert.assertEquals(driver.getTitle(), "Most popular TestNG interview questions - Software Testing Questions", "Se esperaba otro título");

        boolean isURLvalid = false;
        if (driver.getCurrentUrl().equals("https://allstq.com/most-popular-testng-interview-questions/")){
            isURLvalid = true;
        }
        Assert.assertTrue(isURLvalid, "Se esperaba otra URL");


        List<WebElement> menuList = driver.findElements(By.className("menu-link"));

        boolean containSelenium= false;
        boolean containJava= false;

        for (WebElement menuElement : menuList){
            if (menuElement.getText().equals("Selenium")){
                containSelenium = true;
            } else if (menuElement.getText().equals("Java")){
                containJava = true;
            }
        }

        Assert.assertTrue(containSelenium, "Se esperaba que el menú contenga Selenium");
        Assert.assertTrue(containJava, "Se esperaba que el menú contenga Java");

    }


    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
