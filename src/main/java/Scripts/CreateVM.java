package Scripts;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configurations.SuperClass;

public class CreateVM extends SuperClass{
	
	@Test
	public void  VMCreate(){
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
		driver.findElement(By.xpath("//a[text()='"+getkey("ProfileNameforVM")+"']")).click();
		Reporter.log("EPG will be created in profile " + getkey("ProfileNameforVM"));
		Thread.sleep(5000);
		}
		catch(Exception e){						
			Assert.fail("Profile trying to select for EPG  creation does not exist, please Recheck config inputs");
		}
			
			//select VM tab		
			driver.findElement(By.linkText("Virtual Machine")).click();
			Thread.sleep(5000);
			
			//clicked on create VM
			driver.findElement(By.xpath("//div//span[text()='Create Virtual Machine']")).click();
			Thread.sleep(5000);			
			try {	
			if(driver.findElement(By.xpath("//div[text()='You need an EPG to create a VM. Please create one before creating a VM.']")).isDisplayed()) {
				  Assert.fail("You need an EPG to create a VM. Please create one before creating a VM.");
			}			
			/*else if(driver.findElement(By.xpath("//div[text()='You must create a funding source prior to ordering resources.']")).isDisplayed())
				 {
				
			}*/
			}
			catch(Exception e) {
				Reporter.log("Vm will be created under"+ getkey("ProfileNameforVM"));
			}
			
			//select EPG
			Actions act=new Actions(driver);			
			act.click(driver.findElement(By.xpath("//span[text()='Please select an EPG']"))).perform();				
			Thread.sleep(1000);					
			driver.findElement(By.xpath("//a//div[contains(text(),'"+getkey("VMEPGname") +"')]")).click();//div[contains (text(),'Submit')]
			Thread.sleep(1000);
			
			//OS type			
			System.out.println(getkey("OSType"));
			
			if(getkey("OSType").equals("Linux")) {
				Reporter.log("OSType is Linux");
			}
			else {
				driver.findElement(By.xpath("//div[text()='"+getkey("OSType")+"']")).click();
				Reporter.log("OSType is Windows");
				Thread.sleep(2000);
			}
			
			//VM name
			driver.findElement(By.xpath("//input[@name='prefix']")).sendKeys(getkey("VMName"));
			Thread.sleep(2000);				
			
			//No. of VM 
			driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");
			Thread.sleep(2000);			
			
			//click on add button			
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			Thread.sleep(2000);
						
			//click on add Proceed			
			driver.findElement(By.xpath("//div[text()='Proceed']")).click();
			Thread.sleep(5000);
			
			//Verify unique VM name 
			try {
			if(driver.findElement(By.xpath("//div//button[text()='Close']")).isDisplayed()) {
				Assert.fail("VM name  already exist and will not be added:Please provide unique VM name");				
			}
			}
			catch(Exception e) {
				Reporter.log("Vm name is validated.");
				
			}			
			
			
			//select OS version
			Actions act2=new Actions(driver);			
			act2.click(driver.findElement(By.xpath("//span[text()='Please select an OS Image']"))).perform();				
			Thread.sleep(5000);
			try {
				if(driver.findElement(By.xpath("//a//div[contains(text(),'"+getkey("OSversion") +"')]")).isDisplayed()) {
			driver.findElement(By.xpath("//a//div[contains(text(),'"+getkey("OSversion") +"')]")).click();
			}
			}
			catch(Exception e){
				Assert.fail("OS Template not avialble: Please check the config value ");
			}
						
			
			//security tab & password	
			driver.findElement(By.xpath("//a//span[contains(text(),'Security')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='rootPassword']")).sendKeys("Cisco@123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Cisco@123");
			Thread.sleep(2000);
			
			
			//click on confirm
			driver.findElement(By.xpath("//div[contains (text(),'Confirm')]")).click();
			Thread.sleep(5000);
			try {							
				if(driver.findElement(By.xpath("//a//span[contains(text(),'Security')]")).isDisplayed()) {
					Assert.fail("Could not Confirm VM Either wrong input/missing attribute, please recheck the config inputs");
			}
			}
			catch (Exception e) {							
				Reporter.log("Sucessfully Confirmed  VM inputs ");
			}
			
			
			//click on submit
			driver.findElement(By.xpath("//div[contains (text(),'Submit')]")).click();
			Thread.sleep(5000);
			
			try {
				if(driver.findElement(By.xpath("//div[text()='VM Order Summary']")).isDisplayed()) {
					Assert.fail("Could not submit VM, please recheck the config inputs");
			}
			}
			catch (Exception e) {			
				Reporter.log("Sucessfully submitted VM");
			}
			
			
			
			
			
	}
	catch(Exception e) {
		Assert.fail("Could not submit VM due to wrong config input value, Please recheck inputs");
	}

}
}
