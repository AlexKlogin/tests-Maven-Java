package STTA.OnlyTestingBlog.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectablePage {
	
	WebDriver driver;

    @FindBy(xpath="//ol/li")
    private List<WebElement> selectableItems;    

    
    public SelectablePage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        //System.out.println(selectableItems.getClass().getSimpleName());
       System.out.println(selectableItems.toArray(new WebElement[selectableItems.size()]).toString());
    }   
    
    public void selectItems(int first_group_item, int last_group_item ) {
    	Actions toSelect = new Actions(driver);
        toSelect.clickAndHold(selectableItems.get(first_group_item)).clickAndHold(selectableItems.get(last_group_item)).click();

        //Perform action.
        Action selectItems = toSelect.build();
        selectItems.perform();
        
	   // String itemColor = selectableItems.get(2).getCssValue("background-color");
	    //logger.debug("Items are selected");
    }
    
	  public boolean isGroupSelected(int first_group_item, int last_group_item ) {
		  
		  for (int i=0;i<selectableItems.size();i++) {
			  //System.out.println(selectableItems.get(i).getCssValue("background-color"));
			  if ( ((i > last_group_item ||  i< first_group_item) && selectableItems.get(i).getCssValue("background-color") == "rgb(243, 152, 20)")
				  || ( ((i <= last_group_item &&  i>= first_group_item) && selectableItems.get(i).getCssValue("background-color") == "rgb(255, 255, 255)")))
				  return false;
		  }
		  return true;
	  }
    


}
