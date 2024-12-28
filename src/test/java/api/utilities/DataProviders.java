package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="Data")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String apidata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from excel storing in two deminsional array here starting from 1 as eliminating first row of headers
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col as need not to eliminate reading data from col
			{
				apidata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0(Inorder to store data in proper order in array we are subtracting i  value with 1 to store it in zero position and not getting array index outof bound exception)
			}
		}
	return apidata;//returning two dimension array
				
	}
	
	
	@DataProvider(name="UserNameData")
	public String [] getUserNameData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		
				
		String userdata[]=new String[totalrows];
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from excel storing in two deminsional array here starting from 1 as eliminating first row of headers
		{		
			
				userdata[i-1]= xlutil.getCellData("Sheet1",i, 1);  //1,0(Inorder to store data in proper order in array we are subtracting i  value with 1 to store it in zero position and not getting array index outof bound exception)
			
		}
	return userdata;//returning two dimension array
				
	}
	
	
}
