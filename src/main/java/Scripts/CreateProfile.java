package Scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Configurations.PropertiesFile;
import Configurations.SuperClass;

public class CreateProfile extends SuperClass{
		
	@Test
	public void  SelfManagedProfile() throws InterruptedException{
				
		//Homepage		
		driver.findElement(By.xpath("html/body/div[1]/div/div/div/ci-navigation/div/div/div/div/a[2]/h5")).click();
		Reporter.log("Selected My application Option from Home page");
		Thread.sleep(5000);
		
		//select application
		try {
			//handle dropdown
			WebElement ddl=driver.findElement(By.xpath("//select[@id='location-select']"));
			Select sct=new Select(ddl);			
			sct.selectByVisibleText("200");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='"+getkey("ApplicationName")+"']")).click();
			Reporter.log("Selected a application to creare profile");
			Thread.sleep(5000);	
		
		}
		catch(Exception e){						
			Assert.fail("Application Selected for profile creation does not exist, please Recheck config inputs");
		}
	
		//Click create button		
		driver.findElement(By.xpath("//span[text()='Create Profile']")).click(); 
		Reporter.log("Clicked on  create profile button");
		Thread.sleep(5000);
		
		      //Enter Profilename
				driver.findElement(By.xpath(".//*[@id='displayName']")).sendKeys(getkey("ProfileName"));
				Thread.sleep(5000);				
						
		
				//Handle Dropdown menu
				Actions act=new Actions(driver);
				
				//Lifecycle
				try {
				act.click(driver.findElement(By.xpath("//span[text()='Please select a lifecycle']"))).perform();				
				Thread.sleep(5000);					
				driver.findElement(By.xpath("//a//div[text()='"+getkey("Lifecycle") +"']")).click();
				//driver.findElement(By.xpath("//a//div[text()='stage']")).click();
				}
				catch(Exception e){
						Assert.fail("Could not select Lifecycle feild, please Recheck config inputs");
				}
				
				//LocationMenu
				try {
				act.click(driver.findElement(By.xpath("//span[text()='Please select a location']"))).perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a//div[text()='San Jose, CA']")).click();				
				}
				catch(Exception e){
						Assert.fail("Could not select Loaction feild, please Recheck config inputs");
				}
				
				//go live date				
				driver.findElement(By.xpath(".//input[@id='goLiveDate']")).sendKeys(getkey("GoLiveDate"));	
				Thread.sleep(5000);
				
				
				//Click on submit
				try {
				driver.findElement(By.xpath("//div[contains (text(),'Submit')]")).click();				
				Thread.sleep(20000);				
				if (driver.findElement(By.xpath("//div//h1[text()='Create Application Profile']")).isDisplayed()){
					Assert.fail("Profile submission failed, please Recheck config inputs");
				}}
				catch(Exception e) {
					Reporter.log("Sucessfully submitted  Profile " + getkey("ProfileName"));
				}		
		
	}

}
