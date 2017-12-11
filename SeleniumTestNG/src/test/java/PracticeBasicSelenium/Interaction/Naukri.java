package PracticeBasicSelenium.Interaction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.naukri.LoginPage;

public class Naukri {
	WebDriver driver;
	By locationLater=By.xpath("//*[@id='block']");
	By locationSure=By.xpath("//*[@id='allow']");
	By login=By.xpath("//*[@class='topIcon jobs Login']");
	By emailId=By.xpath("//*[contains(@id,'ogin')][@name='email']");
	By pass=By.xpath("//*[@id='pLogin']");
	By loginButton=By.xpath("//*[text()='Login'][@class='blueBtn']");
	By loginFrame=By.xpath(".//*[@id='login-iframe']");
	
	//Naukri Home Page
	By myNaukriLogo=By.xpath("//*[text()='My Naukri']");
	By editProfile=By.xpath("//a[@title='Edit Profile']");
	
	//Edit profile page
	By saveButton=By.xpath("//b[contains(text(),'Save')]");
	By uploadNewResume=By.xpath("//a[text()='Upload New Resume']");
	By saveResume=By.xpath("//button[@class='w85bt fl'][@type='button']");
	
	//Robot class
	StringSelection resumePath= new StringSelection("C:\\Users\\LENOVO\\Desktop\\Resume\\Sid's Resume\\Siddhesh_Jadhav_CV.doc");
	
	//post resume upload
	By notifyBlock=By.xpath("//div[@id='confirmBox']");
	By confirmMessage=By.xpath("//span[@id='confirmMessage']");
	
	@BeforeClass
	public void init(){
		//log.info("Initializing the driver to fire fox");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\Sid2\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
	}
	@Test
	public void uploadResume() throws InterruptedException, AWTException{
		LoginPage lp=new LoginPage(driver);
		lp.handlePopupWindows();
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(login));
//		driver.switchTo().activeElement();
		lp.enterCredentials("sidd.m.jadhav@gmail.com","jayesh@12345");
		driver.findElement(loginButton).click();
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(myNaukriLogo)).perform();
		
		a.moveToElement(driver.findElement(editProfile)).click().perform();
		Thread.sleep(2000);
		Set<String> win=driver.getWindowHandles();
		String currentWin=driver.getWindowHandle();
		for(String s:win){
			System.out.println(s);
			if(!s.equals(currentWin)){
				driver.switchTo().window(s);
			}
		}
		driver.findElement(saveButton).click();
		Thread.sleep(2000);
		driver.findElement(uploadNewResume).click();
		Robot r=new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(resumePath, null);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(saveResume).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(notifyBlock)));
		Assert.assertEquals(driver.findElement(confirmMessage).getText(), "Your naukri profile has been updated with your uploaded resume");
	}
}
