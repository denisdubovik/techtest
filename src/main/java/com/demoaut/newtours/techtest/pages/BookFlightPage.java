package com.demoaut.newtours.techtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookFlightPage extends PageBase{

    @FindBy(xpath = "//font[contains(text(),'Summary')]/ancestor::tr[1]/following-sibling::tr[1]")
    private static WebElement tableSummary;

    @FindBy(name = "passFirst0")
    private static WebElement firstNamePassenger0;

    @FindBy(name = "passLast0")
    private static WebElement lastNamePassenger0;

    @FindBy(name = "pass.0.meal")
    private static WebElement mealPassenger0;

    @FindBy(name = "passFirst1")
    private static WebElement firstNamePassenger1;

    @FindBy(name = "passLast1")
    private static WebElement lastNamePassenger1;

    @FindBy(name = "pass.1.meal")
    private static WebElement mealPassenger1;

    @FindBy(name = "creditCard")
    private static WebElement cardType;

    @FindBy(name = "creditnumber")
    private static WebElement cardNumber;

    @FindBy(name = "cc_exp_dt_mn")
    private static WebElement cardExpirationMonth;

    @FindBy(name = "cc_exp_dt_yr")
    private static WebElement cardExpirationYear;

    @FindBy(name = "cc_frst_name")
    private static WebElement cardFirstName;

    @FindBy(name = "cc_mid_name")
    private static WebElement cardMiddleName;

    @FindBy(name = "cc_last_name")
    private static WebElement cardLastName;

    @FindBy(name = "billAddress1")
    private static WebElement billingAddress;

    @FindBy(name = "billCity")
    private static WebElement billingCity;

    @FindBy(name = "billState")
    private static WebElement billingState;

    @FindBy(name = "billZip")
    private static WebElement billingPostalCode;

    @FindBy(name = "billCountry")
    private static WebElement billingCountry;

    @FindBy(xpath = "//*[contains(text(), 'Same as Billing Address')]/preceding-sibling::input[1]")
    private static WebElement sameAsBillingAddress;

    @FindBy(name = "delAddress1")
    private static WebElement deliveryAddress;

    @FindBy(name = "delCity")
    private static WebElement deliveryCity;

    @FindBy(name = "delState")
    private static WebElement deliveryState;

    @FindBy(name = "delZip")
    private static WebElement deliveryPostalCode;

    @FindBy(name = "delCountry")
    private static WebElement deliveryCountry;

    @FindBy(name = "buyFlights")
    private static WebElement buyFlight;

    private static final int INDEX_CELL_OF_DEPARTING_ROUTE = 1;
    private static final int INDEX_CELL_OF_DEPARTING_DATE = 2;
    private static final int INDEX_CELL_OF_DEPARTING_FLIGHT = 6;
    private static final int INDEX_CELL_OF_DEPARTING_CLASS = 7;
    private static final int INDEX_CELL_OF_DEPARTING_PRICE = 8;
    private static final int INDEX_CELL_OF_RETURNING_ROUTE = 9;
    private static final int INDEX_CELL_OF_RETURNING_DATE = 10;
    private static final int INDEX_CELL_OF_RETURNING_FLIGHT = 14;
    private static final int INDEX_CELL_OF_RETURNING_CLASS = 15;
    private static final int INDEX_CELL_OF_RETURNING_PRICE = 16;
    private static final int INDEX_CELL_OF_COUNT_PASSENGERS = 18;
    private static final int INDEX_CELL_OF_TAXES = 20;
    private static final int INDEX_CELL_OF_TOTAL_PRICE = 22;

    public BookFlightPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getDepartRouteFromSummary(){
        return getter(tableSummary, INDEX_CELL_OF_DEPARTING_ROUTE);
    }
    public String getDepartDateFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_DEPARTING_DATE);
    }
    public String getDepartFlightFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_DEPARTING_FLIGHT);
    }
    public String getDepartClassFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_DEPARTING_CLASS);
    }
    public String getDepartPriceFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_DEPARTING_PRICE);
    }
    public String getReturnRouteFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_RETURNING_ROUTE);
    }
    public String getReturnDateFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_RETURNING_DATE);
    }
    public String getReturnFlightFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_RETURNING_FLIGHT);
    }
    public String getReturnClassFromSummary(){
        return getter(tableSummary, INDEX_CELL_OF_RETURNING_CLASS);
    }
    public String getReturnPriceFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_RETURNING_PRICE);
    }
    public String getCountPassengersFromSummary(){
        return  getter(tableSummary, INDEX_CELL_OF_COUNT_PASSENGERS);
    }
    public String getTaxesFromSummary(){
        String text =  getter(tableSummary, INDEX_CELL_OF_TAXES);
        return text.substring(text.indexOf("$")+1);
    }
    public String getTotalPriceFromSummary(){
        String text =  getter(tableSummary, INDEX_CELL_OF_TOTAL_PRICE);
        return text.substring(text.indexOf("$")+1);
    }
    public String calculateTotalPrice(){
        int priceDepart = Integer.parseInt(getter(tableSummary, INDEX_CELL_OF_DEPARTING_PRICE));
        int priceReturn = Integer.parseInt(getter(tableSummary, INDEX_CELL_OF_RETURNING_PRICE));
        int passCount = Integer.parseInt(getter(tableSummary, INDEX_CELL_OF_COUNT_PASSENGERS));
        String textTaxes = getter(tableSummary, INDEX_CELL_OF_TAXES);
        int taxes = Integer.parseInt(textTaxes.substring(textTaxes.indexOf("$")+1));
        return String.valueOf((priceDepart+priceReturn) * passCount + taxes);
    }
    public void setPassFirst0(String name){
        firstNamePassenger0.sendKeys(name);
    }
    public void setPassLast0(String name){
        lastNamePassenger0.sendKeys(name);
    }
    public void setMealFirstPassenger(String meal){
        getSelect(mealPassenger0);
        select.selectByVisibleText(meal);
    }
    public void setPassFirst1(String name){
        firstNamePassenger1.sendKeys(name);
    }
    public void setPassLast1(String name){
        lastNamePassenger1.sendKeys(name);
    }
    public void setMealSecondPassenger(String meal){
        getSelect(mealPassenger1);
        select.selectByVisibleText(meal);
    }
    public void setCardType(String type){
        getSelect(cardType);
        select.selectByVisibleText(type);
    }
    public void setCardNumber(String num){
        cardNumber.sendKeys(num);
    }
    public void setCardExpirationMonth(String mn) {
        getSelect(cardExpirationMonth);
        select.selectByVisibleText(mn);
    }
    public void setCardExpirationYear(String yr){
        getSelect(cardExpirationYear);
        select.selectByVisibleText(yr);
    }
    public void setCardFirstName(String name){
        cardFirstName.sendKeys(name);
    }
    public void setCardMiddleName(String name){
        cardMiddleName.sendKeys(name);
    }
    public void setCardLastName(String name){
        cardLastName.sendKeys(name);
    }
    public void setBillingAddress(String address){
        billingAddress.clear();
        billingAddress.sendKeys(address);
    }
    public void setBillingCity(String city){
        billingCity.clear();
        billingCity.sendKeys(city);
    }
    public void setBillingState(String state){
        billingState.clear();
        billingState.sendKeys(state);
    }
    public void setBillingPostalCode(String code){
        billingPostalCode.clear();
        billingPostalCode.sendKeys(code);
    }
    public void setBillingCountry(String country){
        getSelect(billingCountry);
        select.selectByVisibleText(country);
    }
    public void setSameAsBillingAddress(){
        sameAsBillingAddress.click();
    }
    public void setDeliveryAddressAddress(String address){
        deliveryAddress.clear();
        deliveryAddress.sendKeys(address);
    }
    public void setDeliveryCity(String city){
        deliveryCity.clear();
        deliveryCity.sendKeys(city);
    }
    public void setDeliveryState(String state){
        deliveryState.clear();
        deliveryState.sendKeys(state);
    }
    public void setDeliveryPostalCode(String code){
        deliveryPostalCode.clear();
        deliveryPostalCode.sendKeys(code);
    }
    public void setDeliveryCountry(String country){
        getSelect(deliveryCountry);
        select.selectByVisibleText(country);
    }
    public void clickSecurePurchase(){
        buyFlight.click();
    }
}