package automation;

import org.testng.ITestContext;

public class TestRunner {
	ITestContext ng;
	public TestRunner(ITestContext ngContext){
		this.ng=ngContext;
		System.out.println(ng.getCurrentXmlTest().getParameter("SKIPTEST"));
		System.out.println(ng.getCurrentXmlTest().getParameter("testData.fileName"));;
		System.out.println(ng.getCurrentXmlTest().getParameter("testData.sheetName"));;
	}
	
}
