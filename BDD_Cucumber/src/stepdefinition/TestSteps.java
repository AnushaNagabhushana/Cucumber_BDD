package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
//import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSteps {
	
	AndroidDriver<AndroidElement> driver;
	String email = "";
	
	@Given("^I want to launch BabyPlus app$")
	public void i_want_to_launch_BabyPlus_app() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("Platform", "Android");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hp.babyapp");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hp.babyplus.baby20.splash.SplashScreenActivity");
		dc.setCapability(MobileCapabilityType.UDID, "1215fc6cdf5d0604");
		dc.setCapability("instrumentApp", true);
		driver = new AndroidDriver<>(new URL("http://localhost:4727/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^I am in welcome screen$")
	public void i_am_in_welcome_screen() {
		String Home_Text = driver.findElement(By.id("tv_app_title")).getText();
		Assert.assertEquals("Not in Home screen", "Baby+", Home_Text);
	  
	}

	@When("^I click on JOIN US button$")
	public void i_click_on_JOIN_US_button()  {
		driver.findElement(By.id("btn_sign_up")).click();
 
	}

	@When("^I generate email id$")
	public void i_generate_email_id() {
		 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		email = timeStamp.toString()+ "_babyplus@grr.la";   
	}

	@When("^I enter valid email id and password \"([^\"]*)\"$")
	public void i_enter_valid_email_id_and_password(String pwd)  {
		AndroidElement button = driver.findElement(By.id("inputEmail"));
		button.click();
		button.sendKeys(email);
		driver.hideKeyboard();
		AndroidElement password = driver.findElement(By.id("inputPassword"));
		password.click();
		password.sendKeys(pwd);
		driver.hideKeyboard();
	
	}

	@When("^I select create account button$")
	public void i_select_create_account_button() {
		driver.findElement(By.id("createAccountButton")).click();
	}

	@Then("^I am on tracking page$")
	public void i_am_on_tracking_page()  {
		String Home_Text = driver.findElement(By.name("About You")).getText();
		Assert.assertEquals("not in abt you page", Home_Text, "About You");
	   
	}


}
