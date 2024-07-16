package Test_Classes;

import java.io.IOException;

import org.testng.annotations.Test;

import POM_CLasses.Test_Base_Class;
import POM_CLasses.brokenLinkPOMClass;

public class BrokenLinkandUnBrokenLinkCountTestClass extends Test_Base_Class
{
	@Test
	public void CountBrokenAnUnbrokenLink() throws IOException
	{
		brokenLinkPOMClass bl =new brokenLinkPOMClass(driver);
		bl.linkMethod();
	}
}
