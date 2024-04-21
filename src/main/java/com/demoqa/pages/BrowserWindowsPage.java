package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage{
    // Нужно делать конструктор, тк, он есть в родительском классе
    public BrowserWindowsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "windowButton")
    WebElement windowButton;


    public BrowserWindowsPage switchToNextWindow(int index) {
        click(windowButton);
        // В этом методе getWindowHandles() заложена логика смотреть на кнопки как массив String
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }
@FindBy (id = "sampleHeading")
WebElement sampleHeading;
    public BrowserWindowsPage verifyNewWindowMessage(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,10));
        return this;
    }
}
