package STTA.OnlyTestingBlog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeClass;
import java.util.logging.Level;


public class SuiteBase {	

	public static Properties Param = null;
	public static WebDriver driver=null;
	//To Initialize logger service.
	Logger logger = Logger.getLogger(this.getClass());
	  //To hide java warnings logs from execution console.
	java.util.logging.Logger javaLogger = java.util.logging.Logger.getLogger("");
	String basicURL= "http://only-testing-blog.blogspot.com/"; 
	
	@BeforeClass
	public void init() throws IOException{
		
		javaLogger.setLevel(Level.OFF);
		//Create object of Java Properties class
		Param = new Properties();
		FileInputStream fip = new FileInputStream("src//test//resources//Param.properties");
		Param.load(fip);
		logger.info("Param.properties file loaded successfully.");
		
		if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla")){
			//To Load Firefox driver Instance. 
			System.setProperty("webdriver.gecko.driver",Param.getProperty("geckodriver"));
			driver = new FirefoxDriver();
			logger.info("Firefox Driver Instance loaded successfully.");
			
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("Chrome")){
			//To Load Chrome driver Instance.
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Param.getProperty("chromedriver"));
			driver = new ChromeDriver();
			logger.info("Chrome Driver Instance loaded successfully.");
			
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE")){
			//To Load IE driver Instance.
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+Param.getProperty("MicrosoftWebDriver"));
			driver = new EdgeDriver();
			logger.info("IE Driver Instance loaded successfully.");
		}	
		
		else if(Param.getProperty("testBrowser").equalsIgnoreCase("HtmlUnit")){
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+Param.getProperty("MicrosoftWebDriver"));
			//Initializing HtmlUnitDriver.
			driver = new HtmlUnitDriver();
			logger.info("HtmlUnit headless Driver Instance loaded successfully.");
		}	
		
		else if(Param.getProperty("testBrowser").equalsIgnoreCase("HeadlessFireFox")){
			System.setProperty("webdriver.gecko.driver",Param.getProperty("geckodriver"));
			 FirefoxBinary firefoxBinary = new FirefoxBinary();
			    firefoxBinary.addCommandLineOptions("--headless");
			    System.setProperty("webdriver.gecko.driver",Param.getProperty("geckodriver"));
			    FirefoxOptions firefoxOptions = new FirefoxOptions();
			    firefoxOptions.setBinary(firefoxBinary);
			    driver = new FirefoxDriver(firefoxOptions);
		}
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();			
	}
}
	



























