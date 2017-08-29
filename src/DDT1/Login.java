package DDT1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	
		@Test(dataProvider="logindata")
		public void loginfunction(String username,String password) throws Exception
		{
			System.setProperty("webdriver.chrome.driver", "C://Users/prashant/Desktop/Razorfish Test/chromedriver_win32/chromedriver.exe");
			 driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://demosite.center/wordpress/wp-login.php");
		
			driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys(username);
			driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
			
			driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login. Invalid Credentails");
			System.out.println("Page Title verified. User is able to Login Successfully");
		
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();

		}
		
		@DataProvider(name="logindata")
		public Object [][] passData()
		{
			Object[][] data= new Object[3][2];
			data [0][0]="admin1";
			data [0][1]="demo1";
			
			data [1][0]="admin";
			data [1][1]="demo123";
			
			data [2][0]="admin2";
			data [2][1]="demo1234";
			
			return data;
			
		}
		
		
	

}
