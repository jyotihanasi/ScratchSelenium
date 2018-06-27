package Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {	
	
	//=============================
	Properties prop=new Properties();
	FileInputStream input=null;
	
	// default constructor,this will load the config.properties file with all keys
	public  PropertiesFile() 
	{
		try {			
			String congfigPath = System.getProperty("user.dir");
			System.out.println(congfigPath);
			String congfigPath2=(congfigPath+"\\"+ "config.properties");
			System.out.println(congfigPath2);
			input = new FileInputStream(congfigPath2);			
			prop.load(input);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}		
	
	//this will define each key and return the value
	public String getkey(String key){		
		return prop.getProperty(key);
	}
	
}
	
	/*
	//define each key 
		public String getUserName() {		
			return prop.getProperty("Username");		
		}	
		public String getPassword() {		
			return prop.getProperty("Password");
		}	
		public String getUrl() {		
			return prop.getProperty("Url");
		}*/
	


 	 
