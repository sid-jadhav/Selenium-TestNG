package Pages.naukri;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NaukriProfileHome {
	WebDriver driver;
	
	Actions a;
	By notification =By.xpath("//a[@id='blobId']");
	By subOptions=By.xpath("//*[@class='notification subMenu']/ul/li/a");
	public NaukriProfileHome(WebDriver driver){
		this.driver=driver;
	}
	public void clickOnJobRecommendation() throws InterruptedException{
		a= new Actions(driver);
		a.moveToElement(driver.findElement(notification)).click().perform();
		Thread.sleep(2000);
		List<WebElement> subOp=driver.findElements(subOptions);
		for(WebElement su:subOp){
			a.moveToElement(su);
			if(su.getAttribute("href").equals("https://www.naukri.com/recommendedjobs")){
				su.click();
				System.out.println("Clicked element");
				break;
			}
		}
	}
}
