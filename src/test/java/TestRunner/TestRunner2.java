package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		    features = {"src/test/resources/features"},      // Path to feature files

		    glue = {"Stepdefinitions"},      
		    // Package for step definitions and hooks
		    tags="@totalBooking",

		    		plugin = {

		    		        "pretty",

		    		        "html:target/cucumber-html-report.html",

		    		        "json:target/cucumber.json",

		    		        "rerun:target/rerun.txt",
		    		        
		    		        "TestRunner.CucumberExtentReportPlugin"

		    		       	    		    },

		    		 monochrome = false


		)

		public class TestRunner2 extends AbstractTestNGCucumberTests {

		    // Empty class - the annotations drive the configuration

	}
	 

