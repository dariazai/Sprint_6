import com.example.MainPage;
import com.example.UiHelpers;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FaqTest extends UiHelpers {

    private static HashMap<String, String> textResponse;

    @BeforeAll
    static void dataCollection() {
        setUpDriverAndData();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOkCookies();

        textResponse = objMainPage.checkFaq();
        assertNotNull(textResponse, "Нет данных об ответах");
    }

    @ParameterizedTest
    @MethodSource("provider")
    @Description("Тест проверяет соответствие вопросов и ответов")
    public void comparingResponsesTest(String questions, String response) {
        assertEquals(response, textResponse.get(questions), "Неправильный ответ на вопрос");
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }

    @AfterEach
    public void afterTest() {
        tearDown();
    }
}
