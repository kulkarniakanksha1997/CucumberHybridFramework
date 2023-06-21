package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.CommonUtils;
import commonUtils.Elementutils;

public class SignupPages {
	
	WebDriver driver;
	Elementutils elementutils;
	@FindBy(id="input-firstname") WebElement Firstname;
	@FindBy(id="input-lastname") WebElement LastName;
	@FindBy(id="input-email") WebElement Email;
	@FindBy(id="input-telephone") WebElement telephone;
	@FindBy(id="input-password")WebElement password;
	@FindBy(id="input-confirm") WebElement Cpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement privacy;
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement signupButton;
	@FindBy(xpath="//input[@name='newsletter'][@value=1]") WebElement newsletter;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") WebElement warning;
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div") WebElement firstwarning;
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")  WebElement LastNameWarning;
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div") WebElement Telephonewarning;
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")  WebElement PasswordMessage;
	
	public SignupPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new Elementutils(driver);
	}
	
	public void firstname(String firstname)
	{
		elementutils.typeTextIntoElement(Firstname, firstname, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void lastname(String lastname)
	{
		elementutils.typeTextIntoElement(LastName, lastname, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void email(String email)
	{
		elementutils.typeTextIntoElement(Email, email, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void Telephone(String num)
	{
		elementutils.typeTextIntoElement(telephone, num, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void password(String Psw )
	{
		elementutils.typeTextIntoElement(password, Psw, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void cpassword(String Psw)
	{
		Cpassword.sendKeys(Psw);
	}
	public void policy()
	{
		elementutils.clickOnElement(privacy, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
			}
	public AccountSucess signupclick()
	{
		elementutils.clickOnElement(signupButton, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
		return new AccountSucess(driver);
		
	}
	public void newsletter()
	{
		elementutils.clickOnElement(newsletter, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public String alertWarning()
	{
		return elementutils.getText(warning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public String firstnamewarning()
	{
		return elementutils.getText(firstwarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public String latnameWarning()
	{
		return elementutils.getText(LastNameWarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
	}
	public String Telephonewarning()
	{
		return elementutils.getText(Telephonewarning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public String PasswordWarningMessage()
	{
		return elementutils.getText(PasswordMessage, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
