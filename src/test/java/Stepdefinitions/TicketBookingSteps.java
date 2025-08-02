package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BaseClass.libraryClass;
import Pages.MakeMyTripFilters;
import Pages.MakeMyTripResultPage;
import Pages.MakeMyTripTicketBooking;
import Utilities.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketBookingSteps extends libraryClass {
	ReusableFunctions re;
	MakeMyTripResultPage rp;
	MakeMyTripFilters mf;
	MakeMyTripTicketBooking mbp;
	
	 private static final Logger logger = LogManager.getLogger(libraryClass.class);
	   
	@Given("enter travveler details using IRCTC Username")
	public void enter_travveler_details_using_irctc_username() {
		re=new ReusableFunctions(driver);
	    rp=new MakeMyTripResultPage(driver);
	    rp.closeLoginPopupIfPresent();
	    mf = new MakeMyTripFilters(driver);
	    mbp=new MakeMyTripTicketBooking(driver);
	    
		logger.info("In Details page...");
	    mbp.selectCharges();
	    
	}

	@When("Click on Add Trveller to enter the traveller details and enter the valid IRCTC Username")
	public void click_on_add_trveller_to_enter_the_traveller_details_and_enter_the_valid_irctc_username() throws InterruptedException {
		logger.info("Entering details of traveller...");
		mbp.enterBasicDetails("Manvitha", "21");
		mbp.selectGender("Female");
	    mbp.selectBerth("Lower");
	    mbp.selectFood("Veg");
	    mbp.clickAdd();
	    
	    Thread.sleep(2000);
	    
	}

	@Then("Give Contact email , mobile number and click on consent")
	public void give_contact_email_mobile_number_and_click_on_consent() throws InterruptedException, IOException {
		mbp.closeModalIfPresent();
		mbp.enterUserName();
		Thread.sleep(3000);
		mbp.takescreesnshot();
	    
	}

	@Then("Click on Pay and Book Ticket, Close the Browser")
	public void click_on_pay_and_book_ticket_close_the_browser() {
		logger.info("Pay and Book now is clicked...");
	   // closeBrowser();
	    
	}
}
