package Testcases;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Saucelabs_example {



	

	 @Test

	    public void runOnSauceLabs() throws Exception {

	        String sauceUserName = "oauth-manvithaainavolu-cf739";

	        String sauceAccessKey = "0405d984-926d-4439-8c2a-951b85725e4f";
 
	        // Sauce Labs URL

	        String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey +

	                  "@ondemand.eu-central-1.saucelabs.com/wd/hub";
 
	        // Desired capabilities

	        DesiredCapabilities caps = new DesiredCapabilities();

	        caps.setCapability("browserName", "chrome");

	        caps.setCapability("platformName", "Windows 11");

	        caps.setCapability("browserVersion", "latest");
 
	        // Sauce-specific options

	        caps.setCapability("sauce:options", new java.util.HashMap<String, Object>() {{

	            put("name", "Filpkart Test");

	            put("build", "Build-102");

	        }});
 
	        // Start remote driver

	        WebDriver driver = new RemoteWebDriver(new URL(sauceURL), caps);
 
	        driver.get("https://www.flipkart.com/");

	        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input")).sendKeys("mobiles");	        

	        System.out.println("Title: " + driver.getTitle());
 
	        driver.quit();

	    }
 


//	 @Test
//
//	    public void runOnSauceLabs() throws Exception {
//
//	        String sauceUserName = "oauth-franklintraining16-65b97";
//
//	        String sauceAccessKey = "7d996a52-937e-4485-b067-80a124c6164e";
// 
//	        // Sauce Labs URL
//
//	        String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey +
//
//	                  "@ondemand.eu-central-1.saucelabs.com/wd/hub";
// 
//	        // Desired capabilities
//
//	        DesiredCapabilities caps = new DesiredCapabilities();
//
//	        caps.setCapability("browserName", "safari");
//
//	        caps.setCapability("platformName", "macOS 13");
//
//	        caps.setCapability("browserVersion", "latest");
// 
//	        // Sauce-specific options
//
//	        caps.setCapability("sauce:options", new java.util.HashMap<String, Object>() {{
//
//	            put("name", "Filpkart Test");
//
//	            put("build", "Build-102");
//
//	        }});
// 
//	        // Start remote driver
//
//	        WebDriver driver = new RemoteWebDriver(new URL(sauceURL), caps);
// 
//	        driver.get("https://www.flipkart.com/");
//
//	        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input")).sendKeys("mobiles");	        
//
//	        System.out.println("Title: " + driver.getTitle());
// 
//	        driver.quit();
//
//	    }
//

 
}
