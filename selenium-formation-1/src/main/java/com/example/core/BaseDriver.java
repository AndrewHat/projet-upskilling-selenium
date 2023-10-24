package com.example.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
    protected WebDriver driver = new FirefoxDriver();

    public WebDriver getDriver() {
        return driver;
    }
}
