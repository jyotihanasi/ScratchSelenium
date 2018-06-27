package Scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configurations.SuperClass;

public class CreateEPG  extends SuperClass {
	
	@Test
	public void  EPGCreate(){
		
		try {
				
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
					Assert.fail("Application trying to select for profile creation does not exist, please Recheck config inputs");
				}
				
				//select profile
				try {
				WebElement ddl=driver.findElement(By.xpath("//select[@id='location-select']"));
				Select sct=new Select(ddl);			
				sct.selectByVisibleText("200");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='"+getkey("ProfileNameforEPG")+"']")).click();
				Reporter.log("EPG will be created in profile " + getkey("ProfileNameforEPG"));
				Thread.sleep(5000);
				}
				catch(Exception e){						
					Assert.fail("Profile trying to select for EPG  creation does not exist, please Recheck config inputs");
				}
				
				
				//select EPG tab		
				driver.findElement(By.linkText("EPG")).click();//a[contains(text(),'EPG')]"
				Thread.sleep(5000);
				//clicked on create EPG
				driver.findElement(By.xpath("//div//span[text()='Create EPG']")).click();
				Thread.sleep(5000);
				
				//Entering EPG value		
				//EPG Name
				driver.findElement(By.xpath("//input[@name='lifecycle']")).sendKeys(getkey("EPGname"));
				Thread.sleep(5000);				
				//workloadtype
				Actions act=new Actions(driver);
				act.click(driver.findElement(By.xpath("//span[text()='Please select a Workload Type']"))).perform();				
				Thread.sleep(5000);					
				driver.findElement(By.xpath("//a//div[text()='"+getkey("WorkLoadType") +"']")).click();
				
				//click on confirm
				driver.findElement(By.xpath("//div[contains (text(),'Confirm')]")).click();
				Thread.sleep(5000);
				try {
								
					if(driver.findElement(By.xpath("//input[@name='lifecycle']")).isDisplayed()) {
						Assert.fail("Could not Confirm EPG Either wrong input/missing attribute, please recheck the config inputs");
				}
				}
				catch (Exception e) {							
					Reporter.log("Sucessfully Confirmed  EPG inputs ");
				}
				
				//click on submit
				driver.findElement(By.xpath("//div[contains (text(),'Submit')]")).click();
				Thread.sleep(5000);
				
				try {
					if(driver.findElement(By.xpath("//div[text()='End Point Group Summary']")).isDisplayed()) {
						Assert.fail("Could not submit EPG, please recheck the config inputs");
				}
				}
				catch (Exception e) {			
					Reporter.log("Sucessfully submitted EPG");
				}
				
					
		
		} catch (Exception e) {				
			Assert.fail("Could not submit EPG, please recheck the config inputs");
		 
		}
	
	}

	
}
