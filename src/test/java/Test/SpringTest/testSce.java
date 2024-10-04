package Test.SpringTest;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class testSce extends BaseClass {
	
	BaseClass base= new BaseClass();
	
	@Test(groups = "Positive Scenarios",
			dataProvider = "dataSet2")
	public void positiveAllFields(String firstName, String lastName, String emailId, String comment) throws Exception
	{
		
		base.launchChrome();
		base.init(firstName, lastName, emailId, comment);
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().contains("https://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html"))
		{
		base.waitTillSucessScreen();
		Assert.assertEquals("Thank You for your Message!",
				driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']"))
				.getText());
		}
		
		else
		{
			Assert.assertTrue("Email Negative Scenario",base.errorScreen());
		}
		
		base.closingDriver();
		
	}
	
	
	@DataProvider(name = "dataSet1")
	public Object[][] createDataX() {
	    return new Object[][] { { "Nitish", "Goel", "nitish@@gmail.com","comments" }, { "Name", "Last", "@.com","comments" },
	    	{ "NITISH", "XYL", "#$%^&@gmail.com","comments" },
	    	{ "TEST USER 3", "USER LAST NAME", "nitish&^@gmail.com","comments" },
	    	{ "TEST USER 4", "Last NAME U4", "nitish**gmail.com","comments" } ,
	    	{ "TEST USER 5", "LAST NAME U5", ".com","comments" } 
	    	};
	}
	
	@DataProvider(name = "dataSet2")
	public Object[][] createDataX2() {
	    return new Object[][] { { "Nitish", "Goel", "nitish@gmail.com","comments" }, { "Name", "Last", "@.com","comments" },
	    	{ "NITISH", "XYL", "nitish_123@yahoo.com","comments" },
	    	{ "TEST USER 3", "USER LAST NAME", "test@spring.com","comments" },
	    	{ "TEST USER 4", "Last NAME U4", "usernew@gmail.com","comments" } ,
	    	{ "TEST USER 5", "LAST NAME U5", ".com","comments" } 
	    	};
	}


}
