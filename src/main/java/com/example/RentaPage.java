package com.example;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentaPage {
    private WebDriver driver;

    public RentaPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле для ввода даты аренды
    private By date = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Поле для выбора срока аренды
    private By rentalPeriod = By.className("Dropdown-control");
    //Поле для выбора цвета самоката
    private By colorField = By.className("Order_Checkboxes__3lWSI");
    //Поле для ввода комментария
    private By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private By orderButton = By.xpath("//button[text()='Заказать']");
    //Поле календаря
    private By calendar = By.className("react-datepicker__month-container");
    // Чек-бокс для выбора черного цвета самоката
    private By blackColor = By.id("black");
    // Чек-бокс для выбора серого цвета самоката
    private By greyColor = By.id("grey");


    //Кликнуть по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElements(orderButton).get(1).click();
    }

    //Заполнение даты
    public void chooseDate(String chooseDate) {
        driver.findElement(date).sendKeys(chooseDate + "\n");

    }

    // Заполнение поля срока аренды
    public void setRentalPeriod(String term) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(
                "//div[@class='Dropdown-option' and text()='" + term + "']")).click();
        ;
    }

    // Выбор цвета самоката
    public void chooseBlack(String color) {
        if (color.equals("чёрный жемчуг")) {
            driver.findElement(blackColor).click();
        } else {
            driver.findElement(greyColor).click();
        }
    }

    //Выбор серого самоката
    public void chooseGrey() {
        driver.findElement(greyColor).click();
    }

    //Зполнение поля "Комментарий"
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Заполнение полей с данными о аренде c черным самокатом
    public void setFullFieldRenta(String chooseDate, String tern, String comment, String color) {
        chooseDate(chooseDate);
        setRentalPeriod(tern);
        setComment(comment);
        chooseBlack(color);
    }
}
