package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableFunctions;

public class MakeMyTripResultPage {

WebDriver driver;
ReusableFunctions rf;

public MakeMyTripResultPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    rf = new ReusableFunctions(driver);
}
@FindBy(xpath = "//span[@class='commonModal__close']")
public WebElement loginCloseBtn;

@FindBy(xpath="//span[contains(@class,'chTrains')]")
public WebElement trains;

@FindBy(xpath = "//span[text()='From']")
public WebElement fromSpan;

@FindBy(xpath = "//input[@placeholder='From']")
public WebElement fromInputActive;

@FindBy(xpath = "//span[text()='To']")
public WebElement toSpan;

@FindBy(xpath = "//input[@placeholder='To']")
public WebElement toInputActive;


@FindBy(xpath="//label[@for='travelDate']")
public WebElement travelDate;

@FindBy(id="travelClass")
public WebElement travelClass;

//
//@FindBy(xpath = "//li[@data-cy='roundTrip']")
//public WebElement roundTripOption;
//
//@FindBy(xpath = "//span[text()='Departure']")
//public WebElement departureLabel;  // more reliable
//
//@FindBy(xpath = "//span[text()='Return']")
//public WebElement returnLabel;

//@FindBy(xpath = "//div[@aria-label='Thu Jul 10 2025']")
//public WebElement departureDateToSelect;
//
//@FindBy(xpath = "//div[@aria-label='Fri Jul 11 2025']")
//public WebElement returnDateToSelect;


@FindBy(xpath = "//a[contains(@class, 'widgetSearchBtn')]")
public WebElement searchBtn;

@FindBy(xpath="//div[contains(@class,'listingCard')]")
public WebElement result;
public void closeLoginPopupIfPresent() {
    try {
        Thread.sleep(2000);
        if (loginCloseBtn.isDisplayed()) {
            loginCloseBtn.click();
        }
    } catch (Exception e) {
        // Ignore if not present
    }
}

public void chooseTrains() {
	closeLoginPopupIfPresent();
	rf.clickElement(trains);
	
}
public void enterFromCity(String city) throws InterruptedException {
    closeLoginPopupIfPresent();
    rf.clickElement(fromSpan); // this activates the field
    Thread.sleep(1000);
    rf.enterText(fromInputActive, city);
    rf.selectFromAutoSuggest(city); // simplified usage
}


public void enterToCity(String city) throws InterruptedException {
    rf.clickElement(toSpan);
    Thread.sleep(1000);
    rf.enterText(toInputActive, city);
    rf.selectFromAutoSuggest(city);
}

public void selectTravelDate(String monthYear, String day) throws InterruptedException {
	chooseTrains();
    rf.clickElement(travelDate); // click the date input to open the calendar
    //Thread.sleep(1000);
    rf.selectDateFromCalendar(monthYear, day); // delegate logic to ReusableFunctions
}

public void selectTravelClass(String value) throws InterruptedException {
	rf.selectTravelCalssfromDropDown(value);
	
	
}
//public void selectRoundTripOption() {
//	closeLoginPopupIfPresent();
//    rf.clickElement(roundTripOption);
//}

//public void selectDepartureDate() throws InterruptedException {
//    rf.clickElement(departureLabel);
//    Thread.sleep(2000);
//    rf.clickElement(departureDateToSelect);
//}
//
//public void selectReturnDate() throws InterruptedException {
//    rf.clickElement(returnLabel); // open return date calendar
//    Thread.sleep(2000);
//    rf.clickElement(returnDateToSelect); // select return date
//}


public void clickSearch() throws InterruptedException, IOException {
    closeLoginPopupIfPresent();
    rf.waitForElementToBeVisible(searchBtn);
    rf.clickSearch(searchBtn);
    
    System.out.println("Flight Results Page Loaded.");
}



}