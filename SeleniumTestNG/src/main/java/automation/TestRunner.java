package automation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;

import Pages.Test2;

public class TestRunner {
	ITestContext ng;
	static List<Object> executeTC=new ArrayList<>();
	public TestRunner(ITestContext ngContext){
		this.ng=ngContext;
		System.out.println(ng.getCurrentXmlTest().getParameter("SKIPTEST"));
		System.out.println(ng.getCurrentXmlTest().getParameter("testData.fileName"));
		System.out.println(ng.getCurrentXmlTest().getParameter("testData.sheetName"));
	}
	/* 	Fully qualified class(FQC) name= package name + class name
	 * 	This method takes the FQC name as an String and instantiate a new instance of  
	 *  that class and adds it to the list of classes that should be executed  
	 */
	public static void addTC() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class c=Class.forName("Pages.Test2");
		Test2 t= (Test2) c.getConstructor(String.class,String.class,int.class).newInstance("s","sk",1);
		t.show();
	}
	public static TestCase getInstanceOfTC(String tcName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<TestCase> tc1 = (Class<TestCase>) Class.forName(tcName);
		TestCaseElements tce=new TestCaseElements();
		TestCase tc=tc1.getConstructor(TestCaseElements.class).newInstance(tce);
		return tc;
	}
	public Object[] addTC(String tcName){
		try {
			executeTC.add(getInstanceOfTC(tcName));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return executeTC.toArray();
	}
	public static void main(String[] args){
		try {
			addTC();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
