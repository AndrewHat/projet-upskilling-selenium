package com.example.pageobject.swaglabs.cart;

import com.example.pageobject.swaglabs.pagecomponent.HeaderComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Log4j2
public class CartPage {
    WebDriver driver;

    @FindBy(css = "div.inventory_item_price")
    List<WebElement> allItemsPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * @param index item index
     * @return
     */
    public String getPrice(int index) {
        if (allItemsPrice.isEmpty()) {
            log.error("Did not find any price");
            throw new IllegalStateException("list is empty");
        }
        String price = allItemsPrice.get(index).getText();
        log.info("Get price of item at index {} = [{}] ", index, price);
        return price;
    }

    public String getPageTitle() {
        HeaderComponent hc = new HeaderComponent(driver);
        String title = hc.getHeadTitle();
        log.info("Get page title : [{}]", title);
        return title;
    }
}
