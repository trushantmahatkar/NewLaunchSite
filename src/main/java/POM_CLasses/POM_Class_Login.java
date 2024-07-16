package POM_CLasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.excel_Data_Fetch;

public class POM_Class_Login
{
	public WebDriver driver;
//	private Select s ;
	private Actions act;

	public POM_Class_Login(WebDriver driver)
			{
			this.driver =driver;
			PageFactory.initElements(driver,this);	
			}
	 @FindBy(xpath="//input[@data-cy='fromCity']")
	 private WebElement from_City;
	 public void send_From_City(int a,int b) throws IOException
	 {
		 from_City.sendKeys(excel_Data_Fetch.send_Character(a, b));
	 }
	
	 @FindBy(xpath="//input[@data-cy='toCity']")
	 private WebElement to_City;
	 public void send_To_City(int a,int b) throws IOException
	 {
		 from_City.sendKeys(excel_Data_Fetch.send_Character(a, b));
	 }
	 @FindBy(xpath="//p[@data-cy='departureDate']")
	 private WebElement request_OTP_Button;
	 public void click_Request_OTP_Button()
	 {
		 request_OTP_Button.click();
	 }
//	 @FindBy(xpath="//div[@class='DayPicker-Day']")
//	 private List<WebElement> day_select;
//	 public void click_From_Date()
//	 {
//		 day_select.get(1).click();
//	 }
//
//	 @FindBy(xpath="//div[@class='DayPicker-Day']")
//	 private List<WebElement> day_select;
//	 public void click_From_Date()
//	 {
//		 day_select.get(1).click();
//	 }
	 
	 
	
}
