package com.ScreenFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericMethods.GenericMethods;

public class HomePage extends GenericMethods{

	// ********************  Home Page Menu Links **********************
	
	@FindBy(how=How.CSS,using="#lnkRegistration")
	public static WebElement Register;
	
	@FindBy(how=How.CSS,using="#lblEmployerReg")
	public static WebElement Employer;
	
	
	// ********************  Methods Declaration **********************	
	public static boolean  register_Employer()
	{
		System.out.println("Registering as an Employer");
		boolean status =true;
		
		try
		{
			Register.click();
			Employer.click();
		}catch(Exception e)
		{
			status=false;
			System.out.println(e.getMessage());
		}
		return status;
	}
	

}
