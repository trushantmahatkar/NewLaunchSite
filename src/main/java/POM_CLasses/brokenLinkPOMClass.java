package POM_CLasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class brokenLinkPOMClass 
{
	public WebDriver driver;
	public brokenLinkPOMClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	int brokenLinkCount;
	int unbrokenLinkCount;
	@FindBy(tagName="a")
	List<WebElement> links;
	public void linkMethod() throws IOException
	{
		
		System.out.println("All Links ===>"+links.size());
		for(WebElement link:links)
		{
			String hrefValue=link.getAttribute("href");
			if (hrefValue==null||hrefValue.isEmpty())
					{
						System.out.println("Link is invalid");
						continue;
					}
			try
			{			
			URL linkURL =new URL(hrefValue);
			HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
			conn.connect();
			conn.setConnectTimeout(1000);
			if(conn.getResponseCode()>=400)
			{
				System.out.println("Broken links ===>"+linkURL);
				brokenLinkCount++;
			}
			else
			{
				System.out.println("Proper Links ====>"+linkURL);
				unbrokenLinkCount++;
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}
		System.out.println("Broken Link Count ===>" +brokenLinkCount );
		System.out.println("Broken Link Count ===>" +unbrokenLinkCount );
	}
	
	
}
