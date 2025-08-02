package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ReusableFunctions;

public class MakeMyTripTicketBooking {
WebDriver driver;
ReusableFunctions rf;
public MakeMyTripTicketBooking(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	rf=new ReusableFunctions(driver);
	
	
}
@FindBy(xpath ="//p[text()='Zero charges when the ticket is cancelled']")
public WebElement radioBtn;

@FindBy(xpath="//span[contains(@class,'plusSign')]")
public WebElement plus;

@FindBy(id="name")
public WebElement Name;

@FindBy(id="age")
public WebElement Age;

@FindBy(xpath="//*[@id=\"mmt-rails-add-traveller\"]/div/li/div[3]/div[2]/div/form/div[3]/div")
public WebElement gender;

@FindBy(xpath="//*[@id=\"mmt-rails-add-traveller\"]/div/li/div[3]/div[2]/div/form/div[5]/div")
public WebElement berth;

@FindBy(xpath="//*[@id=\"mmt-rails-add-traveller\"]/div/li/div[3]/div[2]/div/form/div[6]/div/p")
public WebElement food;

@FindBy(xpath="//button[text()='Add']")
public WebElement add;

@FindBy(id="irctcUserName")
public WebElement user;

@FindBy(xpath="//input[@class='inputFieldNew']")
public WebElement username;

@FindBy(xpath="//span[text()='CHECK']")
public WebElement checkbtn;

@FindBy(xpath="//span[text()='SAVE & CLOSE']")
public WebElement save;

@FindBy(xpath="//label[contains(text(),'IRCTC password')]/preceding::input[1]")
public WebElement checkBox;

@FindBy(id="contactEmail")
public WebElement email;

@FindBy(id="mobileNumber")
public WebElement mobile;

@FindBy(xpath="//p[text()='Confirm and save billing details to your profile']")
public WebElement consent;

@FindBy(xpath="//span[text()='Pay & Book Now']")
public WebElement book;

public void closeModalIfPresent() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".ReactModal__Overlay")
        ));
        if (modal.isDisplayed()) {
            WebElement closeBtn = driver.findElement(By.cssSelector(".closeIcon")); // update this selector as per actual DOM
            closeBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(modal));
        }
    } catch (Exception e) {
        // Modal not present, continue
    }
}

public void selectCharges() {
	rf.clickElement(radioBtn);
}
public void enterBasicDetails(String name, String age) {
    rf.clickElement(plus);
    rf.enterText(Name, name);
    rf.enterText(Age, age);
}

public void selectGender(String genderValue) {
    rf.selectValueFromDropdown(gender, genderValue);
}

public void selectBerth(String berthValue) {
    rf.selectValueFromDropdown(berth, berthValue);
}

public void selectFood(String foodValue) {
    rf.selectValueFromDropdown(food, foodValue);
}

public void clickAdd() {
	rf.clickElement(add);
}
public void enterUserName() throws InterruptedException {
	rf.clickElement(user);
	Thread.sleep(3000);

	rf.enterText(username, "Lahari22052001");
	Thread.sleep(3000);

	rf.clickElement(checkbtn);
	rf.clickElement(checkBox);
	rf.clickElement(save);
	
	rf.enterText(email, "manvitha@gmail.com");
	
	rf.enterText(mobile, "9876543210");
	;
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", consent);

		Thread.sleep(3000);
	    consent.click();
Thread.sleep(3000);
	rf.clickElement(book);
}
public void takescreesnshot() throws IOException {
	rf.takescreenshot("src/test/resources/PayAndBook.png");
}
}
