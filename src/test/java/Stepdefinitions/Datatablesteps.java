package Stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BaseClass.libraryClass;
import Pages.MakeMyTripFilters;
import Pages.MakeMyTripResultPage;
import Utilities.ReusableFunctions;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.*;

public class Datatablesteps extends libraryClass{
	ReusableFunctions re;
	MakeMyTripResultPage rp;
	MakeMyTripFilters mf;
	 private static final Logger logger = LogManager.getLogger(libraryClass.class);
	   
	@When("Enter {string}, {string}, {string}, {string}, {string} for Trains")
	public void enter_for_trains(String string, String string2, String string3, String string4, String string5, DataTable dataTable) throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		re = new ReusableFunctions(driver);
	    rp = new MakeMyTripResultPage(driver);
	    mf = new MakeMyTripFilters(driver);
		List<List<String>> data = dataTable.asLists();

		for(int i=1;i<data.size();i++) {
			List<String> row = data.get(i);
			rp.enterFromCity(row.get(0)); // from
		    rp.enterToCity(row.get(1));   // to
		    rp.selectTravelDate(row.get(2), row.get(3)); // travelMonth, travelDay
		    rp.selectTravelClass(row.get(4)); // class
		}
		rp.clickSearch();
		logger.info("Got the results");
		   
	}

	@When("Select AC, Ticket Type, Quota for the trains")
	public void select_ac_ticket_type_quota_for_the_trains() throws InterruptedException {
		mf.selectSort();
		   mf.selectFilter("AC");
			mf.selectFilter("Free Cancellation");
			mf.selectFilter("General Quota");
			logger.info("Filter applied...");
	}

	@Then("choose on the preferred train")
	public void choose_on_the_preferred_train() throws InterruptedException {
		mf.selectTrain("");
		System.out.println("Page Title:"+driver.getTitle());
		Thread.sleep(5000);
	}

	@Then("Take a Screenshot")
	public void take_a_screenshot() throws IOException {
	    mf.takescreesnshot();
	}


}
