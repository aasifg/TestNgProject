package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.Loginpage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\TestData\\SeleniumTestData.xlsx");
	String loginId = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName  = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email  = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone  = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	

	
	@Test
	public void userShouldBeAbleToCreateNewCustomer() throws InterruptedException {
		
		driver=BrowserFactory.init();
		
		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);
		loginPage.insertUserName(loginId);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		 DashboardPage dashboardpage= PageFactory.initElements(driver, DashboardPage.class);
		 dashboardpage.validateDashboardPage("Dashboard");
		 dashboardpage.clickCuromerMenuElement();
		 dashboardpage.clickAddCustomerMenuButtonElement();
		 
		 AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		 addCustomerPage.validateAddContactPage("Add Contact");
		 addCustomerPage.insertFullName(fullName);
		 addCustomerPage.selectCompany(companyName);
		 addCustomerPage.insertEmail(email);
		 addCustomerPage.insertPhoneNumber(phone);
		 addCustomerPage.insertAddress(address);
		 addCustomerPage.insertCity(city);
		 addCustomerPage.insertState(state);
		 addCustomerPage.insertZipCode(zip);
		 addCustomerPage.selectCountry(country);
		 addCustomerPage.clickSaveButton();
		 
		 
	}

}
