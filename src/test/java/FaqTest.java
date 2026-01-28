import com.example.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaqTest {
    WebDriver driver = new ChromeDriver();

    @Test
    @Description("Тест проверяет соответствие вопросов и ответов")
    public void comparingResponsesTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOkCookies();
        HashMap<String, String> textResponse = objMainPage.checkFaq();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", textResponse.get("Сколько это стоит? И как оплатить?"));
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", textResponse.get("Хочу сразу несколько самокатов! Так можно?"));
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", textResponse.get("Как рассчитывается время аренды?"));
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", textResponse.get("Можно ли заказать самокат прямо на сегодня?"));
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", textResponse.get("Можно ли продлить заказ или вернуть самокат раньше?"));
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", textResponse.get("Вы привозите зарядку вместе с самокатом?"));
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", textResponse.get("Можно ли отменить заказ?"));
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", textResponse.get("Я жизу за МКАДом, привезёте?"));
    }

    @AfterEach
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
