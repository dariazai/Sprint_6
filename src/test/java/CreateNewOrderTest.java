import com.example.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewOrderTest extends UiHelpers {

    @BeforeEach
    public void beforeTest() {
        setUpDriverAndData();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @Description("Тест заполняет все поля для регистрации заказа, затем проверяет всплывающее окно о успешной регистрации заказа")
    public void createNewOrderUpButtonTest(String metro, String term, String color, String button) {
        MainPage objMainPage = new MainPage(UiHelpers.driver);
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
    public void afterTest() {
        tearDown();
    }
}
