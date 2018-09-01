package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class test4demo extends BaseTestCase {
	
	@Before
	public void setUp() {
		login();
	}
	
	@After
	public void tearDown() {
		logout();
	}
	
	@Test
	public void testDemo1() {
        browser.link("Search").click();
        browser.link("Search[1]").click();
		assertTrue(browser.span("Search").exists());
	}
	
	@Test
	public void testDemo2() {
		browser.textbox("email").setValue("demo@sahi.com");
		browser.submit("Submit").click();
		assertTrue(browser.label("ok").exists());
	}
}
