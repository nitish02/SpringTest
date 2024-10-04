package Test.SpringTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass
{
	static WebDriver driver;
	public BaseClass() 
	{
		//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		
	}
	
	public void launchChrome()
	{
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void init(String firstName, String lastName, String emailId, String comments )
	{
		
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.name("email")).sendKeys(emailId);
		driver.findElement(By.name("message")).sendKeys(comments);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void waitTillSucessScreen()
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank You for your Message!']")));
		
	}
	
	public boolean errorScreen()
	{
	//	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("br")));
		
		String errorMessage=driver.findElement(By.tagName("body")).getAttribute("innerHTML");
		
		if(errorMessage.contains("Invalid email address"))
		{
			System.out.println("INVALID EMAIL ADDRESS");
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void closingDriver()
	{
		driver.close();
	}
	

	


}
