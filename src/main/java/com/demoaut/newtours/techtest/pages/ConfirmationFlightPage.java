package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationFlightPage extends PageBase{

    @FindBy(xpath = "//font[contains(text(),'Departing')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement departing;

    @FindBy(xpath = "//font[contains(text(),'Returning')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement returning;

    @FindBy(xpath = "//b[contains(text(),'Passengers')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement passengers;

    @FindBy(xpath = "//b[contains(text(),'Billed To')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement billedTo;

    @FindBy(xpath = "//b[contains(text(),'Delivery Address (N/A for Ticketless Travel)')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement delivery;

    @FindBy(xpath = "//font[contains(text(),'Taxes:')]/ancestor::td[1]/following-sibling::td[1]")
    private static WebElement totalTax;

    @FindBy(xpath = "//font[contains(text(),'Price (including taxes):')]/ancestor::td[1]/following-sibling::td[1]")
    private static WebElement totalPrice;

    @FindBy(css = "img[src$='home.gif']")
    private static WebElement backToHome;

    public ConfirmationFlightPage(WebDriver driver) {
        this.driver = driver;}

    private String getFlightsInfo (String text){
        String route = text.substring(0, text.indexOf("\n"));
        String date = text.substring(text.indexOf("\n")+1, text.indexOf("@")-1);
        String flight = text.substring(text.indexOf("w/")+3, text.indexOf("\n", text.indexOf("w/")));
        return route + " " + date + " " + flight;
    }
    public String getRouteFromDeparting(){
        return getFlightsInfo(departing.getText());
    }
    public String getRouteFromReturning(){
        return getFlightsInfo(returning.getText());
    }
    public String getCountPassengers(){
        return passengers.getText();
    }
    public String getBilledTo(){
        return billedTo.getText().replace("\n", " ").replace("  ", " ");
    }
    public String getDeliveryAddress(){
        return delivery.getText().replace("\n", " ").replace("  ", " ");
    }
    public int geTotalPrice() {
        String textPrice = totalPrice.getText();
        return Integer.parseInt(textPrice.substring(textPrice.indexOf("$")+1, textPrice.indexOf(" ", textPrice.indexOf("$"))));

    }
    public int calculateTotalPrice(String passCount) {
        String textTax = totalTax.getText();
        int tax = Integer.parseInt(textTax.substring(textTax.indexOf("$")+1, textTax.indexOf(" ", textTax.indexOf("$"))));
        String textPriceDepart = departing.getText();
        int priceDepart = Integer.parseInt(textPriceDepart.substring(textPriceDepart.indexOf("$")+1, textPriceDepart.indexOf(" ", textPriceDepart.indexOf("$"))));
        String textPriceReturn = returning.getText();
        int priceReturn = Integer.parseInt(textPriceReturn.substring(textPriceReturn.indexOf("$")+1, textPriceReturn.indexOf(" ", textPriceReturn.indexOf("$"))));
        int countPass = Integer.parseInt(passCount);
        return tax + (priceDepart + priceReturn)*countPass;
    }
    public void clickBackToHome () {
        backToHome.click();
    }
}
