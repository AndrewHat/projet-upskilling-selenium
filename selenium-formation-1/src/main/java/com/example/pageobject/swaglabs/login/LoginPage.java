package com.example.pageobject.swaglabs.login;

import com.example.pageobject.swaglabs.inventory.InventoryPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage {
    By userNameId = By.id("user-name");
    By passwordId = By.id("password");
    By loginId = By.id("login-button");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputUsername(String username) {
        if (username.isEmpty()) log.warn("Username is empty");
        log.info("Input username [{}]", username);
        driver.findElement(userNameId).sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        log.info("Input password [{}]", password);// n'est pas censé exister
        driver.findElement(passwordId).sendKeys(password);
        return this;
    }

    public InventoryPage login() {
        log.info("Logging in");
        driver.findElement(loginId).click();
        return new InventoryPage(driver);
    }
}
