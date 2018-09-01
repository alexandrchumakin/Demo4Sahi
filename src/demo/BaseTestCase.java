package demo;

import org.junit.After;
import org.junit.Before;
import net.sf.sahi.Proxy;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

public class BaseTestCase {
	protected Browser browser;
	protected Proxy proxy;
	protected boolean isProxyInSameProcess = false;
	protected String browserType = "firefox";
	@Before
	public void createConn() throws Exception {
		Configuration.initJava("C:/Users/user/sahi", "C:/Users/user/sahi/userdata/");
		if (isProxyInSameProcess) {
			proxy = new Proxy();
			proxy.start(true);
		}
		browser = new Browser(this.browserType);
		browser.open();
	}
	@After
	public void delConn() throws Exception {
		browser.setSpeed(100);
		browser.close();
		if (isProxyInSameProcess) {
			proxy.stop();
		}
	}
	public void login(){
		browser.navigateTo("http://1.1.1.125/QAPortal/");
		browser.textbox("UsernameTextbox").setValue("UserName");
		browser.password("PasswordTextbox").setValue("PW");
		browser.submit("Log On").click();
        browser.waitFor(10);
	}
	public void logout(){}
}
