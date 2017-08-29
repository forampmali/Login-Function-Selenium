package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithExcel
{
	WebDriver driver;
	
		@Test(dataProvider="logindata")
		public void loginfunction(String username,String password) throws InterruptedException
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
			//System.out.println(driver.getTitle());
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
			ExcelData config =new ExcelData("C:\\Users\\prashant\\workspace\\LoginFunctionality\\TestData\\inputdata.xlsx");
			int rows=config.getRawCount(0);
			
			Object[][] data= new Object[rows][2];
			
			for(int i=0; i<rows; i++)
			{
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 1);	
			}
			
			return data;
		}	
}
