package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		String path = "D:\\Users\\Pavankalyanhv\\HybridFramework\\testData\\loginTestData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalColums = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalColums];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalColums;j++) {
				loginData[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

}
