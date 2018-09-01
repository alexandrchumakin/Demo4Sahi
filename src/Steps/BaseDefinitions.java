package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.sahi.Proxy;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;
import org.junit.After;
import org.junit.Before;

public class BaseDefinitions {
    protected Browser browser;
    protected Proxy proxy;
    protected boolean isProxyInSameProcess = false;
    protected String browserType = "firefox";

    @Before
    public void createConn() throws Exception {
        Configuration.initJava("C:/Users/achumakin/sahi", "C:/Users/achumakin/sahi/userdata/");
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

    @Given("^I am on login page for the \"([^\"]*)\" tenant$")
    public void I_am_on_login_page_for_the_tenant(String arg1) throws Throwable {
        browser.navigateTo("http://10.50.5.125/QAPortal/");
        browser.textbox("UsernameTextbox").setValue("achumakin@falcon.com");
        browser.password("PasswordTextbox").setValue("514341bi0");
        browser.submit("Log On").click();
        browser.waitFor(10);
    }

    @When("^I click on link \"([^\"]*)\"$")
    public void I_click_on_link(String arg1) throws Throwable {
        browser.link(arg1);
    }

    @And("^I switch to popup window \"([^\"]*)\"$")
    public void I_switch_to_popup_window(String arg1) throws Throwable {
        browser.popup("Welcome");
    }

    @Then("^I should see text on page containing \"([^\"]*)\"$")
    public void I_should_see_text_on_page_containing(String arg1) throws Throwable {
        browser.link(arg1).exists();
    }
}
