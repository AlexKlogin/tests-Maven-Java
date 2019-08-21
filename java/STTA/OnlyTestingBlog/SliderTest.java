package STTA.OnlyTestingBlog;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SliderTest extends SuiteBase{
    int first_step = 25;
	
	
	 @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'Selectable')]")).click();
		  }
	  
	  
	  @Test
	  public void moveSliderRightTest() throws InterruptedException {
		    
		    WebElement slider =driver.findElement(By.xpath("//div[@id='slider']"));
		    int width=slider.getSize().getWidth();
		    Actions move = new Actions(driver);
		    logger.debug("Moving Slider in "+first_step+"%");
		    Action action = (Action) move.dragAndDropBy(slider, (width*first_step)/100, 0).build();
		    action.perform();
		    WebElement sliderHandle =driver.findElement(By.xpath("//div[@id='slider']/span"));
		    logger.debug("Checking result from slider handle //div[@id='slider']/span element after moving slider. Result is: " + sliderHandle.getAttribute("style"));
		    String sliderPercent =sliderHandle.getAttribute("style");
		  	assertEquals(sliderPercent,"left: "+(100-first_step)+"%;");
	  }
/*	  
	  @Test
	  public void unSselectCheckBoxTest() throws InterruptedException {
		    
		    driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).click();
		    boolean isSelected = driver.findElement(By.xpath("//td[contains(text(),'Cat')]/../td/input")).isSelected();
		    logger.debug("Taking result from checkbox //td[contains(text(),'Cat')]/../td/input element after deselecting. Result is: " + isSelected);
		    assertEquals(false, isSelected);
	  } 
*/	  
	  
	  
	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }


    
    

}
