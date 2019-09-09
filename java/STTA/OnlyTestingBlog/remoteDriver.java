package STTA.OnlyTestingBlog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
	Alert alert;
	
	 @Parameters({ "browser" })
	 @BeforeTest(alwaysRun = true)
	 public void mains(String browser) throws MalformedURLException {
		 if (browser.equalsIgnoreCase("Edge")) {
			 EdgeOptions edgeOptions = new EdgeOptions();
	         driver = new RemoteWebDriver(new URL("http://3.14.87.188:4444/wd/hub"), edgeOptions); 
		 }
		 else if (browser.equalsIgnoreCase("Chrome")) {
			 ChromeOptions chromeOptions = new ChromeOptions();
			 chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
			 chromeOptions.addArguments("--headless");
			 chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			 chromeOptions.setExperimentalOption("useAutomationExtension", false);
			 
			 chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
			 chromeOptions.addArguments("disable-infobars"); // disabling infobars
			 chromeOptions.addArguments("--disable-extensions"); // disabling extensions
			 //chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
			

             driver = new RemoteWebDriver(new URL("http://3.14.87.188:4444/wd/hub"), chromeOptions);	  
		 }
		 else if (browser.equalsIgnoreCase("FireFox")){
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
			 firefoxOptions.addArguments("--headless");
			 firefoxOptions.setAcceptInsecureCerts(true);
			 //ffoptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
			 //ffoptions.addArguments("--binary C:\Program Files (x86)\Mozilla Firefox\firefox.exe");
			 //ffoptions.addArguments("-profile");
			 //ffoptions.addArguments("C:\defaultprofilepath\Optum.default");
	         driver = new RemoteWebDriver(new URL("http://3.14.87.188:4444/wd/hub"), firefoxOptions);
		 }
 	 }	
	 
		 @Test(description = "Wait for button enabled")
		 public void waitForButtonEnabled()   {
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  //if(isAlertPresent())  alert.accept();
			//  System.out.println("testing");
			  // Open URL of Application
			  driver.get(basicURL);
			  if(isAlertPresent())  alert.accept();
			  driver.findElement(By.xpath(".//a[contains(text(),'iframe1')]")).click();
			  //if(isAlertPresent())  alert.accept();
			  System.out.println("testing");
		 } 
		 
		 public boolean isAlertPresent() 
		 { 
		     try 
		     { 
		    	 alert = driver.switchTo().alert(); 
		         return true; 
		     }   // try 
		     catch (NoAlertPresentException Ex) 
		     { 
		         return false; 
		     }   // catch 
		 }  


	 @AfterTest(alwaysRun = true)
	  public void endWith() {
		   driver.quit();
		  if ( ((RemoteWebDriver)driver).getSessionId() != null  )
			  System.out.println("Driver did not quit in proper way");
	  }

}
