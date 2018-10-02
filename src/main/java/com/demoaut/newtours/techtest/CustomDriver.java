package com.demoaut.newtours.techtest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class CustomDriver{

    static ChromeDriver createChromeDriver() {
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       return new ChromeDriver();
    }
    static FirefoxDriver createGeckoDriver() {
       System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
       return new FirefoxDriver();
     }
}