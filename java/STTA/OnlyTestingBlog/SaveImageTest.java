package STTA.OnlyTestingBlog;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import STTA.OnlyTestingBlog.Pages.SelectablePage;

public class SaveImageTest extends SuiteBase{
	 
	  @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'Selectable')]")).click();
		  // selectablePage = new SelectablePage(driver);
		  }
	  
	 @Test
	 public void Save_Image() throws IOException, InterruptedException, AWTException {
	  //Locate Image
	  WebElement Image =driver.findElement(By.xpath("//img[@border='0']"));
	  //Rihgt click on Image using contextClick() method.
	  Actions action= new Actions(driver);
	  action.contextClick(Image).build().perform();
	  
	  //To perform press Ctrl + v keyboard button action.
	  //action.sendKeys(Keys.SHIFT, "v").perform();
	  //action.keyDown(Keys.SHIFT).sendKeys("v").keyUp(Keys.SHIFT).build().perform();

	  
	  //Thread.sleep(3000);
	  Robot robot = new Robot();
	//To perform press shift + v keyboard button action.
	  robot.keyRelease(KeyEvent.VK_SHIFT);
	  robot.keyPress(KeyEvent.VK_V);
	  Thread.sleep(3000);
	  // To press D key.
	  robot.keyPress(KeyEvent.VK_D);
	  // To press : key.
	  robot.keyPress(KeyEvent.VK_SHIFT);
	  robot.keyPress(KeyEvent.VK_SEMICOLON);
	  robot.keyRelease(KeyEvent.VK_SHIFT);
	  // To press \ key.
	  robot.keyPress(KeyEvent.VK_BACK_SLASH);
	  // To press "test" key one by one.
	  robot.keyPress(KeyEvent.VK_T);
	  robot.keyPress(KeyEvent.VK_E);
	  robot.keyPress(KeyEvent.VK_S);
	  robot.keyPress(KeyEvent.VK_T);
	  // To press Save button.	 
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_ENTER);  
	  robot.keyPress(KeyEvent.VK_LEFT);
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_ENTER); 
	 }
	}