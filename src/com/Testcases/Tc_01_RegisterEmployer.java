package com.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GenericMethods.GenericMethods;
import com.ScreenFunction.Employer_RegistrationForm;
import com.ScreenFunction.HomePage;

public class Tc_01_RegisterEmployer extends GenericMethods{
	
	
	@BeforeTest
	public static void callReportGeneration()
	{
	intializeReport("Tc_01_RegisterEmployer");
	startTest("Tc_01_RegisterEmployer");
	loadExcelFile();
	}
	@AfterTest
	public static void publishReport()
	{
		endReport();
	}
	
	@Test
	public static void validate_EmployerRegistration()
	{
		boolean status;
		
		status=launchBrowser("ff");
		
		// get the status of browser launch and proceed to register as employer
		if(status)
		{
			logEvent("pass", "Browser is launched sucessfull");
			HomePage hmpge=PageFactory.initElements(driver, HomePage.class);
			
			status=hmpge.register_Employer();
			
			// get the status for the navigation and verify the page is loaded sucessfully
			
			if(status)
			{
			System.out.println("User is navigated Sucessfully to the registration page");
			Employer_RegistrationForm erf=PageFactory.initElements(driver, Employer_RegistrationForm.class);
			status=erf.waitForPageLoad();
			
			// Enter Mandatory Details on the form
			
			if(status)
			{
				erf.enterDetails_RegisterForm("Tc_01_RegisterEmployer");
			}
			
			
			
			}
			
			
			
		}else
		{
			System.out.println("User failed to launch browser, Unable to proceed further");
			logEvent("fail", "Browser is not launched sucessfull");
		}
		
		
		
	}

}
