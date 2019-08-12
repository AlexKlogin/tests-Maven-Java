package STTA.OnlyTestingBlog;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.TestNGListener;


@Listeners(TestNGListener.class)
public class CheckBoxTest extends SuiteBase{

	
	  @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'Table With Checkbox')]")).click();
	  }
	  
 	  
	  @Test
	  public void frame1Test() throws InterruptedException {
		    
		    driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).click();
		    driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).click();
		    boolean x = driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).isSelected();
		   // logger.debug("Taking text from //h3[@class='post-title entry-title'] element. Result is: " + frame1InnerText);
		   // assertEquals("Table With Checkbox", frame1InnerText);
		    
	  }
	  
	  
	  
	  
	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }

	  
}
