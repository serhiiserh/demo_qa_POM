package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts, 0, 500);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage selectBrowserWindows() {
        click(browserWindows);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[text()='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 300);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[text()='Droppable']")
    WebElement dropable;
    public DroppablePage selectDropable() {
        click(dropable);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[text()='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage(driver);
    }
    @FindBy(xpath = "//span[text()='Upload and Download']")
    WebElement download;
    public DownloadPage selectDownload() {
        click(download);
        return new DownloadPage(driver);
    }
}
