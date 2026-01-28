package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка принятия кук
    private By okCookies = By.id("rcc-confirm-button");
    //Верхняя кнопка "Заказать"
    private By topOrderButton = By.className("Button_Button__ra12g");
    // Нижняя кнопка "Заказать"
    private By downOrderButton = By.xpath("//button[text()='Заказать']");
    //Поля раздела "Вопросы о важном"
    private By faq = By.className("accordion__item");

    //Метод собирает ответы на вопросы
    public List<String> checkFaq() {
        List<WebElement> elements = driver.findElements(faq);
        List<String> responses = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            WebElement element = elements.get(i).findElement(By.className("accordion__panel"));
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (element.getText() != null
                    && !element.getText().isEmpty()
            ));
            String text = elements.get(i)
                    .findElement(By.className("accordion__panel"))
                    .getText();
            responses.add(text);
        }
        return responses;
    }

    // Метод нажимает кнопку согласия с Cookie
    public void clickOkCookies() {
        click.waitClick(driver.findElement(okCookies));
    }

    //метод нажимает верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        click.waitClick(driver.findElement(topOrderButton));
        ;
    }

    //Нажать на нижнюю кнопку "Заказать"
    public void clickDownOrderButton() {
        WebElement element = driver.findElements(downOrderButton).get(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        click.waitClick(element);
    }
}

