package Task11;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import static io.qameta.allure.Allure.step;

public class OnlineReplenidhment {
    private WebDriver driver;
    
    public OnlineReplenidhment(WebDriver driver) {
        this.driver = driver;
    }
    
    // Проверка названия блока
    @Step("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void checkBlockTitle() throws InterruptedException {
        step("Поиск заголовка блока", () -> {
            WebElement blockTitle = null;
            try {
                blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
            } catch (Exception e) {
                try {
                    blockTitle = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
                } catch (Exception e2) {
                    step("Заголовок НЕ найден", () -> {});
                    return;
                }
            }
            
            if (blockTitle != null) {
                String titleText = blockTitle.getText();
                step("Найден блок: " + titleText, () -> {});
                
                if (titleText.contains("Онлайн пополнение")) {
                    step("Название блока верное", () -> {});
                } else {
                    step("Название блока неверно", () -> {});
                }
            }
        });
        Thread.sleep(1000);
    }
    
    // Проверка логотипов
    @Step("Проверка логотипов платежных систем")
    public void checkPaymentLogos() throws InterruptedException {
        step("Поиск всех изображений на странице", () -> {
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
            
            step("Найдено логотипов платежных систем: " + paymentLogosCount, () -> {});
            if (paymentLogosCount > 0) {
                step("Логотипы найдены", () -> {});
            } else {
                step("Логотипы НЕ найдены", () -> {});
            }
        });
        Thread.sleep(1000);
    }
    
    // Проверка ссылки
    @Step("Проверка ссылки 'Подробнее о сервисе'")
    public void checkDetailsLink() throws InterruptedException {
        step("Поиск ссылки 'Подробнее о сервисе'", () -> {
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
                step("Ссылка найдена: " + detailsLink.getText(), () -> {});
                
                if (detailsLink.isEnabled()) {
                    step("Ссылка активна", () -> {});
                    
                    String currentUrl = driver.getCurrentUrl();
                    detailsLink.click();
                    Thread.sleep(3000);
                    
                    if (!driver.getCurrentUrl().equals(currentUrl)) {
                        step("Переход по ссылке работает", () -> {});
                        driver.navigate().back();
                        Thread.sleep(3000);
                    } else {
                        step("Переход НЕ работает", () -> {});
                    }
                }
            } else {
                step("Ссылка не найдена", () -> {});
            }
        });
    }
    
    // Проверка надписей в пустых полях
    @Step("Проверка надписей в пустых полях для всех вариантов оплаты")
    public void checkEmptyFieldsLabels() throws InterruptedException {
        step("Поиск всех вариантов оплаты", () -> {
            List<WebElement> paymentOptions = driver.findElements(By.xpath("//div[contains(@class, 'payment-option') or contains(@class, 'tab')]"));
            
            for (int i = 0; i < Math.min(paymentOptions.size(), 4); i++) {
                try {
                    paymentOptions.get(i).click();
                    Thread.sleep(1000);
                    step("Проверяем вариант оплаты " + (i + 1), () -> {});
                    
                    List<WebElement> inputs = driver.findElements(By.xpath(".//input[@placeholder]"));
                    for (WebElement input : inputs) {
                        String placeholder = input.getAttribute("placeholder");
                        if (placeholder != null && !placeholder.isEmpty()) {
                            step("Надпись в поле: " + placeholder, () -> {});
                        }
                    }
                    
                } catch (Exception e) {
                    step("Не удалось проверить вариант оплаты " + (i + 1), () -> {});
                }
            }
            
            // Возврат к "услугам связи"
            if (!paymentOptions.isEmpty()) {
                paymentOptions.get(0).click();
                Thread.sleep(1000);
            }
        });
    }
    
    // Тестирование формы пополнения
    @Step("Тестирование формы пополнения услуг связи")
    public void testMobilePaymentForm() throws InterruptedException {
        step("Переключение на вкладку 'Услуги связи'", () -> {
            try {
                WebElement mobileTab = driver.findElement(By.xpath("//div[contains(text(), 'Услуги связи') or contains(@class, 'mobile')]"));
                mobileTab.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                step("Не удалось переключиться на услуги связи", () -> {});
            }
        });
        
        step("Заполнение поля номера телефона", () -> {
            WebElement phoneInput = findPhoneInput();
            if (phoneInput != null) {
                phoneInput.clear();
                phoneInput.sendKeys("297777777");
                step("Введен номер телефона: 297777777", () -> {});
            } else {
                step("Поле для телефона НЕ найдено", () -> {});
                return;
            }
        });
        
        step("Нажатие кнопки 'Продолжить'", () -> {
            WebElement continueButton = findContinueButton();
            if (continueButton != null && continueButton.isEnabled()) {
                continueButton.click();
                step("Кнопка 'Продолжить' нажата", () -> {});
                Thread.sleep(3000);
                
                checkPaymentModal();
                
            } else {
                step("Кнопка 'Продолжить' не найдена или неактивна", () -> {});
            }
        });
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
    
    @Step("Проверка модального окна оплаты")
    private void checkPaymentModal() {
        step("Проверка отображения номера телефона", () -> {
            List<WebElement> phoneElements = driver.findElements(By.xpath("//*[contains(text(), '297777777') or contains(text(), '297 777777')]"));
            if (!phoneElements.isEmpty()) {
                step("Номер телефона отображается корректно", () -> {});
            } else {
                step("Номер телефона НЕ отображается", () -> {});
            }
        });
        
        step("Проверка отображения суммы", () -> {
            List<WebElement> amountElements = driver.findElements(By.xpath("//*[contains(text(), 'руб') or contains(text(), 'BYN') or contains(@class, 'amount')]"));
            if (!amountElements.isEmpty()) {
                step("Сумма отображается: " + amountElements.get(0).getText(), () -> {});
            }
        });
        
        step("Проверка кнопки оплаты", () -> {
            List<WebElement> payButtons = driver.findElements(By.xpath("//button[contains(text(), 'Оплатить') or contains(text(), 'оплатить')]"));
            if (!payButtons.isEmpty()) {
                String buttonText = payButtons.get(0).getText();
                step("Текст на кнопке: " + buttonText, () -> {});
                
                if (buttonText.matches(".*\\d+.*")) {
                    step("Сумма на кнопке отображается", () -> {});
                }
            }
        });
        
        step("Проверка полей для ввода карты", () -> {
            List<WebElement> cardInputs = driver.findElements(By.xpath("//input[contains(@placeholder, 'карт') or contains(@placeholder, 'card')]"));
            System.out.println("Найдено полей для карты: " + cardInputs.size());
            
            for (WebElement input : cardInputs) {
                String placeholder = input.getAttribute("placeholder");
                if (placeholder != null && !placeholder.isEmpty()) {
                    step("Надпись в поле карты: " + placeholder, () -> {});
                }
            }
        });
        
        step("Проверка иконок платежных систем в модальном окне", () -> {
            List<WebElement> modalLogos = driver.findElements(By.xpath("//div[contains(@class, 'modal')]//img"));
            int paymentIconsCount = 0;
            
            for (WebElement logo : modalLogos) {
                String src = logo.getAttribute("src");
                if (src != null && (src.contains("visa") || src.contains("mastercard") || src.contains("belkart"))) {
                    paymentIconsCount++;
                }
            }
            
            step("Найдено иконок платежных систем в окне: " + paymentIconsCount, () -> {});
            if (paymentIconsCount > 0) {
                step("Иконки платежных систем айдены", () -> {});
            }
        });
    }
} 