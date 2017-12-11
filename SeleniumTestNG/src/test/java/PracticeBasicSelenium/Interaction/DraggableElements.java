package PracticeBasicSelenium.Interaction;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraggableElements {
	By interaction= By.xpath("//*[@id='toggleNav']/li[2]/a");
	By draggable = By.xpath("//*[@id='toggleNav']/li[2]/ul/li[1]/a");
	By signIn = By.xpath("//*[@id='load_form']/div/div[1]/p/a[@href='#login']");
	By userName= By.xpath("//*[@id='load_form']/fieldset[1]/input[@name='username']");
	By password= By.xpath("//*[@id='load_form']/fieldset[2]/input[@name='password']");
	By submit= By.xpath("//*[@id='load_form']/div/div[2]/input");
	By dragMe= By.xpath("//*[@id='draggable']");
	By draggableOption= By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]");
	By draggableLink =By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a");
	By iframe=By.xpath("//*[@src='draggable/default.html']");
	By iframe2=By.xpath("//*[@src='draggable/default2.html']");
	By ConstrainMovement= By.xpath("//a[@href='#example-1-tab-2']");
	By dragVertically=By.xpath("//p[contains(text(),'vertically')]");
	WebDriver driver;
	@BeforeClass
	public void init(){
		//log.info("Initializing the driver to fire fox");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Sid2\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
	}
	@Test
	public void DragDraggableElement() throws InterruptedException{
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(interaction)).perform();
		driver.findElement(draggable).click();
		Thread.sleep(2000);
		Set<String> s=driver.getWindowHandles();
		for(String str:s){
			driver.switchTo().window(str).getCurrentUrl().equals("http://way2automation.com/way2auto_jquery/index.php");
		}
		Thread.sleep(4000);
		driver.findElement(signIn).click();
		driver.findElement(userName).sendKeys("sid-jadhav");
		driver.findElement(password).sendKeys("jayesh@12345");
		ArrayList<WebElement> l=(ArrayList) driver.findElements(submit);
		l.get(1).click();
		Thread.sleep(2000);
		driver.get("http://way2automation.com/way2auto_jquery/draggable.php");
		driver.switchTo().frame(driver.findElement(iframe));
		Point p=driver.findElement(dragMe).getLocation();
		System.out.println("x co-ordinates : "+p.x+" y co-ordinates :"+p.y);
		a.dragAndDropBy(driver.findElement(dragMe), 200, 200).perform();
		p=driver.findElement(dragMe).getLocation();
		System.out.println("x co-ordinates : "+p.x+" y co-ordinates :"+p.y);
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		driver.findElement(ConstrainMovement).click();
		driver.switchTo().frame(driver.findElement(iframe2));
		p=driver.findElement(dragVertically).getLocation();
		System.out.println("x co-ordinates : "+p.x+" y co-ordinates :"+p.y);
		a.dragAndDropBy(driver.findElement(dragVertically), 0, 200).perform();
		p=driver.findElement(dragVertically).getLocation();
		System.out.println("x co-ordinates : "+p.x+" y co-ordinates :"+p.y);
	}
	
}
