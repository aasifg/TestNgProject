package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	WebDriver Driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.Driver=driver;
	}
	
	    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER;
		@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_DROPDOWN_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_NUMBER_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIPCODE_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"select2-country-container\"]") WebElement SELECT_COUNTRY_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ELEMENT;
		
		
	public void validateAddContactPage(String AddContactHeader) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), AddContactHeader, "Add Contact page is not available" );
		
		
	}
	
	public void insertFullName(String fullName) {
		int genNum = generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(fullName + genNum);
	}
	
	public int generateRandomNo(int boundNo) {
		Random rnd = new Random();
		int generatedNo = rnd.nextInt(boundNo);
		return generatedNo;
	}
	
	
	
	public void selectCompany(String company) {
		
		selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, company);
		
	}
	
	
	public void insertEmail(String email) {
		
		EMAIL_ELEMENT.sendKeys(generateRandomNo(9999)+ email);
		
	}
	
	public void insertPhoneNumber(String phoneNo) {
		
		PHONE_NUMBER_ELEMENT.sendKeys(phoneNo + generateRandomNo(999));
		
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
		
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
		
	}
	
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
		
	}
	
	public void insertZipCode(String zipcode) {
		ZIPCODE_ELEMENT.sendKeys(zipcode);
		
	}
	
	public void selectCountry(String country) {
		selectFromDropDown(SELECT_COUNTRY_ELEMENT,country);
		
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
		
	}
	
	
	
}
