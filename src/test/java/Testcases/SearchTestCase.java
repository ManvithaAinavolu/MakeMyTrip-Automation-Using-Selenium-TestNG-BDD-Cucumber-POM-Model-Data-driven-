package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.libraryClass;
import Pages.MakeMyTripSearchPlace;

public class SearchTestCase extends libraryClass {
SearchTestCase(){
	
}
MakeMyTripSearchPlace ms;

@BeforeTest
public void openApp() {
    initializeBrowser();                            // Step 1: launch browser
    openApplication(); // Step 2: open site
    ms = new MakeMyTripSearchPlace(driver);         // Step 3: initialize page object
}

@Test
public void searchPlace() throws InterruptedException {
	
    ms.enterFromCity("Bengaluru");
}

@Test
public void toPlace() throws InterruptedException {
	
    ms.enterToCity("Delhi");
}

@Test
public void search() throws InterruptedException {
	
    ms.clickSearch();
}

@AfterTest
public void closeApp() {
    closeBrowser();  // Proper cleanup after tests
}
}
