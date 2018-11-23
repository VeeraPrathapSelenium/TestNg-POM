package com.GenericMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ReportGeneration.ExtentReports_Generation;
import com.relevantcodes.extentreports.ExtentReports;

public class GenericMethods extends ExtentReports_Generation{
	
	
	public static WebDriver driver;
	
	
	public static boolean launchBrowser(String browser)
	{
		System.out.println("Launching browser");
		boolean status=true;
		
		try
		{
			switch (browser.toString()) {
			case "ff":
				driver=new FirefoxDriver();
				
				break;
			case "chrome":
				driver=new ChromeDriver();
				break;
			default:
				System.out.println("invalid browser type");
				break;
			}
		}catch(Exception e)
		{
			status=false;
			System.out.println(e.getMessage());
		}
		driver.get("https://www.talentzing.com/");
		driver.manage().window().maximize();
		System.out.println("Launching browser is completed");
		return status;
		
		
	}
	
	
	
	

}
