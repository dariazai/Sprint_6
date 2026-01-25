package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactInformationPage {
    private WebDriver driver;
    //Поле ввода имени
    private By nameField = By.cssSelector("input[placeholder='* Имя']");
    //Поле ввода фамилии
    private By lastNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //Поле ввода адреса
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле для ввода станции метро
    private By metroStationField = By.cssSelector("input[placeholder='* Станция метро']");
    //Поле для ввода телефона
    private By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    //Метод заполняет поле Имя
    public void setNameField(String name){
driver.findElement(nameField).sendKeys(name);
    }
    //Метод заполняет поле фамилия
    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    //Метод заполняет поле Адрес
    public void setAddressField(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    //Метод заполняет поле Станция метро
    public void setMetroStationField(String metro){
        WebElement stationMetro=driver.findElement(metroStationField);
        Select dropdown = new Select(stationMetro);
        dropdown.selectByVisibleText(metro);
    }
    //Метод заполняет поле Телефон
    public void setPhoneField(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }
// Метод заполняет все поля с контактной информацией пользователя
    public void fillingContactInformation (String name, String lastName,String address,String metro,String phone){
        setNameField(name);
        setLastNameField(lastName);
        setAddressField(address);
        setMetroStationField(metro);
        setPhoneField(phone);
    }
}
