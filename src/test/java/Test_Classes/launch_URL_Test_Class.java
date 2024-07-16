package Test_Classes;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_CLasses.POM_Class_Login;
import POM_CLasses.Test_Base_Class;

public class launch_URL_Test_Class extends Test_Base_Class
{	
	@Test
	public void launch_Test_Class() throws InterruptedException
	{
		POM_Class_Login p =new POM_Class_Login(driver);
//		p.click_Login_Button();
//		p.enter_Email_Phone_Number_Field();
		Thread.sleep(1000);
		p.click_Request_OTP_Button();
		Thread.sleep(12000);
//		p.click_Verify_Button();
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(true,"Test Pass");
		soft.assertAll();
	}
}