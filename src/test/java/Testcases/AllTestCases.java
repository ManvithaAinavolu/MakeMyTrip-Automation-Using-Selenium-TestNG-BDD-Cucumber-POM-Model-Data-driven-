package Testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.libraryClass;
import Pages.MakeMyTripFilters;
import Pages.MakeMyTripResultPage;
import Pages.MakeMyTripTicketBooking;

public class AllTestCases extends libraryClass{

	AllTestCases(){
		
	}
	MakeMyTripResultPage ms;
	
	MakeMyTripFilters mf;
	MakeMyTripTicketBooking mbp;
	
	@BeforeTest
	public void openApp() {
	    initializeBrowser();                            // Step 1: launch browser
	    openApplication(); // Step 2: open site
	    ms = new MakeMyTripResultPage(driver);   
	    // Step 3: initialize page object
	    mf=new MakeMyTripFilters(driver);
	    mbp=new MakeMyTripTicketBooking(driver);
	    
	}

	@Test(priority=1)
	public void setTrains() {
		ms.closeLoginPopupIfPresent();
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
		ms.selectTravelDate("July 2025", "29");
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
	@Test(priority=7)
	public void chooseSort() throws InterruptedException {
		mf.selectSort();
	}

	@Test(priority=8)
	public void setFilter() throws InterruptedException {
		mf.selectFilter("AC");
		mf.selectFilter("Free Cancellation");
		mf.selectFilter("General Quota");
		
	}
	
	@Test(priority=9)
	public void selectTrain() throws InterruptedException {
		mf.selectTrain("");
		System.out.println("Page Title:"+driver.getTitle());
		Thread.sleep(5000);
		
	}
	@Test(priority=10)
	public void takePicture() throws IOException {
		mf.takescreesnshot();
	}
	
	@Test(priority=11)
	public void setTravellerdeatils() throws InterruptedException {
		mbp.selectCharges();
		mbp.enterBasicDetails("Manvitha","21");
		mbp.selectGender("Female");
	    mbp.selectBerth("Lower");
	    mbp.selectFood("Veg");
	    mbp.clickAdd();
	    
	    Thread.sleep(2000);
	}
	@Test(priority=12)
	public void setIRCTCName() throws InterruptedException, IOException {
		mbp.closeModalIfPresent();
		mbp.enterUserName();
		Thread.sleep(3000);
		mbp.takescreesnshot();
	}
	@AfterTest
	public void closeApp() {
	    closeBrowser();  // Proper cleanup after tests

	}
}
