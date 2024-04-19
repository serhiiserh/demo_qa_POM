package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        // Если есть select Можно выбрать вариант именно по тексту, индексу
        select.selectByVisibleText(color);
        // Для того, чтобы распечатать все внутри dropdown
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        System.out.println("--------------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }
    @FindBy(id = "react-select-4-input")
    WebElement selectInput;

    @FindBy(css = "html")
    WebElement space;

    public SelectMenuPage multiSelect(String[] colors) {
// Массив нужен fori
        for (int i = 0; i < colors.length; i++) {
            if(colors[i] != null){
                selectInput.sendKeys(colors[i]);
                // Отвечает за ввод с клавиатуры клавиши Enter
                selectInput.sendKeys(Keys.ENTER);
            }
        }
        click(space);
    return this;
    }
}
