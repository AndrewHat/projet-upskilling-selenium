package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAmazon {
    public static final long WAIT_DURATION = 10;

    @Test
    public void TestNavBarClick() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.fr/");



        driver.manage().window().maximize();

        By navcartID = By.id("nav-cart");
        By acceptCookieCSS = By.cssSelector("input#sp-cc-accept");
//        By navcartXPATH = By.xpath("");

        // Clique sur le bouton "accepter les cookies"
        WebElement buttonAcceptCookie = driver.findElement(acceptCookieCSS);
        buttonAcceptCookie.click();

        // J'attends que le bouton panier apparaisse
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
        // Affectation direct à partir du wait
        WebElement buttonCart =  wait.until(ExpectedConditions.elementToBeClickable(navcartID));
        // Clique sur le bouton panier
        buttonCart.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    private WebElement waitAndClick(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
        return   wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    /**
     * Cas de test
     * 1. Clique sur accepter cookies
     * 2. Clique sur le menu burger qui s'appelle "Toutes"
     * 3. Clique sur Meilleurs vente
     * 4. Attendre l'affichage de l'écran des meilleurs vente (sans sleep)
     */
    @Test
    public void testClickBestSeller() {
        //Votre code :)
    }

    /**
     * Selecteur à chercher sur le site : https://www.saucedemo.com
     * 0. champs User (sans id)
     * 1. Bouton Filtres "Name (A to Z)"
     * 2. Description du tshirt "Bolt T-Shirt"
     * 3. Déroulez menu burger
     * 4. Menu burger : bouton all items
     * 5. Menu burger : bouton logout
     * 6. Ajouter 3 élements dans le panier -> bouton "Remove" du 2eme élément dans le panier
     */
    @Test
    public void testSelector() {
        // 0 Champs User sans id
        By champsUser_css = By.cssSelector("input[name='user-name']");
        By champsUser2_css = By.cssSelector("input[placeholder='Username']");
        By champsUser3_css = By.cssSelector("input[data-test='user-name']");

        // 1 Bouton Filtres "Name (A to Z)
        By boutonSort_css = By.cssSelector("select.product.sort.container");
        By boutonSort2_css = By.cssSelector("[data-test='product_sort_container']");

        // 2 Text du tshirt Bolt tshirt
        By shirtText_css = By.cssSelector("#item_1_title_link~div");

        // 3 bouton menu burger
        By burgerMenu_css = By.cssSelector(".bm-burger-button button");

        // 4 bouton all items
        By allItemsButton_id = By.id("#react-burger-menu-btn");
        By allItemsButton_css = By.cssSelector(".bm-burger-button button");

        // 5 bouton logout
        By logout_button_xpath = By.xpath("//nav/a[3]");
        By logout_button_css = By.cssSelector("nav>a:nth-of-type(3)");
    }


}
