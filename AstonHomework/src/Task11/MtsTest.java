package Task11;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.qameta.allure.Allure.step;


@Epic("Тестирование сайта MTS.by")
@Feature("Блок 'Онлайн пополнение без комиссии'")
public class MtsTest {

	
	private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    
    private OnlineReplenidhment onlineReplenishment;

    @BeforeMethod
    @Step("Настройка браузера и открытие сайта")
    public void setUp() {
        System.out.println("Запуск теста MTS с PageObject...");
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\voroh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            step("Браузер открыт", () -> {});
            
            driver.get("https://www.mts.by");
            step("Перешли на сайт mts.by", () -> {});
            Thread.sleep(5000);
            
            onlineReplenishment = new OnlineReplenidhment(driver);
            
        } catch (Exception e) {
            attachScreenshot("Ошибка при настройке");
            throw new RuntimeException("Ошибка настройки теста: " + e.getMessage());
        }
    }

    @Test
    @Story("Проверка основных элементов блока пополнения")
    @Description("Тест проверяет основные элементы блока 'Онлайн пополнение без комиссии'")
    @Severity(SeverityLevel.BLOCKER)
    public void testOnlineReplenishmentBlock() {
        step("Проверка названия блока", () -> {
            onlineReplenishment.checkBlockTitle();
        });
        
        step("Проверка логотипов платежных систем", () -> {
            onlineReplenishment.checkPaymentLogos();
        });
        
        step("Проверка ссылки 'Подробнее о сервисе'", () -> {
            onlineReplenishment.checkDetailsLink();
        });
        
        step("Проверка надписей в пустых полях", () -> {
            onlineReplenishment.checkEmptyFieldsLabels();
        });
        
        step("Тестирование формы пополнения услуг связи", () -> {
            onlineReplenishment.testMobilePaymentForm();
        });
        
        step("Все тесты завершены успешно!", () -> {});
    }

    @AfterMethod
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            step("Браузер закрыт", () -> {});
        }
    }

    @Attachment(value = "Скриншот при ошибке", type = "image/png")
    public byte[] attachScreenshot(String name) {
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}