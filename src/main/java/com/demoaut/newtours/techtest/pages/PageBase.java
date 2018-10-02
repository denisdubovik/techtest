package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class PageBase {

    WebDriver driver;
    Select select;

     Select getSelect (WebElement element) {
        select = new Select(element);
        return select;
    }
    public String getTitle(){
        return driver.getTitle();
    }
     String getter(WebElement table, int index){
        List<WebElement> cells = table.findElements(By.tagName("td"));
        return cells.get(index).getText();
    }
}