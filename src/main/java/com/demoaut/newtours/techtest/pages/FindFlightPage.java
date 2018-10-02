package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindFlightPage extends PageBase {

    @FindBy(css="input[value='oneway']")
    private static WebElement oneWayType;

    @FindBy(name="passCount")
    private static WebElement passenger;

    @FindBy(name="fromPort")
    private static WebElement departingFrom;

    @FindBy(name="fromMonth")
    private static WebElement onMonth;

    @FindBy(name="fromDay")
    private static WebElement onDay;

    @FindBy(name="toPort")
    private static WebElement arrivingIn;

    @FindBy(name="toMonth")
    private static WebElement returningMonth;

    @FindBy(name="toDay")
    private static WebElement returningDay;

    @FindBy(css="input[value='Business']")
    private static WebElement businessClass;

    @FindBy(name="airline")
    private static WebElement airlineFlight;

    @FindBy(name="findFlights")
    private static WebElement findFlight;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setOneWayType(){
        oneWayType.click();
    }
    public void setPassengers(String passCount){
        getSelect(passenger);
        select.selectByVisibleText(passCount);
    }
    public void setDepartingFrom(String from){
        getSelect(departingFrom);
        select.selectByVisibleText(from);
    }
    public void setOnMonth(String month){
        getSelect(onMonth);
        select.selectByVisibleText(month);
    }
    public void setOnDay(String day){
        getSelect(onDay);
        select.selectByVisibleText(day);
    }
    public void setArrivingIn(String to){
        getSelect(arrivingIn);
        select.selectByVisibleText(to);
    }
    public void setReturningMonth(String month){
        getSelect(returningMonth);
        select.selectByVisibleText(month);
    }
    public void setReturningDay(String day){
        getSelect(returningDay);
        select.selectByVisibleText(day);
    }
    public void setBusinessClass(){
        businessClass.click();
    }
    public void setAirline(String airline){
        getSelect(airlineFlight);
        select.selectByVisibleText(airline);
    }
    public void clickContinue(){
        findFlight.click();
    }
}