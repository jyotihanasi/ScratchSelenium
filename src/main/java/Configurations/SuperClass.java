package Configurations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import org.apache.log4j.Logger;



//includes login and logout 
public class SuperClass extends PropertiesFile {	
	
	public WebDriver driver;
	//Logger logger;
	Logger logger = Logger.getLogger(SuperClass.class);
	
	
	
	@BeforeMethod
	public void BeforeLogin() throws InterruptedException {
		//initialaize chromedriver
		Reporter.log("Initialaized chromedriver");
		String localDir = System.getProperty("user.dir");
		System.out.println("path is" + localDir);
		String localDir2= localDir +"\\"+"chromedriver.exe";
		System.out.println(localDir2);
		System.setProperty("webdriver.chrome.driver", localDir2);		
		driver=new ChromeDriver();
		
	try {
		driver.get(getkey("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='userInput']")).sendKeys(getkey("Username"));
		driver.findElement(By.xpath(".//*[@id='login-button']")).click();		
		driver.findElement(By.xpath(".//*[@id='passwordInput']")).sendKeys(getkey("Password"));		
		driver.findElement(By.xpath(".//*[@id='login-button']")).click();
		Thread.sleep(10000);		
		String text= driver.findElement(By.xpath("//div//h1[text()='ACC - Application Centric Cloud']")).getText();
		System.out.println(text);
		String text2="ACC - Application Centric Cloud";
				
				if(text.equals(text2)) {					
					Reporter.log("Login sucessfull");
				}
				else {
					Reporter.log("Login Failed");
				}
	}
	catch(Exception e) {
		Assert.fail("Could not load the Acc server , please recheck the URL");
	}
	}
	
	@AfterMethod
	public void AfterLogin() {
		driver.close();
	}

}
