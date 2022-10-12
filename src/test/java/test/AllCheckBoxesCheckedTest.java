package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.CheckboxPage;
import util.BrowserFactory;

public class AllCheckBoxesCheckedTest {
	WebDriver driver;

	@Before

	public void init() {
		// creates connection between browserFactory and AllCheckBoxesChecked drivers
		driver = BrowserFactory.init();
	}

	@Test
	public void validateAllCheckBoxesChecked() {
		// creating object for the CheckboxPage
		CheckboxPage checkbox = PageFactory.initElements(driver, CheckboxPage.class);
		// call the method
		checkbox.clickToggleAll();

		// Calling and asserting at the same time
		Assert.assertEquals(true, checkbox.validateAllCheckBoxes());
	}

	@After
	public void tearDown() {
		BrowserFactory.tearDown();
	}
}