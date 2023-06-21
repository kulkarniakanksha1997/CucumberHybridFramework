package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.CommonUtils;
import commonUtils.Elementutils;

public class HomePage {
	
	WebDriver driver;
	Elementutils elementutils;
	@FindBy (xpath="//a[@title='My Account']")WebElement Account;
	@FindBy (xpath="//a[text()='Login']") WebElement login;
	@FindBy(xpath="//a[text()='Register']") WebElement signup;

	public HomePage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new Elementutils(driver);
	}
	public void accountClick()
	{
		elementutils.clickOnElement(Account, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
	}
	public LoginPage loginclick()
	{
		elementutils.clickOnElement(login, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	public SignupPages signup()
	{
		elementutils.clickOnElement(signup, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		return new SignupPages(driver);
	}

}
