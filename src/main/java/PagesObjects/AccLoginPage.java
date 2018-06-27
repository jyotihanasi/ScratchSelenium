package PagesObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AccLoginPage {
	
	WebDriver driver;
	
	public AccLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
       }
	
	@FindBy(xpath = ".//*[@id='userInput']")
	 public WebElement username;	

	
    public void login() {
    	username.sendKeys("---");
	
  }
	
	
}
