package com.example.pageobject.swaglabs.pagecomponent;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class HeaderComponent {
    WebDriver driver;

    @FindBy(css = "a.shopping_cart_link")
    WebElement buttonCart;
    @FindBy(css = "span.title")
    WebElement pageTitle;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        log.debug("Click on cart");
        buttonCart.click();
    }

    public String getHeadTitle() {
        log.debug("Getting head title");
        return pageTitle.getText();
    }
}
