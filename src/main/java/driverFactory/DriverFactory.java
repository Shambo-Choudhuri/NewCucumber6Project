package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	//This method can be accessed by only one Thread at a time
	
	public synchronized WebDriver getDriverInstance()
	{
		driver=tlDriver.get();
		return driver; //Return the Thread Safe and ThreadLocal WebDriver object
		
	}
	
	//ThreadLocal WebDriver object without Browser Options
	
		public WebDriver init_driver(String browser)
		{
			
			switch(browser)
			{
				case "chrome":
						WebDriverManager.chromedriver().setup();
						//Non-Thread Local WebDriver object
						driver=new ChromeDriver();
						//Now give the Non-ThreadLocal WebDriver object as input parameter
						tlDriver.set(driver);
						System.out.println("Tests Running on chrome browser");
						break;
						
				case "firefox":
					    WebDriverManager.firefoxdriver().setup();
					    //Non-Thread Local WebDriver object
					    driver=new FirefoxDriver();
					   //Now give the Non-ThreadLocal WebDriver object as input parameter
					    tlDriver.set(driver);
					    System.out.println("Tests Running on firefox browser");
					    break;
					    
			    default:
			    		System.out.println("Please enter a valid browser");
			    	    
					    
			}
			
			driver=getDriverInstance();
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			return driver; 
			
			//returning a thread safe and ThreadLocal WebDriver object
		}

}
