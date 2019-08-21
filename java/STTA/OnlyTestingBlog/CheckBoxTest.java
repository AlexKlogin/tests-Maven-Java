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
	  public void selectCheckBoxTest() throws InterruptedException {
		    driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).click();
		    boolean isSelected = driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).isSelected();
		    logger.debug("Taking result from checkbox //td[contains(text(),'Cat')]/../td/input element after selecting. Result is: " + isSelected);
		    assertEquals(isSelected, true);
	  }
	  
	  @Test(dependsOnMethods={"selectCheckBoxTest"})
	  public void unSselectCheckBoxTest() throws InterruptedException {
		    driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).click();
		    boolean isSelected = driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).isSelected();
		    logger.debug("Taking result from checkbox //td[contains(text(),'Cat')]/../td/input element after deselecting. Result is: " + isSelected);
		    assertEquals(isSelected, false);
	  } 
	  
	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }

	  
}
