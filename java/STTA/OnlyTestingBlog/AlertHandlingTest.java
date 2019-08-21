package STTA.OnlyTestingBlog;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.TestNGListener;


@Listeners(TestNGListener.class)
public class AlertHandlingTest extends SuiteBase{
	public Alert alert;
	
	  @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'Selectable')]")).click();
		  }
	  
 	  
	  @Test
	  public void handleAlertTest() throws InterruptedException  {
		    Actions action = new Actions(driver);
		    WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		    //Thread.sleep(3000);
		    action.moveToElement(button);
		    action.doubleClick(button).build().perform();
		    //Thread.sleep(3000);
		    assertEquals(  isAlertPresent(), true, "No alert present: ");
		    //Thread.sleep(3000);
		   //Alert alert = driver.switchTo().alert();
		    logger.debug("Taking result from alert window. The alert text is: " + alert.getText());
		    alert.accept();
		    assertEquals(  isAlertPresent(), false, "Alert is still there: ");
		    logger.debug("Alert is closed " );
	  }

	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }
	  
	  private boolean isAlertPresent(){
          try{
        	  alert = driver.switchTo().alert();
              return true;
              }catch(NoAlertPresentException ex){
                    return false;
              }
          }

	  
}
