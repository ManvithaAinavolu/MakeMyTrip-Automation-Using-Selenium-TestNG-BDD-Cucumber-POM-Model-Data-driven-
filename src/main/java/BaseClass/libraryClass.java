package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class libraryClass {
    protected static WebDriver driver;
    protected static Properties config = new Properties();
    private static final Logger logger = LogManager.getLogger(libraryClass.class);
    
    
    // Load config.properties
    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Configuration.Properties/Config.property");
            config.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
        }
    }

    // Initialize browser based on config
    public static void initializeBrowser() {
        loadConfig();
        String browser = config.getProperty("browser", "chrome");
        logger.info("Launching browser....");
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));

        if (browser.equalsIgnoreCase("chrome")) {
//        
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Unsupported browser specified in config.");
        }

        driver.manage().window().maximize();
        logger.info("Maximizing browser....");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    // Open application using config URL
    public static void openApplication() {
        String url = config.getProperty("url");
        driver.get(url);
        logger.info("Navigate to URL....");
    }

    // Close the browser
    public static void closeBrowser() {
        if (driver != null) {
        	logger.info("Closing browser....");
            driver.quit();
        }
    }
}
