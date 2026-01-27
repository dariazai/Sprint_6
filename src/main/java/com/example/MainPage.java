package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //Кнопка принятия кук
    private By okCookies = By.id("rcc-confirm-button");
    //Верхняя кнопка "Заказать"
    private By topOrderButton = By.className("Button_Button__ra12g");
    // Нижняя кнопка "Заказать"
    private By downOrderButton = By.className("Button_Middle__1CSJM");
    //Поля раздела "Вопросы о важном"
    private By faq = By.className("accordion__item");
    public List checkFaq(){

        List<WebElement> elements = driver.findElements(faq);
        List<String> responses = new ArrayList<>(); // Создаём список для результатов

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            String text = elements.get(i)
                    .findElement(By.className("accordion__panel"))
                    .getText();

            responses.add(text);
        }

        return responses;
    }



    // Метод нажимает кнопку согласия с Cookie
    public void clickOkCookies() {
        driver.findElement(okCookies).click();
    }

    //метод нажимает верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    //Нажать на нижнюю кнопку "Заказать"
    public void clickDownOrderButton() {

        ((JavascriptExecutor) driver).executeScript("arguments.scrollIntoView(true);", downOrderButton);
        driver.findElement(downOrderButton).click();
    }


}

