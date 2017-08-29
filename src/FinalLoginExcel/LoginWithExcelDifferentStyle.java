package FinalLoginExcel;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithExcelDifferentStyle
{
	WebDriver driver;
	
		@Test(dataProvider="logindata")
		public void loginfunction1(String username,String password) throws InterruptedException
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
			Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login. Invalid Credentails");
			System.out.println("Page Title verified. User is able to Login Successfully");
		
		}
		@AfterMethod
		public void closebrowser()
		{
			driver.quit();

		}
		
		@DataProvider(name="logindata")

		public Object [][] passData()
		{
			ExcelDataconfig config =new ExcelDataconfig("C:\\Users\\prashant\\workspace\\LoginFunctionality\\TestData\\inputdata.xlsx");
			int rows=config.getRawCount(0);
			
			//For Counting Column 
			int cols=config.getColCount(0);
			
			// New Code import by foram mali
			Object[][] data= new Object[rows][cols];
			for(int i=0; i< rows; i++)
			{
				for(int j=0; j<cols; j++)
				{
					data[i][j] =config.getData(0, i, j);
					System.out.println("Test data from excel is "+data);
				}
			}	
			return data;
		}	
}
