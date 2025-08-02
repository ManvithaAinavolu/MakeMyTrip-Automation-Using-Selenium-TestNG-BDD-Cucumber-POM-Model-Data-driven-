package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {

    WebDriver driver;

    public ReusableFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void takescreenshot(String path) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
    }
    public void selectDropdownByText(WebElement dropdownElement, String visibleText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }
  

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void selectFromAutoSuggest(String valueToSelect) throws InterruptedException {
        Thread.sleep(2000); // wait for the suggestion list to load
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().toLowerCase().contains(valueToSelect.toLowerCase())) {
                suggestion.click();
                break;
            }
        }
    }

    public void scrolldown(String element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath(element));
        js.executeScript("arguments[0].click();", ele);
    }

    public void selectRadioButton(By locator) {
        WebElement radio = driver.findElement(locator);
        if (!radio.isSelected()) {
            radio.click();
        }
    }
    public void clickSearch(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", element);
    }

    public void windowhandling(String element) {
        driver.findElement(By.xpath(element)).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window: " + mainWindow);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + driver.getTitle());
            }
        }

        driver.switchTo().window(mainWindow); // Return to original window
    }
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    public void alerthandling(String value) throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        Thread.sleep(4000);
        alert.sendKeys(value);
        alert.accept();
    }
    public void selectDate(String dateLabel) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@aria-label='" + dateLabel + "']")));
        dateElement.click();
    }
    public void selectDateFromCalendar(String monthYear, String day) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the month header
        WebElement caption = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='DayPicker-Caption']/div")
        ));

        // Loop until desired month is visible
        while (!caption.getText().equalsIgnoreCase(monthYear)) {
            WebElement nextArrow = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
            nextArrow.click();
            Thread.sleep(1000);  // Let UI update
            caption = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div"));  // Refresh element
        }

        // Wait and click on the date
        WebElement dateToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		 By.xpath("//div[contains(@class, 'DayPicker-Day') and text()='" + day + "']")
        ));

        dateToClick.click();
    }

public void selectTravelCalssfromDropDown(String Value) throws InterruptedException {
	WebElement dropdown = driver.findElement(By.xpath("//label[@for='travelClass']"));
    dropdown.click();
    Thread.sleep(1000); // or use WebDriverWait

    // Step 2: Click the correct option from the list
    WebElement option = driver.findElement(By.xpath("//li[text()='" + Value + "']"));
    option.click();
}
public void selectFilterByLabel(String labelText) {
    try {
        String xpath = "//p[contains(text(),'" + labelText + "') and contains(@class,'inputLabelText')]";
        WebElement filterElement = driver.findElement(By.xpath(xpath));
        if (filterElement.isDisplayed() && filterElement.isEnabled()) {
            filterElement.click();
            System.out.println("Clicked on filter: " + labelText);
        } else {
            System.out.println("Filter not clickable: " + labelText);
        }
    } catch (Exception e) {
        System.out.println("Filter '" + labelText + "' not found or failed to click: " + e.getMessage());
    }
}
public void clickFirstTrainCard() {
    try {
        // Locate the first train card in the filtered list
        WebElement firstCard = driver.findElement(By.xpath("(//div[contains(@class,'ListingCard_ListingCard')])[1]"));
        
        // Within that card, find the class selection button (e.g., 1A, 2A)
        WebElement card = firstCard.findElement(By.xpath(".//div[contains(@class,'Cards_cardContainer')]"));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(card)).click();
        
        System.out.println("Clicked on the first visible train card.");
    } catch (Exception e) {
        System.out.println("Failed to click on the first train card: " + e.getMessage());
    }
}

public WebElement enterTravellerDetails(String tagName,String visibleText) {
	String xpath = "//" + tagName + "[text()='" + visibleText + "']";
    return driver.findElement(By.xpath(xpath));
	
}
public void selectValueFromDropdown(WebElement dropdownBtn, String value) {
    dropdownBtn.click();
    By optionXpath = By.xpath("//li//span[text()='" + value + "']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionXpath));
    option.click();
}



}
