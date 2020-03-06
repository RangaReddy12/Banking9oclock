package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;
	WebDriverWait wait;
	@When("^I open OrangeHRMS URL on chrome$")
	public void i_open_OrangeHRMS_URL_on_chrome() throws Throwable {
	 driver=new ChromeDriver();
	 driver.get("http://orangehrm.qedgetech.com/");
	 driver.manage().window().maximize();
	}

	@When("^I enter username in usernameField and enter password$")
	public void i_enter_username_in_usernameField_and_enter_password() throws Throwable {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtUsername")));
	   driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtPassword")));
	   driver.findElement(By.name("txtPassword")).sendKeys("Admin");
	}

	@When("^I click Login Button$")
	public void i_click_Login_Button() throws Throwable {
		wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit")));
		driver.findElement(By.name("Submit")).click();
			}

	@Then("^I Should see dash text in url$")
	public void i_Should_see_dash_text_in_url() throws Throwable {
	 if(driver.getCurrentUrl().contains("dash"))
	 {
		 System.out.println("Login success");
	 }
	 else
	 {
		 System.out.println("Login Fail");
	 }
	}

	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    driver.close();
	}
}
