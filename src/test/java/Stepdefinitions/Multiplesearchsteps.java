package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BaseClass.libraryClass;
import Pages.MakeMyTripFilters;
import Pages.MakeMyTripResultPage;
import Utilities.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Multiplesearchsteps extends libraryClass {
	ReusableFunctions re;
	MakeMyTripResultPage rp;
	MakeMyTripFilters mf;
	 private static final Logger logger = LogManager.getLogger(libraryClass.class);
	
	@Given("Launch the browser and navigate to URL")
	public void launch_the_browser_and_navigate_to_url() {
//		initializeBrowser();
//	    openApplication();
	    logger.info("Application Launched");
	    re=new ReusableFunctions(driver);
	    rp=new MakeMyTripResultPage(driver);
	    rp.closeLoginPopupIfPresent();
	    rp.chooseTrains();
	      
	}

	@When("choose {string}, {string}, {string}, {string}, {string} for Trains")
	public void choose_from_to_departure_class_type_for_trains(String from, String to, String travelMonth, String travelDay, String Class) throws InterruptedException {
	    logger.info("Entering search parameters: From=" + from + ", To=" + to + ", Date=" + travelDay + " " + travelMonth + ", Class=" + Class);

	    rp.enterFromCity(from);
	    rp.enterToCity(to);
	    rp.selectTravelDate(travelMonth, travelDay);
	    rp.selectTravelClass(Class);
	}

	@Then("click on search")
	public void click_on_search() throws InterruptedException, IOException {
		rp.clickSearch();
		logger.info("Clicked on Search");
	}

	@Then("close the browser")
	public void close_the_browser() {
	 //   closeBrowser();
	    logger.info("Browser closed");
}
}
