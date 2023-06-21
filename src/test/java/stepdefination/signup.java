package stepdefination;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commonUtils.CommonUtils;
import factory.Driverfactory;
import io.cucumber.java.en.*;
import pages.AccountSucess;
import pages.HomePage;
import pages.SignupPages;

public class signup    {
	WebDriver driver;
	SignupPages sp;
	AccountSucess as;
	CommonUtils cs;
	Driverfactory df;
	
	
	Map<String ,String>dataMap;
	
	
	@Given("User Navigate on Signup Page")
	public void user_navigate_on_signup_page() {
		df=new Driverfactory();
		driver=df.getdriver();
		HomePage hm=new HomePage(driver);
		hm.accountClick();
		sp=hm.signup();
		
		
	   	}

	@When("User Enter the below  field")
	public void user_enter_the_below_field(io.cucumber.datatable.DataTable dataTable) {
		
		cs=new CommonUtils();
		dataMap=dataTable.asMap(String.class,String.class);
		sp.firstname(dataMap.get("firstname"));
		sp.lastname(dataMap.get("lastrname"));
		sp.email(cs.getEmailWithTimeStamps());
		sp.Telephone(dataMap.get("telephone"));
		sp.password(dataMap.get("password"));
		sp.cpassword(dataMap.get("password"));
			
	    
	}

	@And("User check the Privacy Policy check box")
	public void user_check_the_privacy_policy_check_box() {
		
	   sp.policy();
	  
	}

	@And("User clicks on Contiune button")
	public void User_clicks_on_Contiune_button() throws InterruptedException {
		
		as=sp.signupclick();
		Thread.sleep(2000);
		
	}

	@Then("User Should get Message Your Account has been created")
	public void User_Should_get_Message_Your_Account_has_been_created() {
	    Assert.assertEquals("Your Account Has Been Created!",as.VerifyMessage());
	   
	    
	
	}

	//scenario 2
	
	@And ("User select yes for newsletter")
	public void  User_select_for_newsletter()

	{
		sp.newsletter();
		
	}
	
	

	

	@When("User dont enter any field")
	public void user_dont_enter_any_field() {
		
		//intentionally kept blank
	
		
	}

	
	@Then("User should get warning message on required fields")
	public void User_should_get_warning_message_on_required_fields() {
		
		
	   Assert.assertTrue(" You must agree to the Privacy Policy!", sp.alertWarning().contains("Warning: You must agree to the Privacy Policy!"));
	   Assert.assertEquals("First Name must be between 1 and 32 characters!",sp.firstnamewarning());
	   Assert.assertEquals("Last Name must be between 1 and 32 characters!",sp.latnameWarning());
	   Assert.assertEquals("Telephone must be between 3 and 32 characters!",sp.Telephonewarning());
	   Assert.assertEquals("Password must be between 4 and 20 characters!",sp.PasswordWarningMessage());	
	   //Assert.fail();
	 
	   
	}
	

}
