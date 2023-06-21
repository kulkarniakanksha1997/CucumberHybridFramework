package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.CommonUtils;
import commonUtils.Elementutils;

public class Account {
	
	WebDriver driver;
	Elementutils elementutils;
	@FindBy(xpath="//a[contains(text(),'account information')]") WebElement AccountInfoDispalyed;
	
	public Account(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new Elementutils(driver);
	}
	
	public boolean VerifyAccount()
	{
		return elementutils.isDisplayed(AccountInfoDispalyed, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
		
	}

}
