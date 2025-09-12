package Task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MtsTest {
    public static void main(String[] args) {
        System.out.println("Запуск теста MTS с PageObject...");
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\voroh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            driver.manage().window().maximize();
            System.out.println("Браузер открыт");
            
            driver.get("https://www.mts.by");
            System.out.println("Перешли на сайт mts.by");
            Thread.sleep(5000);
            
            OnlineReplenishment onlineReplenishment = new OnlineReplenishment(driver);
            
            onlineReplenishment.checkBlockTitle();
            
            onlineReplenishment.checkPaymentLogos();
                        
            onlineReplenishment.checkDetailsLink();
            
            onlineReplenishment.checkEmptyFieldsLabels();
            
            onlineReplenishment.testMobilePaymentForm();
            
            System.out.println("Все тесты завершены успешно!");
            
        } catch (Exception e) {
            System.out.println("Ошибка во время тестирования: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}