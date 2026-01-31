package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactInformationPage {
    private final WebDriver driver;

    public ContactInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле ввода имени
    private final By nameField = By.cssSelector("input[placeholder='* Имя']");
    //Поле ввода фамилии
    private final By lastNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //Поле ввода адреса
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле для ввода станции метро
    private final By metroStationField = By.cssSelector("input[placeholder='* Станция метро']");
    //Поле для ввода телефона
    private final By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By next = By.xpath("//button[contains(text(), 'Далее')]");

    //Метод заполняет поле Имя
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Метод заполняет поле фамилия
    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    //Метод заполняет поле Адрес
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод заполняет поле Станция метро
    public void setMetroStationField(String metro) {
        driver.findElement(metroStationField).click();
        WebElement nameMetroStation = driver.findElement(By.xpath
                ("//li[@role='menuitem']//div[text()='" + metro + "']"));
        nameMetroStation.click();
    }

    //Метод заполняет поле Телефон
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Кликнуть на кнопку Далее
    public void clickContinue() {
        driver.findElement(next).click();
    }

    // Метод заполняет все поля с контактной информацией пользователя
    public void fillingContactInformation(String name, String lastName, String address, String metro, String phone) {
        setNameField(name);
        setLastNameField(lastName);
        setAddressField(address);
        setMetroStationField(metro);
        setPhoneField(phone);
    }
}
