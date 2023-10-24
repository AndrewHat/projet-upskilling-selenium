package features;

import com.example.pageobject.swaglabs.login.LoginPage;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.fail;

@Log4j2
public class TestSwagLabs {
//    Logger log = LogManager.getLogger(TestSwagLabs.class);
    private static final String URL = "https://www.saucedemo.com/";
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        log.info(URL + " -> opened successfully");
    }

    @Test
    public void testLogin() {
        // Arrange
        String user = "standard_user";
        String pwd = "secret_sauce";
        String expectedPrice = "$29.99";

        // Act

        LoginPage lp = new LoginPage(driver);

        String actualFirstPrice = lp
                .inputUsername(user)
                .inputPassword(pwd)
                .login()
                .addBackPackToCart()
                .openCart()
                .getPrice(0);

        log.info("First item price = [" + actualFirstPrice + "]");

        // Assert
        Assert.assertEquals(expectedPrice, actualFirstPrice, "Wrong price");
    }

    /**
     * 1. Login
     * 2. Add item to cart
     * 3. Go To cart
     * 4. Assert title is "Your Cart"
     */
    @Test
    public void testGoToCart() {
        // Arrange
        String user = "standard_user";
        String pwd = "secret_sauce";
        String expectedTitle = "Your Cart";

        // Act
        LoginPage lp = new LoginPage(driver);

        String actualCartTitle= lp
                .inputUsername(user)
                .inputPassword(pwd)
                .login()
                .addBackPackToCart()
                .openCart()
                .getPageTitle();

        // Assert
        Assert.assertEquals(actualCartTitle, expectedTitle, "Wrong Page");
    }

    @AfterMethod
    public void resultScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String name = "screenshot.png";
            try {
                FileUtils.copyFile(scrFile, new File("test-output/screenshots/"+name));
            } catch (IOException e) {
                log.error("Screenshot failed :( !");
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        log.info("Teardown successful !");
    }
}
