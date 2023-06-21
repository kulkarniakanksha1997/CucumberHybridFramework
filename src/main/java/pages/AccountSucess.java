package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.CommonUtils;
import commonUtils.Elementutils;

public class AccountSucess {
	WebDriver driver;
	Elementutils elementutils;
	public AccountSucess(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new Elementutils(driver);
	}
	@FindBy(xpath="//div[@id='content']/h1") WebElement AccountMessage;
	
	public String VerifyMessage()
	{
		return elementutils.getText(AccountMessage, CommonUtils.EXPLICITE_WAIT_BASIC_TIME);
				
		 
	}

}
