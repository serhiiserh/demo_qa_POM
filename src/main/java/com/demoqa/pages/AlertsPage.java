package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;


    public AlertsPage alertWithTimer() {
        click(timerAlertButton);
        // need button "OK"
        // нужно объявить ожидание
        // alertIsPresent() - встроенный метод, когда мы ожидаем Alert,
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
        // ждать до тех пор, pause пока не будет соответстовать тому, что появляется element Alert

        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage selectResult(String confirm) {
        click(confirmButton);
        // нужно создать переменную, чтобы был выбор
        if (confirm != null && confirm.equals("OK")) {
            //accept() встроенный метод, когда мы кликаем на ОК
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            //dismiss() встроенный метод, когда мы кликаем на Cancel
            driver.switchTo().alert().dismiss();
        }
        // Object зациклен сам на себя
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        click(promtButton);
        if (message != null) {
            //sendKeys() - метод, когда мы хотим что-то отправить в форму
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();

        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(promptResult.getText().contains(text));
        return this;
    }
}
