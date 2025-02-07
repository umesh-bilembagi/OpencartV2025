package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider method1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking excel file from testData package
		
		ExcelUtility xlutil=new ExcelUtility(path); //Creating an object for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1); 
		
		String logindata[][]=new String[totalrows][totalcols]; //created 2 D array which can store 
		
		for(int i=1; i<=totalrows;i++) //1 //read the data from xl storing in 2D array
		{
			for(int j=0; j<totalcols; j++)  //0  i=row j=cols
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1, 0
			}
		}
		return logindata;  //returning 2D array
	}
	
	//DataProvider method2
	
	//DataProvider method3
	
	//DataProvider method4
}
