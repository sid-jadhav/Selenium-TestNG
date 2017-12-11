package PracticeBasicSelenium.Interaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.TestCase;

public class Assignment extends TestCase {
	By boxPath=By.xpath("//*[@id='wrapper']/div[2]/div[2]/div/ul/li");
	By boxWidget=By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li");
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
	public void countTotalNoOfBoxes() throws IOException{
		ArrayList listOfBoxes= (ArrayList) driver.findElements(boxPath);
		System.out.println("Total number of boxes in the home page are: "+listOfBoxes.size());
		TakesScreenshot ss=(TakesScreenshot) driver;
		File f=ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./ScreenShots/ss1.png"));
		Assert.assertEquals(17,listOfBoxes.size());
	}
	@Test
	public void totalNoOfBoxesUnderWidget(){
		ArrayList BoxesWidget= (ArrayList) driver.findElements(boxWidget);
		System.out.println("Total number of boxes under widget tab: "+BoxesWidget.size());
		Assert.assertEquals(7,BoxesWidget.size());

	}
	
}
