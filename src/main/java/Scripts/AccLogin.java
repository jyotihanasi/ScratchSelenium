package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import Configurations.SuperClass;

public class AccLogin extends SuperClass{
	Logger logger = Logger.getLogger(AccLogin.class);
	
	@Test
	public void  LoginTest(){		
		//System.out.println("Login Test");
		logger.info("Login Test");
	}

}
	

