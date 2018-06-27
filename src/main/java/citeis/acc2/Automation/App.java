package citeis.acc2.Automation;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class App 
{
    public static void main( String[] args )
    {
    	// Create object of TestNG Class
    			TestNG runner=new TestNG();
    			// Create a list of String 
    			List<String> suitefiles=new ArrayList<String>();
    			
    	//=======================================================================================================
    			//String localDir = System.getProperty("user.dir");
    			//System.out.println("path is" + localDir);
    			suitefiles.add("testng.xml");	
    			
    	       //suitefiles.add("C:\\Users\\jhanasi\\eclipse-workspace\\Automation\\testng.xml");
    			
    	//=======================================================================================================		
    			// now set xml file for execution
    			runner.setTestSuites(suitefiles);
    			// finally execute the runner using run method
    			runner.run();

    		}
    }

