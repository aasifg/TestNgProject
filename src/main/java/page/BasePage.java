package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public int generateRandomNo(int boundNo) {
		Random rnd = new Random();
		int generatedNo = rnd.nextInt(boundNo);
		return generatedNo;
		
	}
	
	
	public void selectFromDropDown(WebElement element, String visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);
		
	}

}
