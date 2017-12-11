package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signIn {
	//Logger log =Logger.getLogger(signIn.class.getName());
	WebDriver driver;
	private By sign_in= By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	private By AlreadyRegistered_EmailAddress= By.xpath("//*[@id='email']");
	private By AlreadyRegistered_Password=By.xpath("//*[@id='passwd']");
	private By ForgotPassword = By.xpath("//*[@id='login_form']/div/p[1]/a");
	private By sign_in_button=By.xpath("//*[@id='SubmitLogin']/span");
	private By CreateAnAccount= By.xpath("//*[@id='SubmitCreate']/span");
	private By CreateAnAccount_EmailAddress=By.xpath("//*[@id='email_create']");
	
	public signIn(WebDriver driver){
		//log.info("SignIn class is called");
		this.driver =driver;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(sign_in).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void Enter_AlreadyRegistered_EmailAddress(String Email){
		//log.info("Entering Email into the box");
		driver.findElement(AlreadyRegistered_EmailAddress).sendKeys(Email);
	}
	public void Enter_AlreadyRegistered_Password(String password){
		driver.findElement(AlreadyRegistered_Password).sendKeys(password);
	}
	public void ClickOnSignIn(){
		driver.findElement(sign_in_button).click();
	}
	
	public void Enter_CreateAnAccount_EmailAddress(String Email){
		driver.findElement(CreateAnAccount_EmailAddress).sendKeys(Email);
	}
	
	public createAccount ClickOnCreateAnAccount(){
		createAccount ca=new createAccount(driver);
		driver.findElement(CreateAnAccount).click();;
		return ca;
	}
	
	
}
