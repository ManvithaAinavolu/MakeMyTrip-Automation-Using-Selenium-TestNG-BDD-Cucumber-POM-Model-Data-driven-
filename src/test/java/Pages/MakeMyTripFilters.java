package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableFunctions;

public class MakeMyTripFilters {
WebDriver driver;
ReusableFunctions rf;
public MakeMyTripFilters(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
    rf = new ReusableFunctions(driver);

}
@FindBy(xpath="//p[contains(@class,'labelText') and text()='Travel Time']")
public WebElement sortBy;

//@FindBy(xpath="//p[contains(@class,'Checkbox') and text()='AC']")
//public WebElement AC_check;
//
//@FindBy(xpath="//p[contains(@class,'inputLabelText') and text()='Free Cancellation']")
//public WebElement ticketType;
//
//@FindBy(xpath="//p[contains(@class,'inputLabelText') and text()='Tatkal']")
//public WebElement quota;

@FindBy(xpath = "//p[contains(text(),'Ndls Duronto')]") 
WebElement trainOption;



public void selectSort() throws InterruptedException {
	rf.clickElement(sortBy);
	Thread.sleep(1000);
}
public void selectFilter(String filterName) throws InterruptedException {
    rf.selectFilterByLabel(filterName);
    Thread.sleep(1000);
}

public void selectTrain(String trainName) throws InterruptedException {
    rf.clickFirstTrainCard();
    Thread.sleep(1000);
}
public void takescreesnshot() throws IOException {
	rf.takescreenshot("src/test/resources/TrainBooking.png");
}
}
