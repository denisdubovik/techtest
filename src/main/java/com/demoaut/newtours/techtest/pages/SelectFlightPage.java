package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends PageBase {

    @FindBy(xpath = "//b/*[text()='DEPART']/ancestor::table[1]")
    private static WebElement tableDepart;

    @FindBy(xpath = "//b/*[text()='RETURN']/ancestor::table[1]")
    private static WebElement tableReturn;

    @FindBy(name = "reserveFlights")
    private static WebElement reserveFlight;

    private static final int INDEX_ROUTE = 2;
    private static final int INDEX_DATE = 3;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getRouteFromDepart(){
        return getter(tableDepart, INDEX_ROUTE);
    }
    public String getDateFromDepart(){
        return getter(tableDepart, INDEX_DATE);
    }
    public String getRouteFromReturn(){
        return getter(tableReturn, INDEX_ROUTE);
    }
    public String getDateFromReturn(){
        return getter(tableReturn, INDEX_DATE);
    }
    public void setFlight(String flight){
        driver.findElement(By.xpath("//b[contains(text(), '"+flight+"')]/ancestor::tr[1]//input")).click();
    }
    public String getPrice(String flight){
        String text = driver.findElement(By.xpath("//b[contains(text(), '"+flight+"')]/ancestor::tr[1]/following-sibling::tr[1]//b")).getText();
        return text.substring(text.length() - 3);
    }
    public void clickContinue(){
        reserveFlight.click();
    }
}