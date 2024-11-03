import pages.P01_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_Home {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @Test
    public void LogoutTestCase(){
        new P01_Login(driver).EnterUsername("tomsmith").
                EnterPassword("SuperSecretPassword!").
                ClickOnLogin().ClickOnLogout();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }


}