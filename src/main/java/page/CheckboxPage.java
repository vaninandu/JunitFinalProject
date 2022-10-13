package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class CheckboxPage {
	WebDriver driver;

	// constructor to store the driver parameter from the object of the CheckboxPage
	// in AllCheckBoxesCheckedTest
	public CheckboxPage(WebDriver driver) {
		this.driver = driver;
	}

//WebElements 
	@FindBy(how = How.NAME, using = "allbox")
	WebElement TOGGLE_CHECKBOX_ELEMENT;

	@FindBy(how = How.XPATH, using = "//div[@id='todos-content']//input[@type='checkbox']")
	List<WebElement> LIST_OF_ELEMENT;

	@FindBy(how = How.NAME, using = "submit")
	WebElement REMOVE_ELEMENT;

//Corresponding methods

	public void clickToggleAll() {
		TOGGLE_CHECKBOX_ELEMENT.click();
	}

	public boolean validateAllCheckBoxes() {

		System.out.println(LIST_OF_ELEMENT.size());
		int totalCheckBox = LIST_OF_ELEMENT.size();
		int checkedcount = 0;
		for (int i = 0; i < totalCheckBox; i = i + 1) {

			if (LIST_OF_ELEMENT.get(i).isSelected()) {
				checkedcount++;
			}
		}
		System.out.println(checkedcount + " selected");
//Total check boxes and no. of check boxes selected
		if (checkedcount == totalCheckBox) {
			return true;

		} else {
			return false;
		}

	}

	public boolean removeOneItem() {

		System.out.println(LIST_OF_ELEMENT.size());
		int totalCheckBox = LIST_OF_ELEMENT.size();
		LIST_OF_ELEMENT.get(0).click();
		REMOVE_ELEMENT.click();

		List<WebElement> LIST_OF_ELEMENT_LATER = driver
				.findElements(By.xpath("//div[@id='todos-content']//input[@type='checkbox']"));
		System.out.println(LIST_OF_ELEMENT_LATER.size());

		if (totalCheckBox > LIST_OF_ELEMENT_LATER.size()) {
			return true;
		} else {
			return false;
		}
	}

	public int removeAllItems() {
		REMOVE_ELEMENT.click();
		List<WebElement> checkBoxElement = driver.findElements(By.xpath("//div[@id='todos-content']//input[@type='checkbox']"));
		int checkBox = checkBoxElement.size();	
		return checkBox;

	}
}
