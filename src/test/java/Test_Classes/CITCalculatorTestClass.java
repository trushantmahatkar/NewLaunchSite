package Test_Classes;

import java.io.IOException;

import org.testng.annotations.Test;

import POM_CLasses.CITCompoundInterestCal;
import POM_CLasses.citCalciPomClass;
import Utility.ExcelUtils;

public class CITCalculatorTestClass extends CITCompoundInterestCal
{
	@Test
	public void checkResultsValue() throws InterruptedException, IOException
	{
		citCalciPomClass cit= new citCalciPomClass(driver);
		cit.clearForm();
		Thread.sleep(1000);
		String excel= "D:\\Users\\trushantmahatkar\\Downloads\\FDCalculator.xlsx";
		
		int noOfRows =ExcelUtils.getRowCount(excel,"Sheet2");
		//for getting the rows data we need to fetch the data one by one
		for(int i=1; i<(noOfRows-1);i++)
		{
			String deposit =ExcelUtils.getCellData(excel,"Sheet2",i, 0);
			String lengthPeriod =ExcelUtils.getCellData(excel,"Sheet2",i, 1);
			String rateOfInterest =ExcelUtils.getCellData(excel,"Sheet2",i, 2);
			String compounding =ExcelUtils.getCellData(excel,"Sheet2",i, 3);
			String expectedTotalValue =ExcelUtils.getCellData(excel,"Sheet2",i, 4);
		
			cit.sendDepositAmount(deposit);
			Thread.sleep(1000);
			cit.sendLengthInMonths(lengthPeriod);
			Thread.sleep(1000);
			cit.sendRateOfInterest(rateOfInterest);
			Thread.sleep(1000);
			cit.clickDropDown();
			Thread.sleep(2000);
			cit.clickDDValue(compounding);
			Thread.sleep(1000);
			cit.clickLetsRunButton();
			
			if(cit.getActualValue().equals(expectedTotalValue))
			{
				System.out.println("Test Case Passed");
				System.out.println("Site Value ===>"+ cit.getActualValue());
				System.out.println("Actual Value ====>"+expectedTotalValue);
				ExcelUtils.setCellData(excel,"Sheet2",i,6,"Passed");
			}
			else
			{
				System.out.println("Test Case Failed");
				System.out.println("Site Value ===>"+ cit.getActualValue());
				System.out.println("Actual Value ====>"+expectedTotalValue);
				ExcelUtils.setCellData(excel,"Sheet2",i,6,"Failed");
			}
			cit.clearForm();
		}
		
				
	}
	
}
