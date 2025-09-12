package Task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnlineReplenishment {
    private WebDriver driver;
    
    public OnlineReplenishment(WebDriver driver) {
        this.driver = driver;
    }
    
    // Проверка названия блока
    public void checkBlockTitle() throws InterruptedException {
        System.out.println("Проверка названия блока");
        
        WebElement blockTitle = null;
        try {
            blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
        } catch (Exception e) {
            try {
                blockTitle = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
            } catch (Exception e2) {
                System.out.println("Заголовок НЕ найден");
                return;
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
        Thread.sleep(1000);
    }
    
    // Проверка логотипов
    public void checkPaymentLogos() throws InterruptedException {
        System.out.println("Проверяем логотипы платежных систем...");
        
        List<WebElement> logos = driver.findElements(By.xpath("//img"));
        int paymentLogosCount = 0;
        
        for (WebElement logo : logos) {
            String src = logo.getAttribute("src");
            String alt = logo.getAttribute("alt");
            if (src != null && (src.contains("visa") || src.contains("mastercard") || src.contains("belkart") || 
                (alt != null && (alt.toLowerCase().contains("платеж") || alt.toLowerCase().contains("payment"))))) {
                paymentLogosCount++;
            }
        }
        
        System.out.println("Найдено логотипов платежных систем: " + paymentLogosCount);
        if (paymentLogosCount > 0) {
            System.out.println("Логотипы найдены");
        } else {
            System.out.println("Логотипы НЕ найдены");
        }
        Thread.sleep(1000);
    }
    
    // Проверка ссылки
    public void checkDetailsLink() throws InterruptedException {
        System.out.println("Проверка 'Подробнее о сервисе'...");
        
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
                
                String currentUrl = driver.getCurrentUrl();
                detailsLink.click();
                Thread.sleep(3000);
                
                if (!driver.getCurrentUrl().equals(currentUrl)) {
                    System.out.println("✓ Переход по ссылке работает");
                    driver.navigate().back();
                    Thread.sleep(3000);
                } else {
                    System.out.println("Переход НЕ работает");
                }
            }
        } else {
            System.out.println("Ссылка НЕ найдена");
        }
    }
    
    // Проверка надписей в пустых полях
    public void checkEmptyFieldsLabels() throws InterruptedException {
        System.out.println("ПРОВЕРКА В ПУТЫХ ПОЛЯХ");
        
        List<WebElement> paymentOptions = driver.findElements(By.xpath("//div[contains(@class, 'payment-option') or contains(@class, 'tab')]"));
        
        for (int i = 0; i < Math.min(paymentOptions.size(), 4); i++) {
            try {
                paymentOptions.get(i).click();
                Thread.sleep(1000);
                System.out.println("Проверяем вариант оплаты " + (i + 1));
                
                List<WebElement> inputs = driver.findElements(By.xpath(".//input[@placeholder]"));
                for (WebElement input : inputs) {
                    String placeholder = input.getAttribute("placeholder");
                    if (placeholder != null && !placeholder.isEmpty()) {
                        System.out.println("Надпись в поле: " + placeholder);
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Не удалось проверить вариант оплаты" + (i + 1));
            }
        }
        
        // Возврат к "услугам связи"
        if (!paymentOptions.isEmpty()) {
            paymentOptions.get(0).click();
            Thread.sleep(1000);
        }
    }
    
    // Тестирование формы пополнения
    public void testMobilePaymentForm() throws InterruptedException {
        System.out.println("ТЕСТ ФОРМЫ УСЛУГ СВЯЗИ");
        
        try {
            WebElement mobileTab = driver.findElement(By.xpath("//div[contains(text(), 'Услуги связи') or contains(@class, 'mobile')]"));
            mobileTab.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Не удалось переключиться на услуги связи");
        }
        
        // Ввод номера телефона
        WebElement phoneInput = findPhoneInput();
        if (phoneInput != null) {
            phoneInput.clear();
            phoneInput.sendKeys("297777777");
            System.out.println("Введен номер телефона: 297777777");
        } else {
            System.out.println("Поле для телефона НЕ найдено");
            return;
        }
        
        // Клик по кнопке ПРОДОЛЖИТЬ
        WebElement continueButton = findContinueButton();
        if (continueButton != null && continueButton.isEnabled()) {
            continueButton.click();
            System.out.println("Кнопка 'Продолжить' нажата");
            Thread.sleep(3000);
            
            checkPaymentModal();
            
        } else {
            System.out.println("Кнопка 'Продолжить' не найдена");
        }
    }
    
    private WebElement findPhoneInput() {
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        for (WebElement input : inputs) {
            String type = input.getAttribute("type");
            String placeholder = input.getAttribute("placeholder");
            String name = input.getAttribute("name");
            
            if ("tel".equals(type) || 
                (placeholder != null && placeholder.toLowerCase().contains("номер")) ||
                (name != null && name.toLowerCase().contains("phone"))) {
                return input;
            }
        }
        return null;
    }
    
    private WebElement findContinueButton() {
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        for (WebElement button : buttons) {
            String buttonText = button.getText();
            if (buttonText.contains("Продолжить") || buttonText.contains("Пополнить") || buttonText.contains("Далее")) {
                return button;
            }
        }
        return null;
    }
    
    private void checkPaymentModal() {
        System.out.println("ПРОВЕРКА ОКНА ОПЛАИТЫ");
        
        try {
            // номер телефона
            List<WebElement> phoneElements = driver.findElements(By.xpath("//*[contains(text(), '297777777') or contains(text(), '297 777777')]"));
            if (!phoneElements.isEmpty()) {
                System.out.println("Номер телефона отображается корректно");
            } else {
                System.out.println("Номер телефона НЕ отображается");
            }
            
            // Проверка суммы
            List<WebElement> amountElements = driver.findElements(By.xpath("//*[contains(text(), 'руб') or contains(text(), 'BYN') or contains(@class, 'amount')]"));
            if (!amountElements.isEmpty()) {
                System.out.println("Сумма отображается: " + amountElements.get(0).getText());
            }
            
            List<WebElement> payButtons = driver.findElements(By.xpath("//button[contains(text(), 'Оплатить') or contains(text(), 'оплатить')]"));
            if (!payButtons.isEmpty()) {
                String buttonText = payButtons.get(0).getText();
                System.out.println("Текст на кнопке: " + buttonText);
                
                if (buttonText.matches(".*\\d+.*")) {
                    System.out.println("Сумма отображается");
                }
            }
            
            // Проверка поля для карты
            
            List<WebElement> cardInputs = driver.findElements(By.xpath("//input[contains(@placeholder, 'карт') or contains(@placeholder, 'card')]"));
            System.out.println("Найдено полей: " + cardInputs.size());
            
            for (WebElement input : cardInputs) {
                String placeholder = input.getAttribute("placeholder");
                if (placeholder != null && !placeholder.isEmpty()) {
                    System.out.println("Надпись в поле: " + placeholder);
                }
            }
            
            // Проверка иконки платежных систем
            
            List<WebElement> modalLogos = driver.findElements(By.xpath("//div[contains(@class, 'modal')]//img"));
            int paymentIconsCount = 0;
            
            for (WebElement logo : modalLogos) {
                String src = logo.getAttribute("src");
                if (src != null && (src.contains("visa") || src.contains("mastercard") || src.contains("belkart"))) {
                    paymentIconsCount++;
                }
            }
            
            System.out.println("Найдено иконок: " + paymentIconsCount);
            if (paymentIconsCount > 0) {
                System.out.println("Иконки присутствуют");
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка при проверке окна: " + e.getMessage());
        }
    }
}