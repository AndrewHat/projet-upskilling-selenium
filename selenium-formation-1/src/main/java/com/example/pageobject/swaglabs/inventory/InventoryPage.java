package com.example.pageobject.swaglabs.inventory;

import com.example.pageobject.swaglabs.cart.CartPage;
import com.example.pageobject.swaglabs.pagecomponent.HeaderComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class InventoryPage {
    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement buttonAddBackpackToCart;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InventoryPage addBackPackToCart() {
        log.info("Add backpack to cart");
        buttonAddBackpackToCart.click();
        return this;
    }

    public CartPage openCart() {
        log.info("opening cart page");
        HeaderComponent hc = new HeaderComponent(driver);
        hc.clickCart();
        return new CartPage(driver);
    }
}
