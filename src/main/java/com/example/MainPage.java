package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    //Кнопка принятия кук
    private By okCookies = By.id("rcc-confirm-button");
    //Верхняя кнопка "Заказать"
    private By topOrderButton = By.className("Button_Button__ra12g");

    //Поля раздела "Вопросы о важном"
    // Поле первого вопроса
    private By firstQuestionField = By.id("accordion__heading-0");
    // Поле второго вопроса
    private By secondQuestionField = By.id("accordion__heading-1");
    // Поле третьего вопроса
    private By thirdQuestionField = By.id("accordion__heading-2");
    // Поле четвертого вопроса
    private By fourthQuestionField = By.id("accordion__heading-3");
    // Поле пятого вопроса
    private By fifthQuestionField = By.id("accordion__heading-4");
    // Поле шестого вопроса
    private By sixthQuestionField = By.id("accordion__heading-5");
    // Поле седьмого вопроса
    private By seventhQuestionField = By.id("accordion__heading-6");
    // Поле восьмого вопроса
    private By eighthQuestionField = By.id("accordion__heading-7");

    // Метод нажимает кнопку согласия с Cookie
    public void clickOkCookies() {
        driver.findElement(okCookies).click();
    }

    //метод нажимает верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
        //Методы клика на поля "Вопросы о важном"
    //Клик на первый вопрос
        public void clickFirstQuestionField() {
            driver.findElement(firstQuestionField).click();
        }
    //Клик на второй вопрос
    public void clickSecondQuestionField() {
        driver.findElement(secondQuestionField).click();
    }
    //Клик на третий вопрос
    public void clickThirdQuestionField() {
        driver.findElement(thirdQuestionField).click();
    }
    //Клик на четвертый вопрос
    public void clickFourthQuestionField() {
        driver.findElement(fourthQuestionField).click();
    }
    //Клик на пятый вопрос
    public void clickFifthQuestionField() {
        driver.findElement(fifthQuestionField).click();
    }
    //Клик на шестой вопрос
    public void clickSixthQuestionField() {
        driver.findElement(sixthQuestionField).click();
    }
    //Клик на седьмой вопрос
    public void clickSeventhQuestionField() {
        driver.findElement(seventhQuestionField).click();
    }
    //Клик на восьмой вопрос
    public void clickEighthQuestionField() {
        driver.findElement(eighthQuestionField).click();
    }

}

