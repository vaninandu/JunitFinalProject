package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.CheckboxPage;
import util.BrowserFactory;

public class RemoveSingleListItemTest {
	WebDriver driver;

	@Before
	public void init() {
		driver = BrowserFactory.init();
	}

	@Test
	public void removeOneElement() {
		CheckboxPage checkbox = PageFactory.initElements(driver, CheckboxPage.class);

		// Calling and asserting at the same time
		Assert.assertEquals(true, checkbox.removeOneItem());
	}
	
	@After
	public void tearDown() {
		BrowserFactory.tearDown();
	}
}
