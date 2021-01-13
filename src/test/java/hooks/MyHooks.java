package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import configReader.ConfigReader;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;
	private ConfigReader configReader;
	
	@Before(order=0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browser=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browser);
	}
	
	@Before(order=2)
	public void launchURL()
	{
		String url=prop.getProperty("url");
		driver.get(url);
	}
	
	
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void takeScreenshotForFailedScenario(Scenario scenario)
	{
		//Capture the Screenshot for Failed scenarios
		if(scenario.isFailed())
		{
			String screenshotName=scenario.getName().replaceAll("","_");
		
			//WebDriver driver=new ChromeDriver();
		
			//TakesScreenshot screenshot=new ChromeDriver();
				
			TakesScreenshot screenshot=(TakesScreenshot)driver;
				
			//Take the Screenshot which returns the source path of the screenshot captured
				
			byte[] sourcePath=screenshot.getScreenshotAs(OutputType.BYTES);
		
			//Attach the screenshot with the Test Report
		
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	
	
	
	
	
	

}
