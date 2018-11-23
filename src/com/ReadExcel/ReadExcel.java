package com.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static XSSFWorkbook wrkbook;
	
	public static void loadExcelFile() 
	{
		try
		{
			File f=new File(System.getProperty("user.dir")+"\\TestData\\Testadata.xlsx");
			
			
			FileInputStream fis=new FileInputStream(f);
			
			wrkbook=new XSSFWorkbook(fis);
				
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
				
	}
	
	
	public static int getRowCount(String sheetname)
	{
		int rowcount=0;
		
		return rowcount=wrkbook.getSheet(sheetname).getLastRowNum();
		
	}
	
	public static int getColumnCount(String sheetname)
	{
		int colcount=0;
		
		return colcount=wrkbook.getSheet(sheetname).getRow(getRowCount(sheetname)).getLastCellNum();
		
	}
	
	public static int searchTestcase(String Testcasename,String sheetname)
	{
		
		int rowfound=0;
		
		int rowcount=getRowCount(sheetname);
		
		
		for(int i=1;i<=rowcount-1;i++)
		{
			
			String crnttestcase=wrkbook.getSheet(sheetname).getRow(i).getCell(0).getStringCellValue();
			
			if(crnttestcase.equals(Testcasename))
			{
				rowfound=i;
				break;
			}
			
			
		}
		
		return rowfound;
		
		
	}
	
	public static int searchColumn(String columnname,String sheetname)
	{
		
		int colfound=0;
		
		int colcount=getColumnCount(sheetname);
		
		
		for(int i=1;i<=colcount-1;i++)
		{
			
			String crntcolname=wrkbook.getSheet(sheetname).getRow(0).getCell(i).getStringCellValue();
			
			if(crntcolname.equals(columnname))
			{
				colfound=i;
				break;
			}
			
			
		}
		
		return colfound;
		
		
	}
	
	public static String getData(String testcase,String columnname,String sheetname)
	{
		String testdata="";
		int testcaserow=searchTestcase(testcase,sheetname);
		
		int colpos=searchColumn(columnname,sheetname);
				
		if(!(testcaserow==0 && colpos==0))
		{
			switch(wrkbook.getSheet(sheetname).getRow(testcaserow).getCell(colpos).getCellTypeEnum())
			{
			
			case STRING:
				testdata=wrkbook.getSheet(sheetname).getRow(testcaserow).getCell(colpos).getStringCellValue();
				break;
			
			case NUMERIC:
				int numdata=(int)wrkbook.getSheet(sheetname).getRow(testcaserow).getCell(colpos).getNumericCellValue();
				testdata=Integer.toString(numdata);
				
				break;
			
			}
		}
		
		
		return testdata;
	}

}
