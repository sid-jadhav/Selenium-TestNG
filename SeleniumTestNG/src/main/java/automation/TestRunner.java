package automation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.ITestContext;

import Pages.Test2;
import automation.excel.ExcelHelper;

public class TestRunner {
	static ITestContext ngContext;
	static List<Object> executeTC=new ArrayList<>();
	public TestRunner(ITestContext ngContext){
		this.ngContext=ngContext;
		System.out.println(this.ngContext.getCurrentXmlTest().getParameter("SKIPTEST"));
		System.out.println(this.ngContext.getCurrentXmlTest().getParameter("testData.fileName"));
		System.out.println(this.ngContext.getCurrentXmlTest().getParameter("testData.sheetName"));
	}
	/* 	Fully qualified class(FQC) name= package name + class name
	 * 	This method takes the FQC name as an String and instantiate a new instance of  
	 *  that class and adds it to the list of classes that should be executed  
	 */
//	public static void addTC() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
//		Class c=Class.forName("Pages.Test2");
//		Test2 t= (Test2) c.getConstructor(String.class,String.class,int.class).newInstance("s","sk",1);
//		t.show();
//	}
	public static TestCase getInstanceOfTC(String tcName){
		Class<TestCase> tc1;
		try {
			tc1 = (Class<TestCase>) Class.forName(tcName);
			//TestCaseElements tce=new TestCaseElements(ngContext);
			TestCase tc;
			tc=tc1.getConstructor().newInstance();
			//tc = tc1.getConstructor(TestCaseElements.class).newInstance(tce);
			return tc;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static Object[] addTC(){
		ExcelHelper eh=new ExcelHelper();
		XSSFSheet mySheet=eh.getSheet(ngContext.getCurrentXmlTest().getParameter("testData.fileName"),ngContext.getCurrentXmlTest().getParameter("testData.sheetName"));
		int rowItr=1;
		XSSFRow row=mySheet.getRow(rowItr);
		while(row!=null){
			//System.out.println(eh.getCellData(mySheet, rowItr, eh.TestCase_ColumnNo));
			if(eh.getCellData(mySheet, rowItr, eh.TestCase_Execution).equalsIgnoreCase("y")||eh.getCellData(mySheet, rowItr, eh.TestCase_Execution).equalsIgnoreCase("yes")){
				executeTC.add(getInstanceOfTC(eh.getCellData(mySheet, rowItr, eh.TestCase_ColumnNo)));
				System.out.println(eh.getCellData(mySheet, rowItr, eh.TestCase_ColumnNo));
			}
			rowItr++;
			row=mySheet.getRow(rowItr);
		}
		return executeTC.toArray();
	}
	
}
