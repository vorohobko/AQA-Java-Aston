package Task9_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\voroh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testPaymentBlockTitle() {
        driver.get("https://www.mts.by");
        
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
        ));
        
        assertTrue("Заголовок должен содержать 'Онлайн пополнение'", 
                  blockTitle.getText().contains("Онлайн пополнение"));
    }

    @Test
    public void testPaymentLogos() {
        driver.get("https://www.mts.by");
        
        List<WebElement> paymentLogos = driver.findElements(By.xpath(
            "//img[contains(@src, 'visa') or contains(@src, 'mastercard') or contains(@src, 'payment')]"
        ));
        
        assertTrue("Должен быть хотя бы один логотип платежной системы", 
                  paymentLogos.size() > 0);
    }

    @Test
    public void testDetailsLink() {
        driver.get("https://www.mts.by");
        
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(), 'Подробнее о сервисе') or contains(text(), 'Подробнее')]")
        ));
        
        assertTrue("Ссылка должна быть отображаема", detailsLink.isDisplayed());
        assertTrue("Ссылка должна быть активна", detailsLink.isEnabled());
    }

    @Test
    public void testPhoneInput() {
        driver.get("https://www.mts.by");
        
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@type='tel' or contains(@placeholder, 'номер')]")
        ));
        
        assertTrue("Поле для телефона должно быть отображаемо", phoneInput.isDisplayed());
        
        phoneInput.sendKeys("297777777");
        assertEquals("Номер телефона должен быть введен", "297777777", phoneInput.getAttribute("value"));
    }

    @Test
    public void testContinueButton() {
        driver.get("https://www.mts.by");
        
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@type='tel' or contains(@placeholder, 'номер')]")
        ));
        phoneInput.sendKeys("297777777");
        
        WebElement continueButton = driver.findElement(
            By.xpath("//button[contains(text(), 'Продолжить') or contains(text(), 'Пополнить')]")
        );
        
        assertTrue("Кнопка должна быть активна после ввода номера", continueButton.isEnabled());
    }

    @Test
    public void testDetailsLinkNavigation() {
        driver.get("https://www.mts.by");
        
        String originalUrl = driver.getCurrentUrl();
        
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(), 'Подробнее о сервисе') or contains(text(), 'Подробнее')]")
        ));
        detailsLink.click();
        
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));
        
        assertNotEquals("URL должен измениться после клика по ссылке", 
                       originalUrl, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}