package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.ReusableFunctions;

public class MakeMyTripSearchPlace {

    WebDriver driver;
    ReusableFunctions rf;

    public MakeMyTripSearchPlace(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rf = new ReusableFunctions(driver);
    }

    @FindBy(xpath = "//span[@class='commonModal__close']")
    public WebElement loginCloseBtn;

    @FindBy(xpath = "//span[text()='From']")
    public WebElement fromSpan;

    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement fromInputActive;

    @FindBy(xpath = "//span[text()='To']")
    public WebElement toSpan;

    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement toInputActive;

    @FindBy(xpath = "//a[contains(@class, 'widgetSearchBtn')]")
    public WebElement searchBtn;

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

    public void clickSearch() throws InterruptedException {
        closeLoginPopupIfPresent();
        rf.waitForElementToBeVisible(searchBtn);
        Thread.sleep(1000);
        rf.clickElement(searchBtn);
    }
}
