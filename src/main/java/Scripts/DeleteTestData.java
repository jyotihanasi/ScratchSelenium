package Scripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configurations.SuperClass;

public class DeleteTestData extends SuperClass{
	
	
	@Test
	public void DeleteProfile() {				
				
				try {
					//Homepage	
					driver.findElement(By.xpath("html/body/div[1]/div/div/div/ci-navigation/div/div/div/div/a[2]/h5")).click();
					Reporter.log("Selected My application Option from Home page");
					Thread.sleep(5000);
					
					//select application		
					driver.findElement(By.xpath("//span[text()='"+getkey("ApplicationName")+"']")).click();
					Reporter.log("Selected a application to creare profile");
					Thread.sleep(5000);
				
					
					
					
					
					
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}		
				
		
	}

}
