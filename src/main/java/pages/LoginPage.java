package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.CommonUtils;
import commonUtils.Elementutils;

public class LoginPage {
	WebDriver driver;
	Elementutils elementutils;
	@FindBy(id="input-email") WebElement email;
	@FindBy(id="input-password") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]") WebElement warning;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new Elementutils(driver);
	}
	
	public void Enteremail(String emailText)
	{
		elementutils.typeTextIntoElement(email, emailText, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public void EnterPassword(String pass1)
	{
		elementutils.typeTextIntoElement(password, pass1, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	public Account clickLogin()
	{
		elementutils.clickOnElement(login, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		return new Account(driver);
	}
	public String warning()
	{
		return elementutils.getText(warning, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}
	
}
