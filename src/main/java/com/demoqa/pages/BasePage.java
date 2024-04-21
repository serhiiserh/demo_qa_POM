package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    // Позволяет обходить пользовательский интерфейс

    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Нужно создать библиотеку PageFactory с помощью, которой строятся страницы
        PageFactory.initElements(driver, this);
        // инициализируем
        js = (JavascriptExecutor) driver;
    }
    // click, type - Передаем не локаторы, а непосредственно сами элементы
    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {

        if (text != null)
            click(element);
        element.clear();
        element.sendKeys(text);
    }

    // В методе передаем WebElement element, у JS Executor чтобы на него кликать, х и у из-за ориентируется на координаты по горизонтали и по вертикали, мы передаем две координаты
    public void clickWithJS(WebElement element, int x, int y) {
        // мы должны написать внутри window. нужно указать метод scrollBy()
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        // просто кликаем на элемент
        click(element);

    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        // ожидаем текст внутри элемента
        // внутри класса ExpectedConditions очень много разных условий
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void hideIframes() {
        hideAd();
        hideFooter();
    }

    private void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    private void hideAd() {
        // Поиск элем по локатору и даем команду, чтобы этот метод скрыл этот элемент
        js.executeScript("document.getElementById('fixedban').style.display='none';");
    }

    public void verifyLinks(String linkUrl) {
        // Класс позволит создать соединение с сервером, дает доступ к ссылкам
        try {


            URL url = new URL(linkUrl);
            // Создает соединение create url connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(500);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " is broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " Error occurred");
        }
    }


}
