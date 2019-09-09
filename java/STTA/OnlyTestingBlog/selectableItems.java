package STTA.OnlyTestingBlog;

import static org.testng.Assert.assertEquals;


import java.util.List;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import STTA.OnlyTestingBlog.Pages.SelectablePage;
import utilities.TestNGListener;


@Listeners(TestNGListener.class)
public class selectableItems extends SuiteBase{

	//List<WebElement> selectableItems;
	SelectablePage selectablePage;
	
	  @BeforeClass
	  public void beginWith() {
		   driver.get(basicURL);
		   driver.findElement(By.xpath(".//a[contains(text(),'Selectable')]")).click();
		   selectablePage = new SelectablePage(driver);
		  }
	  
 	  
	  @Test
	  public void selectListGroupTest() throws InterruptedException {
		    selectablePage.selectItems(2,6);
            logger.debug("Items are selected");
		    assertEquals(selectablePage.isGroupSelected(2,6), true);
	  }
	  
	  @AfterClass
	  public void endWith() {
		   driver.quit();
	  }


	  
}
