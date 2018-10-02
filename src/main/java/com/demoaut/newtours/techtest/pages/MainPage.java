package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    @FindBy(name="userName")
    private static WebElement userName;

    @FindBy(name="password")
    private static WebElement password;

    @FindBy(name="login")
    private static WebElement login;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String name){
        userName.sendKeys(name);
    }
    public void setPassword(String pass){
        password.sendKeys(pass);
    }
    public void clickSignIn (){
        login.click();
    }
}