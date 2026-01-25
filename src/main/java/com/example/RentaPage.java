package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentaPage {
    private WebDriver driver;
    //Поле для ввода даты аренды
    private By date = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Поле для выбора срока аренды
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //Поле для выбора цвета самоката
    private By color = By.className("Order_Checkboxes__3lWSI");
    //Поле для ввода комментария
    private By comment = By.cssSelector("input[placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private By orderButton = By.xpath("//button[text()='Заказать']");


    //Кликнуть по кнопке "Заказать"
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
}
