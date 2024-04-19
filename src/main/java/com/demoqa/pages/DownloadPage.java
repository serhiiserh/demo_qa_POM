package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPage extends BasePage{
    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "downloadButton")
    WebElement file;

    public DownloadPage download() {
        click(file);
        return this;
    }
}
