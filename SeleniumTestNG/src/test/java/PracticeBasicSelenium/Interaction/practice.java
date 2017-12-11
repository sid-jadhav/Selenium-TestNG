package PracticeBasicSelenium.Interaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice{
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Sid2\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.way2automation.com/demo.html");
		System.out.println(execute("return document.readyState"));
	}
	public static Object execute(String s){
		
		return ((JavascriptExecutor)driver).executeScript(s);
	}
	
}
