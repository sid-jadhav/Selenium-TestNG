package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.createAccount;
import Pages.signIn;

public class CheckSignIn {
	//static Logger log= Logger.getLogger(CheckSignIn.class.getName());
	WebDriver driver;
	@Before
	public void init(){
		//log.info("Initializing the driver to fire fox");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Sid2\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	@After
	public void tearDown() throws InterruptedException{
		//log.info("Closing the browser");
		Thread.sleep(5000);
		driver.close();
	}
	
	@Test
	public void CheckSignInFunctionality(){
		//log.info("Checking the SignIn Page");
		signIn si=new signIn(driver);
		si.Enter_AlreadyRegistered_EmailAddress("SiddheshJadhav@gmail.com");
		si.Enter_AlreadyRegistered_Password("sid123");
		si.ClickOnSignIn();
	}
	//@Test
	public void CheckCreateAccountPage() throws InterruptedException
	{
		Actions a= new Actions(driver);
		signIn si=new signIn(driver);
		si.Enter_CreateAnAccount_EmailAddress("SiddheshJadhav@gmail.com");
		createAccount ca;
		ca=si.ClickOnCreateAnAccount();
		Thread.sleep(3000);
		ca.ClickOnRadioButton("Mr");
		ca.Enter_FirstName("Siddhesh");
		ca.Enter_LastName("Jadhav");
		ca.Enter_Password("sid123");
		ca.Select_Day(6);
		ca.Select_Month("June");
		ca.Select_Year("1994");
		ca.Enter_Address("Street 1", "Street 2");
		ca.Enter_City("Kolhapur");
		ca.Select_State("Iowa");
		ca.Enter_ZipCode("41605");
		ca.Select_Country("United States");
		ca.Enter_MobileNo("9834290591");
		ca.Enter_AddressAlise("jadhavwadi");
		ca.ClickOnRegisterLink();
	}
}
