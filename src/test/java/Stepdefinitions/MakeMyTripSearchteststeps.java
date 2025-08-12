package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BaseClass.libraryClass;
import Pages.MakeMyTripFilters;
import Pages.MakeMyTripResultPage;
import Utilities.ReusableFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeMyTripSearchteststeps extends libraryClass{
	ReusableFunctions re;
	MakeMyTripResultPage rp;
	MakeMyTripFilters mf;
	 private static final Logger logger = LogManager.getLogger(libraryClass.class);
	   
	@Given("To Launch the browser and enter url")
	public void to_launch_the_browser_and_enter_url() {
//	    initializeBrowser();
//	    openApplication();
	    logger.info("Application Launched");
	    re=new ReusableFunctions(driver);
	    rp=new MakeMyTripResultPage(driver);
	    rp.closeLoginPopupIfPresent();
	    rp.chooseTrains();
	    
	}

	@When("Choose the From, To , Departure ,Select class for the Trains")
	public void choose_the_from_to_departure_select_class_for_the_trains() throws InterruptedException {
	    rp.enterFromCity("Chennai");
	    rp.enterToCity("Coimbatore");
	    rp.selectTravelDate("July 2025", "29");
	    rp.selectTravelClass("Sleeper Class");
	}

	@Then("click on search button")
	public void click_on_search_button() throws InterruptedException, IOException {
		rp.clickSearch();
	    
	}

	@Then("close the Browser")
	public void close_the_browser() {
		logger.info("Got the results");
		//closeBrowser();
		logger.info("Closed the browser");
		
	    
	}
	
	@Given("To search for trains in General Quota")
	public void to_search_for_trains_in_general_quota() throws InterruptedException, IOException {
//		initializeBrowser();
//	    openApplication();
	    logger.info("Application Launched...");
	    
	    re = new ReusableFunctions(driver);
	    rp = new MakeMyTripResultPage(driver);
	    mf = new MakeMyTripFilters(driver);

	    rp.closeLoginPopupIfPresent();
	    rp.chooseTrains();
	    
	    rp.enterFromCity("Chennai");
	    rp.enterToCity("Coimbatore");
	    rp.selectTravelDate("August 2025", "29");
	    rp.selectTravelClass("Sleeper Class");
	    rp.clickSearch();
	    logger.info("Searched for trains...");
	}

	@When("Choose AC, Ticket Type, Quota for the trains")
	public void choose_ac_ticket_type_quota_for_the_trains() throws InterruptedException {
	   mf.selectSort();
	   mf.selectFilter("AC");
		mf.selectFilter("Free Cancellation");
		mf.selectFilter("General Quota");
		logger.info("Filter applied...");
		
	}

	@Then("Click on the preferred train")
	public void click_on_the_preferred_train() throws InterruptedException {
		re.clickFirstTrainCard();
		logger.info("Train selected ...");
	}

	@Then("Take Screenshot")
	public void take_screenshot_and_close_browser() throws IOException {
	   mf.takescreesnshot();
	   logger.info("took screesnshot...");
	//   closeBrowser();
	   
	}



}
