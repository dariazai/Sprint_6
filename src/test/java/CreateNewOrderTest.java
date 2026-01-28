import com.example.ContactInformationPage;
import com.example.MainPage;
import com.example.PopUpWindowPage;
import com.example.RentPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewOrderTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @Description("Тест заполняет все поля для регистрации заказа, затем проверяет всплывающее окно о успешной регистрации заказа")
    public void createNewOrderUpButtonTest(String metro, String term, String color, String button) {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOkCookies();
        if (button.equals("high")) {
            objMainPage.clickTopOrderButton();
        } else {
            objMainPage.clickDownOrderButton();
        }
        ContactInformationPage objInformationPage = new ContactInformationPage(driver);
        objInformationPage.fillingContactInformation("Марфа", "Иванова", "Кошкин лес", metro, "+79874444444");
        objInformationPage.clickContinue();
        RentPage objRentPage = new RentPage(driver);
        objRentPage.setFullFieldRenta("23.05.2026", term, "ничего не надо", color);
        objRentPage.clickOrderButton();
        PopUpWindowPage odjPopUpPage = new PopUpWindowPage(driver);
        odjPopUpPage.clickYesButton();
        odjPopUpPage.visibleModalWindow();
        assertTrue(odjPopUpPage.visibleModalWindow());
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Бульвар Рокоссовского", "двое суток", "чёрный жемчуг", "high"),
                Arguments.of("Красносельская", "семеро суток", "серая безысходность", "high"),
                Arguments.of("Красные Ворота", "сутки", "чёрный жемчуг", "low"),
                Arguments.of("Лубянка", "шестеро суток", "серая безысходность", "low")
        );
    }

    @AfterEach
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
