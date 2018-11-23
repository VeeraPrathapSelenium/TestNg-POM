package com.ReportGeneration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.GenericMethods.GenericMethods;
import com.ReadExcel.ReadExcel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReports_Generation extends ReadExcel{
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public static void intializeReport(String Testcase)
	{
		
		extent=new ExtentReports(createResultFolder()+Testcase+".html");
		extent.addSystemInfo("Sprint","Sprint 1")
		.addSystemInfo("Environment","QA");
			
	}
	
	public static void startTest(String Testcase) {
		test=extent.startTest(Testcase);
	}
	
	public static void logEvent(String status,String description)
	{
		switch (status.toLowerCase()) {
		case "pass":
			test.log(LogStatus.PASS, description+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "fail":
		test.log(LogStatus.FAIL, description);
		case "warning":
			test.log(LogStatus.WARNING, description+test.addBase64ScreenShot(getScreenShot()));
		break;
		case "error":
			test.log(LogStatus.ERROR, description+test.addBase64ScreenShot(getScreenShot()));
		break;
		default:
			break;
		}
	}
	
	public static void endReport()
	{
		extent.flush();
		extent.endTest(test);
		extent.close();
	}
	
	
	public static String getScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot) GenericMethods.driver;
		
		String screenshot=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenshot;
		
	}
	
	
	
	
	
	
	
	public static String createResultFolder()	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YY");
		
		String path="";
		
		File f=new File(System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\");
		
		
		if(!f.exists())
		{
			
			f.mkdirs();
			path=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\";
		}
		else
		{
			path=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\";
		}
		
		return path;
	}

	

}
