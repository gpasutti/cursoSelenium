package ExamenSeleniumBasico;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void iniciarSesionPageTest() {

        Assert.assertEquals(driver.getTitle(),"Netflix Argentina - Watch TV Shows Online, Watch Movies Online");

        driver.findElement(By.xpath("//*[@href='/login']")).click();

        Assert.assertEquals(driver.getTitle(),"Netflix");

        List<WebElement> h1List = driver.findElements(By.tagName("h1"));


        boolean singInIsPresent = false;
        for (WebElement h1element : h1List){
            if (h1element.getText().equals("Sign In")){
                singInIsPresent=true;
            }
        }
        Assert.assertTrue(singInIsPresent, "Se esperaba que el título 'Sign In' esté presente ");

        WebElement LoginWithFacebook = driver.findElement(By.className("fb-login"));
        Assert.assertEquals("Login with Facebook", LoginWithFacebook.getText(), "Se esperaba el elemento 'Login with Facebook'");


    }

    @Test
    public void fakeEmailTest() throws InterruptedException {

        Faker faker = new Faker ();
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[contains(text(), 'Get Started')]")).click();

        Thread.sleep(3000);
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        boolean URLcontains = false;
        if (URL.contains("signup")){
                URLcontains = true;
        }

        Assert.assertTrue(URLcontains, "Se esperaba que el texto se encuentre en la URL");
    }



        @DataProvider(name = "emailTest")
        public Object[][] emailNetflixText () {
            return new Object[][]{
                    {"gala145@gmail.com"},
                    {"selenium123@gmail.com"},
                    {"qa1414@test.com"}
            };
        }


    @Test (dataProvider = "emailTest")
    public void dataProviderEmailTest( String anEmail)  {
        driver.findElement(By.name("email")).sendKeys(anEmail);
        driver.findElement(By.xpath("//*[contains(text(), 'Get Started')]")).click();

    }



    @Test
    @Parameters({"tagName"})
    public void printTagsTest(@Optional ("h1") String tagName){

        List <WebElement> parameterList = driver.findElements(By.tagName(tagName));

        System.out.println("Se imprimen los elementos: "+tagName);
        for (WebElement elementList : parameterList){
            System.out.println(elementList.getText());
        }

        }



    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

}