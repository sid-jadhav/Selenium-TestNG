package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createAccount {
	WebDriver driver;
	private By Title1_radioButton=By.xpath("//*[@id='id_gender1']");
	private By Title2_radioButton=By.xpath("//*[@id='id_gender2']");
	
	private By FirstName=By.xpath("//*[@id='customer_firstname']");
	private By LastName=By.xpath("//*[@id='customer_lastname']");
	private By Email=By.xpath("//*[@id='email']");
	private By Password=By.xpath("//*[@id='passwd']");
	
	private By DOB_Day_DropDown=By.xpath("//*[@id='days']");
	private By DOB_Month_DropDown=By.xpath("//*[@id='months']");
	private By DOB_Year_DropDown=By.xpath("//*[@id='years']");
	
	private By SignUpForNewsLettet_CheckBox=By.xpath("//*[@id='newsletter']");
	private By ReceiveSpecialOffer_CheckBox=By.xpath("//*[@id='optin']");
	
	private By AddressFirstName=By.xpath("//*[@id='firstname']");
	private By AddressLastName=By.xpath("//*[@id='lastname']");
	private By Company=By.xpath("//*[@id='company']");
	private By Address1=By.xpath("//*[@id='address1']");
	private By Address2=By.xpath("//*[@id='address2']");
	private By City=By.xpath("//*[@id='city']");
	private By State=By.xpath("//*[@id='id_state']");
	private By PinCode=By.xpath("//*[@id='postcode']");
	private By Country_DropDown=By.xpath("//*[@id='id_country']");
	private By AdditionalInfo=By.xpath("//*[@id='other']");
	private By HomePhone=By.xpath("//*[@id='phone']");
	private By MobilePhone=By.xpath("//*[@id='phone_mobile']");
	private By AddressAlise=By.xpath("//*[@id='alias']");
	private By RegisterLink= By.xpath("//*[@id='submitAccount']");
	
	public createAccount(WebDriver driver){
		this.driver=driver;
		
	}
	public void ClickOnRadioButton(String fieldName){
		if(fieldName.equals("Mr")){
			driver.findElement(Title1_radioButton).click();
		}else if(fieldName.equals("Mrs")){
			driver.findElement(Title2_radioButton).click();
		}
	}
	public void Enter_FirstName(String FirstName){
		driver.findElement(this.FirstName).sendKeys(FirstName);
	}
	public void Enter_LastName(String LastName){
		driver.findElement(this.LastName).sendKeys(LastName);
	}
	public void Enter_Email(String Email){
		driver.findElement(this.Email).sendKeys(Email);
	}
	public void Enter_Password(String Password){
		driver.findElement(this.Password).sendKeys(Password);
	}
	public void Select_Day(int Day) throws InterruptedException{
		Day++;
		driver.findElement(this.DOB_Day_DropDown).click();
		Thread.sleep(1000);
		String day="//*[@id='days']/option["+Day+"]";
		driver.findElement(By.xpath(day)).click();
	}
	public void Select_Month(String month) throws InterruptedException{
		driver.findElement(DOB_Month_DropDown).click();
		Thread.sleep(1000);
		//*[@id='months']/option[4]
		String monthElements="//*[@id='months']/option";
		List<WebElement> allMonths=driver.findElements(By.xpath(monthElements));
		for(WebElement element: allMonths){
			String comp=element.getText().trim();
			if(comp.compareTo(month)==0){
				element.click();
			}
		}
	}
	public void Select_Year(String year) throws InterruptedException{
		driver.findElement(this.DOB_Year_DropDown).click();
		Thread.sleep(1000);
		String yearElements="//*[@id='years']/option";
		List<WebElement> allYears=driver.findElements(By.xpath(yearElements));
		for(WebElement element: allYears){
			if(element.getText().trim().compareTo(year)==0){
				element.click();
			}
		}
	}
	public void Enter_Company(String companyName){
		driver.findElement(Company).sendKeys(companyName);
	}
	
	public void Enter_Address(String address1, String address2){
		driver.findElement(Address1).sendKeys(address1);
	}
	
	public void Enter_City(String city){
		driver.findElement(City).sendKeys(city);
	}
	
	public void Select_State(String state){
		driver.findElement(State).click();
		String stateElements="//*[@id='id_state']/option";
		List<WebElement> states=driver.findElements(By.xpath(stateElements));
		for(WebElement get: states){
			System.out.println(get.getText().trim());
			if(get.getText().trim().compareTo(state)==0){
				get.click();
			}
		}
	}
	public void Enter_ZipCode(String zip){
		driver.findElement(PinCode).sendKeys(zip);
	}
	
	public void Select_Country(String country){
		driver.findElement(Country_DropDown).click();
		String cXpath="//*[@id='id_country']/option";
		List<WebElement> count=driver.findElements(By.xpath(cXpath));
		for(WebElement get:count){
			System.out.println(get.getText().trim());
			if(get.getText().trim().equals(country)){
				get.click();
			}
		}
	}
	
	public void Enter_MobileNo(String mobile){
		driver.findElement(MobilePhone).sendKeys(mobile);
	}
	public void Enter_AddressAlise(String address){
		driver.findElement(AddressAlise).sendKeys(address);
	}
	
	public void ClickOnRegisterLink(){
		driver.findElement(RegisterLink).click();
	}
	
	public void CheckTheCheckBox(){
		driver.findElement(ReceiveSpecialOffer_CheckBox).click();
		driver.findElement(SignUpForNewsLettet_CheckBox).click();
	}
	
	
}
