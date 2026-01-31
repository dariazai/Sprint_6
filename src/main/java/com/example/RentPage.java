package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RentPage {
    private final WebDriver driver;
    WaitAndClickHelpers click = new WaitAndClickHelpers();

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле для ввода даты аренды
    private final By date = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Поле для выбора срока аренды
    private final By rentalPeriod = By.xpath("//*[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //Поле для выбора цвета самоката
    private final By colorField = By.className("Order_Checkboxes__3lWSI");
    //Поле для ввода комментария
    private final By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By orderButton = By.xpath("//button[text()='Заказать']");
    //Поле календаря
    private final By calendar = By.className("react-datepicker__month-container");
    // Чек-бокс для выбора черного цвета самоката
    private final By blackColor = By.id("black");
    // Чек-бокс для выбора серого цвета самоката
    private final By greyColor = By.id("grey");

    //Кликнуть по кнопке "Заказать"
    public void clickOrderButton() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElements(orderButton).get(1).click();
    }

    //Заполнение даты
    public void chooseDate(String chooseDate) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(date).sendKeys(chooseDate + Keys.ENTER);
    }

    // Заполнение поля срока аренды
    public void setRentalPeriod(String term) {

        click.waitClick(driver.findElement(rentalPeriod));
        click.waitClick(driver.findElement(By.xpath(
                "//div[@class='Dropdown-option' and text()='" + term + "']")));
    }

    // Выбор цвета самоката
    public void chooseBlack(String color) {
        if (color.equals("чёрный жемчуг")) {
            click.waitClick(driver.findElement(blackColor));
        } else {
            click.waitClick(driver.findElement(greyColor));
        }
    }

    //Заполнение поля "Комментарий"
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Заполнение полей с данными о аренде c черным самокатом
    public void setFullFieldRenta(String chooseDate, String term, String comment, String color) {
        chooseDate(chooseDate);
        setRentalPeriod(term);
        setComment(comment);
        chooseBlack(color);
    }
}
