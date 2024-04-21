package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        // для эмуляции сложных пользовательских действий (курсор, мышь)
        Actions actions = new Actions(driver);
        // Элемент источник перетаскивается в цель, обязательно завершать методом perform(), чтобы собрать эти действия
        actions.dragAndDrop(dragMe, dropHere).perform();
        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }
        return this;
    }

    public DroppablePage actionDragMeBy() {
        // без Actions невозможно достать, для эмуляции сложных пользовательских решений
        Actions actions = new Actions(driver);
        // Находим, где этот элемент находится по горизонтали и вертикали
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + " yOffset1 --> " + yOffset1);
        // Ищем х и у для DropHere
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + " yOffset --> " + yOffset);
        xOffset = (xOffset - xOffset1) + 25;
        yOffset = (yOffset - yOffset1) + 35;
        // .perform() - завершает сборку
        actions.dragAndDropBy(dragMe, xOffset, yOffset).perform();
        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }
        return this;
    }
}
