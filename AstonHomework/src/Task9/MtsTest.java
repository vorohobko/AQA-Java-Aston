package Task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MtsTest {
    public static void main(String[] args) {
        System.out.println("Запуск теста MTS...");
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\voroh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            System.out.println("Браузер открыт");
            driver.get("https://www.mts.by");
            System.out.println("Перешли на сайт mts.by");
          
            Thread.sleep(5000);
            
            System.out.println("Онлайн пополнение без комиссии");
            
            // Поиск заголовка
            WebElement blockTitle = null;
            try {
                blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
            } catch (Exception e) {
                try {
                    blockTitle = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
                } catch (Exception e2) {
                    System.out.println("Заголовок НЕ найден");
                }
            }
            
            if (blockTitle != null) {
                String titleText = blockTitle.getText();
                System.out.println("Найден блок: " + titleText);
                
                if (titleText.contains("Онлайн пополнение")) {
                    System.out.println("Название блока верное");
                } else {
                    System.out.println("Название блока неверно");
                }
            }
            
            //Поиск логотипов
            System.out.println("Ищем логотипы платежных систем...");
            List<WebElement> logos = driver.findElements(By.xpath("//img"));
            int paymentLogosCount = 0;
            
            for (WebElement logo : logos) {
                String src = logo.getAttribute("src");
                String alt = logo.getAttribute("alt");
                if (src != null && (src.contains("visa") || src.contains("mastercard") || src.contains("payment") || 
                    (alt != null && (alt.contains("платеж") || alt.contains("payment"))))) {
                    paymentLogosCount++;
                }
            }
            
            System.out.println("Найдено логотипов платежных систем: " + paymentLogosCount);
            if (paymentLogosCount > 0) {
                System.out.println("Логотипы найдены");
            } else {
                System.out.println("Логотипы НЕ найдены");
            }
            
            System.out.println("Подробнее о сервисе");
            List<WebElement> links = driver.findElements(By.xpath("//a"));
            WebElement detailsLink = null;
            
            for (WebElement link : links) {
                String linkText = link.getText();
                if (linkText.contains("Подробнее о сервисе") || linkText.contains("Подробнее")) {
                    detailsLink = link;
                    break;
                }
            }
            
            if (detailsLink != null) {
                System.out.println("Ссылка найдена: " + detailsLink.getText());
                
                if (detailsLink.isEnabled()) {
                    System.out.println("Ссылка активна");
                    
                    // Наждатие на ссылку
                    String currentUrl = driver.getCurrentUrl();
                    detailsLink.click();
                    Thread.sleep(3000);
                    
                    if (!driver.getCurrentUrl().equals(currentUrl)) {
                        System.out.println("Переход по ссылке работает");
                        // Вернуться обратно
                        driver.navigate().back();
                        Thread.sleep(3000);
                    } else {
                        System.out.println("Переход НЕ работает");
                    }
                }
            } else {
                System.out.println("✗ Ссылка не найдена");
            }
            
            // Форма пополнения
            System.out.println("Форма для пополнения");
            
            // Поле номера телефона
            List<WebElement> inputs = driver.findElements(By.xpath("//input"));
            WebElement phoneInput = null;
            
            for (WebElement input : inputs) {
                String type = input.getAttribute("type");
                String placeholder = input.getAttribute("placeholder");
                if ("tel".equals(type) || (placeholder != null && placeholder.toLowerCase().contains("номер"))) {
                    phoneInput = input;
                    break;
                }
            }
            
            if (phoneInput != null) {
                System.out.println("Поле для телефона найдено");
                phoneInput.sendKeys("297777777");
                System.out.println("Введен номер телефона");
            } else {
                System.out.println("Поле для телефона НЕ найдено");
            }
            
            // Поиск кнопки
            List<WebElement> buttons = driver.findElements(By.xpath("//button"));
            WebElement continueButton = null;
            
            for (WebElement button : buttons) {
                String buttonText = button.getText();
                if (buttonText.contains("Продолжить") || buttonText.contains("Пополнить")) {
                    continueButton = button;
                    break;
                }
            }
            
            if (continueButton != null) {
                System.out.println("Кнопка найдена: " + continueButton.getText());
                
                if (continueButton.isEnabled()) {
                    System.out.println("Кнопка активна");
                    continueButton.click();
                    Thread.sleep(3000);
                    System.out.println("Кнопка нажата");
                } else {
                    System.out.println("Кнопка неактивна");
                }
            } else {
                System.out.println("Кнопка не найдена");
            }
            
            System.out.println("Тест завершен успешно!");
            
        } catch (Exception e) {
            System.out.println("Ошибка во время тестирования: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}