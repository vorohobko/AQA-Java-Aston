package Task10_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class MtsTest {
    private WebDriver driver;
    private OnlineReplenishment mtsTest;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\voroh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mtsTest = new OnlineReplenishment(driver);
    }

    @Test
    public void testPaymentBlockTitle() {
    	mtsTest.open();
        assertTrue("Заголовок блока 'Онлайн пополнение' должен отображаться", 
        		mtsTest.isBlockTitleDisplayed());
    }

    @Test
    public void testPaymentLogos() {
    	mtsTest.open();
        int logosCount = mtsTest.getPaymentLogosCount();
        assertTrue("Должен быть хотя бы один логотип платежной системы", 
                  logosCount > 0);
    }

    @Test
    public void testDetailsLink() {
    	mtsTest.open();
        assertTrue("Ссылка 'Подробнее о сервисе' должна отображаться", 
        		mtsTest.isDetailsLinkDisplayed());
    }

    @Test
    public void testPhoneInputAndContinueButton() {
    	mtsTest.open();
    	mtsTest.enterPhoneNumber("297777777");
        assertTrue("Кнопка 'Продолжить' должна быть активна после ввода номера", 
        		mtsTest.isContinueButtonEnabled());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}