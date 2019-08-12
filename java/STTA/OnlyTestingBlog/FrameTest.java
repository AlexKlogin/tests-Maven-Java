package STTA.OnlyTestingBlog;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.TestNGListener;


@Listeners(TestNGListener.class)
public class FrameTest extends SuiteBase{

	
	  @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'iframe1')]")).click();
	  }
	  
 	  
	  @Test
	  public void frame1Test() throws InterruptedException {
		    driver.switchTo().frame("frame1");
		    String frame1InnerText = driver.findElement(By.xpath("//h3[@class='post-title entry-title']")).getText();
		    logger.debug("Taking text from //h3[@class='post-title entry-title'] element. Result is: " + frame1InnerText);
		    assertEquals("Table With Checkbox", frame1InnerText);
	  }
	  
	  @Test
	  public void frame2Test() throws InterruptedException {
		    //driver.findElement(By.xpath(".//a[contains(text(),'iframe1')]")).click();
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("frame2");
		    String frame2InnerText = driver.findElement(By.xpath("//h3[@class='post-title entry-title']")).getText();
		    logger.debug("Taking text from //h3[@class='post-title entry-title'] element.  Result is: " + frame2InnerText);
		    assertEquals("TextBox", frame2InnerText);
	  }	  
	  
	  
	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }

	  
}
