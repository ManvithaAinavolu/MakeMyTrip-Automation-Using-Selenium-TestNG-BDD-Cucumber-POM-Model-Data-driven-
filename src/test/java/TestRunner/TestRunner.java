package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		    features = {"src/test/resources/features"},      // Path to feature files

		    glue = {"Stepdefinitions","Hooks"},      
		    // Package for step definitions and hooks
		    tags="@dataTable",

		    		plugin = {

		    		        "pretty",

		    		        "html:target/cucumber-html-report.html",

		    		        "json:target/cucumber.json",

		    		        "rerun:target/rerun.txt",
		    		        
		    		        "TestRunner.CucumberExtentReportPlugin"

		    		       	    		    },
		    		dryRun=true,

		    		 monochrome = true


		)

		public class TestRunner extends AbstractTestNGCucumberTests {

		    // Empty class - the annotations drive the configuration

	}
	 

