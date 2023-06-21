package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import commonUtils.CommonUtils;
import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Account;
import pages.HomePage;
import pages.LoginPage;

public class Login{
	 WebDriver driver;
	 LoginPage loginpages;
	 Account account ;
	 CommonUtils cs;
	 Driverfactory df;
	
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {
		df=new Driverfactory();
		driver=df.getdriver();
		
		HomePage hm=new HomePage(driver);
		hm.accountClick();
		loginpages=hm.loginclick();
		
	    }

	/*Scenario1*/
	@When("^Enter Valid Email Address (.+) in to the email field$")
	public void Enter_Valid_Email_Address_in_to_the_email_field(String email1) {
		loginpages.Enteremail(email1);
		
	}

	@And("^Enter Valid Password (.+) in to password field$")
	public void Enter_Valid_Password_in_to_password_field(String pass1) {
		loginpages.EnterPassword(pass1);
		
	}

	@And("clicks On login button")
	public void clicks_On_login_button() {
		account=loginpages.clickLogin();
		
	}

	@Then("User should get Successfully Logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(account.VerifyAccount());
	}
	
	//scenario 2
	@When("Enter inValid Email Address  in to the email field")
	public void Enter_invalid_email_address_in_to_the_email_field() {
		cs=new CommonUtils();
		loginpages.Enteremail(cs.getEmailWithTimeStamps());
		
	   	}

	@And("Enter inValid Password {string} in to password field")
	public void enter_invalid_password_in_to_password_field(String pass2) {
		loginpages.EnterPassword(pass2);
		
	    
	}
	
	
  @Then("User should get warning message creditionals mismatch")
	public void user_should_get_warning_message_creditionals_mismatch() {
	  Assert.assertTrue(loginpages.warning().contains("Warning: No match for E-Mail Address and/or Password."));
	  //Assert.fail();
	   
	}

  
	//scenario 5

	@When("User Enter the blank email into email field")
	public void user_enter_the_blank_email_into_email_field() {
		loginpages.Enteremail(" ");
		
	}

	@And("User Enter Blank  Password in to password field")
	public void user_enter_blank_password_in_to_password_field() {
		loginpages.EnterPassword(" ");
		
	   
	}
	

	   
}
