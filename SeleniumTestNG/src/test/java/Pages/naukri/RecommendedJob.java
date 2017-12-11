package Pages.naukri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RecommendedJob {
	WebDriver driver;
	Actions a;
	By displayMsg=By.xpath("//span[@id='msg1']");
	public RecommendedJob(WebDriver driver){
		this.driver=driver;
	}
	
	
}
