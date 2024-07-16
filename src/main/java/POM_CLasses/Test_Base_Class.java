package POM_CLasses;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test_Base_Class 
{	
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver","D:\\Users\\trushantmahatkar\\Downloads\\chrome\\chromedriver.exe");
		 driver = new ChromeDriver();
		System.out.println("Browser is Opened");
		driver.manage().window().maximize();
		System.out.println("Browser is Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		
	}

}
