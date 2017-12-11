package automation;

import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;

public class TestCaseElements {
	Properties runTimeProperties;
	
	public TestCaseElements(ITestContext ngContext){
		Map<String,String> info=ngContext.getCurrentXmlTest().getAllParameters();
		
		for(String ngKey: info.keySet()){
			runTimeProperties.put(ngKey, info.get(ngKey));
		}
	}
}
