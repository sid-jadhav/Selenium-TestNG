package Pages.naukri;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	By locationLater=By.xpath("//*[@id='block']");
	By locationSure=By.xpath("//*[@id='allow']");
	By login=By.xpath("//*[@class='topIcon jobs Login']");
	By emailId=By.xpath("//*[contains(@id,'ogin')][@name='email']");
	By pass=By.xpath("//*[@id='pLogin']");
	By loginButton=By.xpath("//*[text()='Login'][@class='blueBtn']");
	By loginFrame=By.xpath(".//*[@id='login-iframe']");
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void handlePopupWindows() throws InterruptedException{
		String currentWin=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String win:windows){
			driver.switchTo().window(win);
			if(driver.getWindowHandle().equals(currentWin)){
				continue;
			}
			driver.close();
		}
		driver.switchTo().window(currentWin);
	}
	
	public void enterCredentials(String userName, String password){
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(login));
		driver.findElement(login).click();
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginButton).click();
	}
}
