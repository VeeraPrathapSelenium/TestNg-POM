package com.ScreenFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericMethods.GenericMethods;

public class Employer_RegistrationForm extends GenericMethods{
//*******************  WebElements *************************************
	
@FindBy(how=How.XPATH,using="//input[@id='ctl00_ContentPlaceHolder2_txtCompanyname']")
	
	public static WebElement Edi_CompanyName;
	
@FindBy(how=How.XPATH,using="//input[@id='ctl00_ContentPlaceHolder2_txtemail']")
	
	public static WebElement Edi_Email;

@FindBy(how=How.XPATH,using="//input[@id='ctl00_ContentPlaceHolder2_txtcompanyURL']")

public static WebElement Edi_CompanyUrl;
	
//**********************************************************************
	public static boolean waitForPageLoad()
	{boolean status=true;
	
	try
	{
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ctl00_ContentPlaceHolder2_lblDisplay")));
		System.out.println("Employer - Registration Form is loaded sucessfuly");
		logEvent("pass", "Employer - Registration Form is loaded sucessfuly");
	}catch(Exception e)
	{status=false;
		System.out.println("Unable to locate Employer - Registration Form header on the page");
		logEvent("fail", "Unable to locate Employer - Registration Form header on the page");
	}
	return status;
		
	}
	
//==========================================================================
	
	public static boolean enterDetails_RegisterForm(String Testcasename)
	{
		boolean status=true;
		
		try
		{
			String companyName=getData(Testcasename,"Company","Testdata");
			Edi_CompanyName.sendKeys(companyName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println(e.getMessage());
			logEvent("fail", e.getMessage());
		}
		return status;
	}
	
	
	

}
