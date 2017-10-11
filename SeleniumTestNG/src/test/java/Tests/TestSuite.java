package Tests;

import java.util.ArrayList;

import org.testng.ITestContext;
import org.testng.annotations.Factory;

import automation.TestRunner;

public class TestSuite {
	/*	Marks a method as a factory that returns objects
	 *  that will be used by TestNG as Test classes. 
	 *  The method must return Object[].
	 */
	@Factory
	public Object[] testSuite(ITestContext ngContext){
		TestRunner tr=new TestRunner(ngContext);
		return null;
		
		
	}
	
}
