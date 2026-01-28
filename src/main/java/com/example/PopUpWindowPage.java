package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class PopUpWindowPage {
    private WebDriver driver;
    WaitAndClickHelpers click=new WaitAndClickHelpers();
    public PopUpWindowPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка ДА
    private By yesButton= By.xpath("//button[text()='Да']");
    private By orderWindow = By.xpath("//*[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    //Кликнуть по кнопке "Да"
    public void clickYesButton (){
        click.waitClick(driver.findElement(yesButton));
    }
    //Проверка что появилось модальное окно о регистрации заказа
    public boolean visibleModalWindow(){
        try {
            return driver.findElement(orderWindow).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
