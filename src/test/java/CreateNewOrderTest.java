import com.example.ContactInformationPage;
import com.example.MainPage;
import com.example.PopUpWindowPage;
import com.example.RentaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewOrderTest {

    WebDriver driver = new ChromeDriver();



    @Test
    public void checkActivity() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOkCookies();
        objMainPage.clickTopOrderButton();
        ContactInformationPage objInformationPage = new ContactInformationPage(driver);
        objInformationPage.fillingContactInformation("Марфа", "Иванова", "Кошкин лес", "Бульвар Рокоссовского", "+79874444444");
        objInformationPage.clickContinue();
        RentaPage objRentaPage = new RentaPage(driver);
        objRentaPage. setFullFieldRenta("23.05.2026","трое суток","ничего не надо","чёрный жемчуг");
        objRentaPage.clickOrderButton();
        PopUpWindowPage odjPopUpPage = new PopUpWindowPage(driver);
        odjPopUpPage.clickYesButton();
    }
        @AfterEach
        public void teardown () {
            // Закрой браузер
            driver.quit();
        }

}
