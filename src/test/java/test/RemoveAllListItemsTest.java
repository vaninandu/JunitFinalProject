package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.CheckboxPage;
import util.BrowserFactory;

public class RemoveAllListItemsTest {
	WebDriver driver;

	@Before
	public void init() {
		driver = BrowserFactory.init();
	}

	@Test
	public void removeAllElements() {
		CheckboxPage checkbox = PageFactory.initElements(driver, CheckboxPage.class);
		checkbox.clickToggleAll();

		// Calling and asserting at the same time
		Assert.assertEquals(0, checkbox.removeAllItems());
	}

	@After
	public void tearDown() {
		BrowserFactory.tearDown();
	}

}
