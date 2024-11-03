import pages.P01_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_Login {

    private WebDriver driver;


    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @Test
    public void LoginWithValidData(){
        new P01_Login(driver).EnterUsername("tomsmith").
                EnterPassword("SuperSecretPassword!").
                ClickOnLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test
    public void LoginWithInValidData(){
        new P01_Login(driver).EnterUsername("tomsmith").
                EnterPassword("SuperSecretPassword").
                ClickOnLogin();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}