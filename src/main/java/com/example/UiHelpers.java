package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UiHelpers {
    protected static WebDriver driver;

    public static void setUpDriverAndData() {
        driver = new FirefoxDriver();
        driver.get(UrlData.URLMAINPAGE);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
