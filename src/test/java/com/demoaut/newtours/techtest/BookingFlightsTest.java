package com.demoaut.newtours.techtest;

import com.demoaut.newtours.techtest.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.demoaut.newtours.techtest.CustomDriver.createChromeDriver;
import static com.demoaut.newtours.techtest.CustomDriver.createGeckoDriver;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingFlightsTest {

    private static final String NAME = "test1";
    private static final String PASS = "test1";
    private static final String TITLE_FLIGHT_FINDER = "Find a Flight: Mercury Tours:";
    private static final String PASS_COUNT = "2";
    private static final String FROM_PORT = "Paris";
    private static final String FROM_MONTH = "November";
    private static final String FROM_DAY = "20";
    private static final String TO_PORT = "Seattle";
    private static final String TO_MONTH = "December";
    private static final String TO_DAY = "19";
    private static final String CLASS_FLIGHT = "Business";
    private static final String AIRLINE = "Pangea Airlines";
    private static final String TITLE_SELECT_FLIGHT = "Select a Flight: Mercury Tours";
    private static final String DEPART_FLIGHT = "Unified Airlines 363";
    private static final String DATE_DEPART_FLIGHT = "11/20/2018";
    private static final String RETURN_FLIGHT = "Blue Skies Airlines 631";
    private static final String DATE_RETURN_FLIGHT = "12/19/2018";
    private static final String TITLE_BOOK_FLIGHT = "Book a Flight: Mercury Tours";
    private static final String TAXES = "91";
    private static final String TOTAL_PRICE = "1199";
    private static final String FIRST_NAME_FIRST_PASSENGER = "Ivan";
    private static final String SECOND_NAME_FIRST_PASSENGER = "Ivanov";
    private static final String MEAL_FIRST_PASSENGER = "Hindu";
    private static final String FIRST_NAME_SECOND_PASSENGER = "Irina";
    private static final String SECOND_NAME_SECOND_PASSENGER = "Ivanova";
    private static final String MEAL_SECOND_PASSENGER = "Bland";
    private static final String CARD_TYPE = "Visa";
    private static final String CARD_NUMBER = "5479540454132487";
    private static final String CARD_EXPIRATION_MONTH = "05";
    private static final String CARD_EXPIRATION_YEAR = "2009";
    private static final String CARD_FIRST_NAME = "Ivan";
    private static final String CARD_MIDDLE_NAME = "Ivanovich";
    private static final String CARD_LAST_NAME = "Ivanov";
    private static final String BILLING_ADDRESS = "1085 Borregas Ave.";
    private static final String BILLING_CITY = "Albuquerque";
    private static final String BILLING_STATE = "New Mexico";
    private static final String BILLING_POSTAL_CODE = "94089";
    private static final String BILLING_COUNTRY = "UNITED STATES";
    private static final String DELIVERY_ADDRESS = "1225 Borregas Ave.";
    private static final String DELIVERY_CITY = "Boston";
    private static final String DELIVERY_STATE = "Massachusetts";
    private static final String DELIVERY_POSTAL_CODE = "91089";
    private static final String DELIVERY_COUNTRY = "UNITED STATES";
    private static final String TITLE_CONFIRMATION_FLIGHT = "Flight Confirmation: Mercury Tours";

    private WebDriver driver;

    @BeforeEach
    void setup(){
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    @DisplayName("✈ Booking flight test ✈")
    void bookingFlight(String browser) {

        if(browser.equals("chrome")) {
           driver = createChromeDriver();
        }
        else if(browser.equals("firefox")) {
           driver = createGeckoDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.setUserName(NAME);
        mainPage.setPassword(PASS);
        mainPage.clickSignIn();

        FindFlightPage findFlightPage = PageFactory.initElements(driver, FindFlightPage.class);
        assertEquals(TITLE_FLIGHT_FINDER, findFlightPage.getTitle(), "Название страницы поиска рейса не соответсвует ожидаемому");
        findFlightPage.setOneWayType();
        findFlightPage.setPassengers(PASS_COUNT);
        findFlightPage.setDepartingFrom(FROM_PORT);
        findFlightPage.setOnMonth(FROM_MONTH);
        findFlightPage.setOnDay(FROM_DAY);
        findFlightPage.setArrivingIn(TO_PORT);
        findFlightPage.setReturningMonth(TO_MONTH);
        findFlightPage.setReturningDay(TO_DAY);
        findFlightPage.setBusinessClass();
        findFlightPage.setAirline(AIRLINE);
        findFlightPage.clickContinue();

        SelectFlightPage selectFlightPage = PageFactory.initElements(driver, SelectFlightPage.class);
        assertAll(
                "Asserts from SelectFlightPage",
                () -> assertEquals(TITLE_SELECT_FLIGHT, selectFlightPage.getTitle(), "Название страницы выбора рейса не соответсвует ожидаемому"),
                () -> assertEquals(FROM_PORT + " to " + TO_PORT, selectFlightPage.getRouteFromDepart(),"Маршрут отправления на странице выбора рейса не соответсвует ожидаемому"),
                () -> assertEquals(DATE_DEPART_FLIGHT, selectFlightPage.getDateFromDepart(), "Дата отправления на странице выбора рейса не соответсвует ожидаемому"),
                () -> assertEquals(TO_PORT + " to " + FROM_PORT, selectFlightPage.getRouteFromReturn(), "Маршрут возвращения на странице выбора рейса не соответсвует ожидаемому"),
                () -> assertEquals(DATE_RETURN_FLIGHT, selectFlightPage.getDateFromReturn(), "Дата возвращения на странице выбора рейса не соответсвует ожидаемому")
        );
        selectFlightPage.setFlight(DEPART_FLIGHT);
        String priceDepartOnSelectPage = selectFlightPage.getPrice(DEPART_FLIGHT);
        selectFlightPage.setFlight(RETURN_FLIGHT);
        String priceReturnOnSelectPage = selectFlightPage.getPrice(RETURN_FLIGHT);
        selectFlightPage.clickContinue();

        BookFlightPage bookFlightPage = PageFactory.initElements(driver, BookFlightPage.class);
        assertAll(
                "Asserts from BookFlightPage",
                () -> assertEquals(TITLE_BOOK_FLIGHT, bookFlightPage.getTitle(), "Название страницы бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(FROM_PORT + " to " + TO_PORT, bookFlightPage.getDepartRouteFromSummary(), "Маршрут отправления на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(DATE_DEPART_FLIGHT, bookFlightPage.getDepartDateFromSummary(), "Дата отправления на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(DEPART_FLIGHT, bookFlightPage.getDepartFlightFromSummary(), "Рейс отправления на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(CLASS_FLIGHT, bookFlightPage.getDepartClassFromSummary(), "Класс рейса отправления на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(priceDepartOnSelectPage, bookFlightPage.getDepartPriceFromSummary(), "Цена рейса отправления на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(TO_PORT + " to " + FROM_PORT, bookFlightPage.getReturnRouteFromSummary(), "Маршрут возвращения на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(DATE_RETURN_FLIGHT, bookFlightPage.getReturnDateFromSummary(), "Дата возвращения на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(RETURN_FLIGHT, bookFlightPage.getReturnFlightFromSummary(), "Рейс возвращения на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(CLASS_FLIGHT, bookFlightPage.getReturnClassFromSummary(), "Класс рейса возвращения на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(priceReturnOnSelectPage, bookFlightPage.getReturnPriceFromSummary(), "Цена рейса возвращения на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(PASS_COUNT, bookFlightPage.getCountPassengersFromSummary(), "Кол-во пассажиров на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(TAXES, bookFlightPage.getTaxesFromSummary(), "Сумма налогов на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(TOTAL_PRICE,bookFlightPage.getTotalPriceFromSummary(), "Цена на странице бронирования рейса не соответсвует ожидаемому"),
                () -> assertEquals(bookFlightPage.calculateTotalPrice(), bookFlightPage.getTotalPriceFromSummary(), "Цена на странице бронирования рассчитана неверно")
        );
        bookFlightPage.setPassFirst0(FIRST_NAME_FIRST_PASSENGER);
        bookFlightPage.setPassLast0(SECOND_NAME_FIRST_PASSENGER);
        bookFlightPage.setMealFirstPassenger(MEAL_FIRST_PASSENGER);
        bookFlightPage.setPassFirst1(FIRST_NAME_SECOND_PASSENGER);
        bookFlightPage.setPassLast1(SECOND_NAME_SECOND_PASSENGER);
        bookFlightPage.setMealSecondPassenger(MEAL_SECOND_PASSENGER);
        bookFlightPage.setCardType(CARD_TYPE);
        bookFlightPage.setCardNumber(CARD_NUMBER);
        bookFlightPage.setCardExpirationMonth(CARD_EXPIRATION_MONTH);
        bookFlightPage.setCardExpirationYear(CARD_EXPIRATION_YEAR);
        bookFlightPage.setCardFirstName(CARD_FIRST_NAME);
        bookFlightPage.setCardMiddleName(CARD_MIDDLE_NAME);
        bookFlightPage.setCardLastName(CARD_LAST_NAME);
        bookFlightPage.setBillingAddress(BILLING_ADDRESS);
        bookFlightPage.setBillingCity(BILLING_CITY);
        bookFlightPage.setBillingState(BILLING_STATE);
        bookFlightPage.setBillingPostalCode(BILLING_POSTAL_CODE);
        bookFlightPage.setBillingCountry(BILLING_COUNTRY);
        bookFlightPage.setSameAsBillingAddress();
        bookFlightPage.setDeliveryAddressAddress(DELIVERY_ADDRESS);
        bookFlightPage.setDeliveryCity(DELIVERY_CITY);
        bookFlightPage.setDeliveryState(DELIVERY_STATE);
        bookFlightPage.setDeliveryPostalCode(DELIVERY_POSTAL_CODE);
        bookFlightPage.setDeliveryCountry(DELIVERY_COUNTRY);
        bookFlightPage.clickSecurePurchase();

        ConfirmationFlightPage confirmationFlightPage = PageFactory.initElements(driver, ConfirmationFlightPage.class);
        assertAll(
                "Asserts from ConfirmationFlightPage",
                () -> assertEquals(TITLE_CONFIRMATION_FLIGHT, confirmationFlightPage.getTitle(), "Название страницы подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(FROM_PORT + " to " + TO_PORT + " " + DATE_DEPART_FLIGHT + " " + DEPART_FLIGHT, confirmationFlightPage.getRouteFromDeparting(), "Информация о рейсе отправленияна на странице подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(TO_PORT + " to " + FROM_PORT + " " + DATE_RETURN_FLIGHT + " " + RETURN_FLIGHT, confirmationFlightPage.getRouteFromReturning(), "Информация о рейсе возвращения на странице подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(PASS_COUNT + " passengers", confirmationFlightPage.getCountPassengers(), "Информация о кол-во пассажиров на странице подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(CARD_FIRST_NAME + " " + CARD_MIDDLE_NAME + " " + CARD_LAST_NAME + " " + BILLING_ADDRESS + " " + BILLING_CITY + ", " + BILLING_STATE + ", " + BILLING_POSTAL_CODE + " AX 0", confirmationFlightPage.getBilledTo(), "Информация для выставления счета на странице подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(DELIVERY_ADDRESS + " " + DELIVERY_CITY + ", " + DELIVERY_STATE + ", " + DELIVERY_POSTAL_CODE, confirmationFlightPage.getDeliveryAddress(), "Информация об адресе доставки на странице подтверждения рейса не соответсвует ожидаемому"),
                () -> assertEquals(confirmationFlightPage.calculateTotalPrice(PASS_COUNT), confirmationFlightPage.geTotalPrice(), "Цена на странице бронирования рассчитана неверно")
        );
        confirmationFlightPage.clickBackToHome();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}