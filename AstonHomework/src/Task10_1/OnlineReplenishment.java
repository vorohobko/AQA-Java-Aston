package Task10_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlineReplenishment {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement blockTitle;
    
    @FindBy(xpath = "//img[contains(@src, 'visa') or contains(@src, 'mastercard') or contains(@src, 'payment')]")
    private List<WebElement> paymentLogos;
    
    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement detailsLink;
    
    @FindBy(xpath = "//a[contains(text(), 'Подробнее')]")
    private WebElement detailsLinkAlt;
    
    @FindBy(xpath = "//input[@type='tel' or contains(@placeholder, 'номер')]")
    private WebElement phoneInput;
    
    @FindBy(xpath = "//button[contains(text(), 'Продолжить') or contains(text(), 'Пополнить')]")
    private WebElement continueButton;

    public OnlineReplenishment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.mts.by");
        wait.until(ExpectedConditions.urlContains("mts.by"));
    }

    public boolean isBlockTitleDisplayed() {
        try {
            return blockTitle.isDisplayed() && blockTitle.getText().contains("Онлайн пополнение");
        } catch (Exception e) {
            return false;
        }
    }

    public int getPaymentLogosCount() {
        return paymentLogos.size();
    }

    public boolean isDetailsLinkDisplayed() {
        try {
            return detailsLink.isDisplayed() || detailsLinkAlt.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDetailsLink() {
        if (detailsLink.isDisplayed()) {
            detailsLink.click();
        } else if (detailsLinkAlt.isDisplayed()) {
            detailsLinkAlt.click();
        }
    }

    public void enterPhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}