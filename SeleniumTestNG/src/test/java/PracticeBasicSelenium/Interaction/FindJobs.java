package PracticeBasicSelenium.Interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.naukri.LoginPage;
import Pages.naukri.NaukriProfileHome;

public class FindJobs {
	WebDriver driver;
	@BeforeClass
	public void init(){
		//log.info("Initializing the driver to fire fox");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\Sid2\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void findTestingJobs() throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.handlePopupWindows();
		Thread.sleep(2000);
//		driver.switchTo().activeElement();
		lp.enterCredentials("sidd.m.jadhav@gmail.com","jayesh@12345");
		NaukriProfileHome np=new NaukriProfileHome(driver);
		np.clickOnJobRecommendation();
	}
}
