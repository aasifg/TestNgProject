package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.Loginpage;
import util.BrowserFactory;
import util.ExcelReader;

	public class LoginTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\TestData\\SeleniumTestData.xlsx");
	String loginId = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		 driver = BrowserFactory.init();
	
		
		 Loginpage loginpage = PageFactory.initElements(driver, Loginpage.class);
		 loginpage.insertUserName(loginId);
		 loginpage.insertPassword(password);
		 loginpage.clickSigninButton();
		 
		 DashboardPage dashboardpage= PageFactory.initElements(driver, DashboardPage.class);
		 dashboardpage.validateDashboardPage("Dashboard");
		 
		 BrowserFactory.tearDown();
		 
	}

}
