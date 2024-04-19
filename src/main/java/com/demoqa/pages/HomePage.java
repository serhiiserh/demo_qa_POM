package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
// Прежде, чем воспользоваться элементом, нужно его определить и обязательно к нему обратиться
    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        // если сайт не двигается влево-вправо, то х = 0, у = 50% экрана по высоте в пикселях
        clickWithJS(alertsFrameWindows, 0, 500);
        return new SidePanel(driver);
    }
    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
        click(widgets);
        return new SidePanel(driver);
    }

    @FindBy (css = ".top-card:nth-child(2)")
    WebElement forms;
    public SidePanel getForms() {
        click(forms);
        return new SidePanel(driver);
    }

    @FindBy (css = ".top-card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        click(interactions);
    return new SidePanel(driver);}

    @FindBy (css = ".top-card:nth-child(1)")
    WebElement elements;

    public SidePanel getElements() {
        click(elements);
        return new SidePanel(driver);
    }

    //
}
