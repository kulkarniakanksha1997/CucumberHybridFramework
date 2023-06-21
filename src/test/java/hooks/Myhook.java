package hooks;



import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ReadConfig;

public class Myhook   {
	WebDriver driver;
	Properties prop;
	Driverfactory df;
	ReadConfig read;
	

	@Before
	public void setup()
	{
		read=new ReadConfig();
		prop=read.readconfig();
		df=new Driverfactory();
		driver=df.intialize(prop.getProperty("browser"));
		
		
		driver.get(prop.getProperty("url"));
		System.out.println(System.getProperty("user.dir"));
		
	}
	@After
	public void teardown(Scenario scenario) throws InterruptedException
	{
		String Scenarioname=scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
		byte[] srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcFile, "image/png", Scenarioname);
		}
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
}
