package STTA.OnlyTestingBlog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class remoteDriver {
	
	private WebDriver driver=null;
	private	String basicURL= "http://only-testing-blog.blogspot.com/";
		
	 @Parameters({ "browser" })
	 @BeforeTest(alwaysRun = true)
	 public void mains(String browser) throws MalformedURLException {
		 if (browser.equalsIgnoreCase("Edge")) {
			 EdgeOptions edgeOptions = new EdgeOptions();
	         driver = new RemoteWebDriver(new URL("http://192.168.1.14:5566/wd/hub"), edgeOptions); 
		 }
		 if (browser.equalsIgnoreCase("Chrome")) {
			 ChromeOptions chromeOptions = new ChromeOptions();
             driver = new RemoteWebDriver(new URL("http://192.168.1.14:5566/wd/hub"), chromeOptions);	  
		 }
		 if (browser.equalsIgnoreCase("FireFox")){
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
	         driver = new RemoteWebDriver(new URL("http://192.168.1.14:5566/wd/hub"), firefoxOptions);
		 }
	 }	
	 
		 @Test(description = "Wait for button enabled")
		 public void waitForButtonEnabled()   {
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  // Open URL of Application
			  driver.get(basicURL);
			  driver.findElement(By.xpath(".//a[contains(text(),'iframe1')]")).click();
		 } 


	 @AfterTest
	  public void endWith() {
		   driver.quit();
	  }

}
