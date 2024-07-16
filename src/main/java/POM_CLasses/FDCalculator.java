package POM_CLasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelUtils;
import bsh.Console;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String filepath = "D:\\Users\\trushantmahatkar\\Downloads\\FDCalculator.xlsx";
		// get row count for checking how many no of rows in a excel file
		int row = ExcelUtils.getRowCount(filepath,"Sheet1");
		System.out.println(row);
		// using for loop to take each row one by one
		for (int i=1; i<row; i++) 
		{
			// now take the data i.e cell for every row one by one
			String prin = ExcelUtils.getCellData(filepath,"Sheet1", i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String period1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String period2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
			String expectedValue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);

			// pass the data to web elements
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(prin);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			// select period from dd
			Select s = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			s.selectByVisibleText(period2);
			//select frequency from dropdown
			Select s1 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			s1.selectByVisibleText(frequency);
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]")).click();
			String actualValue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			Thread.sleep(3000);
			if (Double.parseDouble(expectedValue)==Double.parseDouble(actualValue))
			{
				System.out.println("Test Case is Passed");
				ExcelUtils.setCellData(filepath, "Sheet1",i,7,"Passed");
				ExcelUtils.greenColor(filepath, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test Case is Passed");
				ExcelUtils.setCellData(filepath, "Sheet1",i,7, "Failed");
				ExcelUtils.redColor(filepath, "Sheet1",i,7);
			}
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
		driver.quit();
	}
}

