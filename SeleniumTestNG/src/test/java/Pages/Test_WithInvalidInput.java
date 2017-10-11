package Pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestBase.testBase;

public class Test_WithInvalidInput extends testBase{
	@BeforeTest
	public void setUp(){
		driver.get("http://automationpractice.com/index.php");
	}
	@Test
	public void logIn(){
		System.out.println(Test_WithInvalidInput.class);
	}
}
