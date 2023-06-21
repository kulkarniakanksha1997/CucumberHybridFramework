package commonUtils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementutils {
	WebDriver driver;
	public Elementutils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element, long durarionInSecond)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durarionInSecond));
		WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durarionInSecond )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durarionInSecond));
		WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeTyped);
	}
	public WebElement WaitForElement(WebElement element,long durationInSecond)
	{
		WebElement webelement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
		webelement =wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return webelement;
	}
	public void selectOptionDropdown(WebElement element, String textToBeselected, long durationInSeconds)
	{
		WebElement webelement=WaitForElement(element, durationInSeconds);
		Select s1=new Select(webelement);
		s1.selectByVisibleText(textToBeselected);
	}
	public Alert WaitForAlert(long durtionOfSeconds)
	{
		Alert alert=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durtionOfSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alert;
		
		
	}
	public void AcceptAlert(long durationOfSeconds)
	{
		Alert alert=WaitForAlert(durationOfSeconds);
		alert.accept();
	}
	public void DissmissAlert(long durationOfSeconds)
	{
		Alert alert=WaitForAlert(durationOfSeconds);
		alert.dismiss();
	}
	
	public WebElement WaitForVisiblity(WebElement element, long durationOfSeconds)
	{
		WebElement webelement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));
		webelement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return webelement;
		
	}
	public void MovetoElementAndClick(WebElement element,long durationOfseconds)
	{
		WebElement webelement=WaitForVisiblity(element,durationOfseconds);
		Actions act=new Actions(driver);
		act.moveToElement(webelement).click().build().perform();
	}
	public void JavascriptClick(WebElement element,long durationOfseconds)
	{
		WebElement webelement=WaitForVisiblity(element,durationOfseconds);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", webelement);
	}
	public void JavaScripttype(WebElement element, long durationOfSeconds,String TextToTyped)
	{
		WebElement webelement=WaitForVisiblity(element, durationOfSeconds);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].Value='"+TextToTyped+"'", webelement);
	}
	public String getText(WebElement element, long durationOfSeconds)
	{
		WebElement webelement=WaitForElement(element, durationOfSeconds);
		return webelement.getText();
	}
	public boolean isDisplayed(WebElement element, long durationOfseconds)
	{
		try {
		WebElement webelement=WaitForVisiblity(element,durationOfseconds);
		return webelement.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}
	}
}
