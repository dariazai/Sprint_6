package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpWindowPage {
    private WebDriver driver;
    public PopUpWindowPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка ДА
    private By yesButton= By.xpath("//button[text()='Да']");
    //Кликнуть по кнопке "Да"
    public void clickYesButton (){
        driver.findElement(yesButton).click();
    }
}
