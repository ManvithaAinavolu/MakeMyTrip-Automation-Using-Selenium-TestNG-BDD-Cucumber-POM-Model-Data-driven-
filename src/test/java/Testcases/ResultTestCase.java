package Testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.libraryClass;
import Pages.MakeMyTripResultPage;


public class ResultTestCase extends libraryClass {
ResultTestCase(){
	
}
MakeMyTripResultPage ms;

@BeforeTest
public void openApp() {
    initializeBrowser();                            // Step 1: launch browser
    openApplication(); // Step 2: open site
    ms = new MakeMyTripResultPage(driver);         // Step 3: initialize page object
}

@Test(priority=1)
public void setTrains() {
	ms.chooseTrains();
}
@Test(priority=2)
public void searchPlace() throws InterruptedException {
	
    ms.enterFromCity("Mumbai");
}

@Test(priority=3)
public void toPlace() throws InterruptedException {
	
    ms.enterToCity("Delhi");
}

@Test(priority=4)
public void selectDepartureDate() throws InterruptedException {
	System.out.println("Travel date is started");
	ms.selectTravelDate("August 2025", "1");
	System.out.println("Travel date is ended");
}

@Test(priority=5)
public void setClass() throws InterruptedException {
	ms.selectTravelClass("Sleeper Class");
}

@Test(priority=6)
public void search() throws InterruptedException {
    try {
        ms.clickSearch();
    } catch (IOException e) {
        e.printStackTrace();  // or log error properly
    }
    System.out.println("Result Page is Loaded."+driver.getTitle());
    
    Thread.sleep(5000);
}

@AfterTest
public void closeApp() {
    closeBrowser();  // Proper cleanup after tests

}
}
