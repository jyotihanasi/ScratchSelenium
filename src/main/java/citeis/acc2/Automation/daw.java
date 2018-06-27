package citeis.acc2.Automation;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class daw {
	
	private static final Logger logger = Logger.getLogger(daw.class);
	
	
	@Test
	public void gmailLoginTest() throws InterruptedException, IOException {
		BasicConfigurator.configure();
		Reporter.log("Login to gmail");		
		System.out.println("jyotihanasi");
		WebDriver driver;
				
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jhanasi\\eclipse-workspace\\Automation\\chromedriver.exe");
		String localDir = System.getProperty("user.dir");
		System.out.println("path is" + localDir);
		String localDir2= localDir +"\\"+"chromedriver.exe";
		System.out.println(localDir2);
		System.setProperty("webdriver.chrome.driver", localDir2);
		
		driver=new ChromeDriver();
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.close();
		
	}

}
