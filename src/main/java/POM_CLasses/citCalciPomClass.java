package POM_CLasses;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class citCalciPomClass 
{
		public WebDriver driver;
		public Select s;
		public citCalciPomClass(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="//input[@id='mat-input-0']")
		private WebElement totalDeposit;
		public void sendDepositAmount(String dep)
		{
			totalDeposit.sendKeys(dep);
		}
		@FindBy(xpath="//input[@id='mat-input-1']")
		private WebElement lengthMonth;
		public void sendLengthInMonths(String lm)
		{
			lengthMonth.sendKeys(lm);
		}
		@FindBy(xpath="//input[@id='mat-input-2']")
		private WebElement rateOfInt;
		public void sendRateOfInterest(String roi)
		{
			rateOfInt.sendKeys(roi);
		}
		@FindBy(xpath="//div[contains(@class,'mat-select-value')]")
		private WebElement dropDownClick;
		public void clickDropDown()
		{
			dropDownClick.click();
		}
		@FindBy(xpath="//mat-option[@role='option']//span")
		List<WebElement> ddValue ;
		public void clickDDValue(String excelVal)
		{		
			for(WebElement ddValues:ddValue)
			{
			String matchValue=ddValues.getText();
			if(excelVal.equals(matchValue))
			{
				ddValues.click();
				break;
			}
			}
		}
		@FindBy(xpath="//button[@id='CIT-chart-submit']")
		private WebElement runButton;
		public void clickLetsRunButton()
		{
			runButton.click();
		}
		public void clearForm()
		{
			totalDeposit.clear();
			lengthMonth.clear();
			rateOfInt.clear();
			
		}
		@FindBy(xpath="//span[@id='displayTotalValue']")
		private WebElement actualVal;
		public String getActualValue()
		{
			return actualVal.getText();
		}
}
