package scripts.po.interactions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Contactus extends LoadableComponent<Contactus>

{
	private String expectedTitle = "Contact us";
	@FindBy (className = "glyphicon glyphicon-search")

	 @CacheLookup
    private WebElement searchicon;
	private WebDriver driver;
	private String mywindowhandler;
	 public Contactus (WebDriver driver,String windowhandle) 
	    {
	        this.driver=driver;
	        this.mywindowhandler=windowhandle;
	        PageFactory.initElements(driver, this);
	         
	    }
	 public Contactus serachLocation(String searchstring)
	 {
		 searchicon.click();
		 try
		 {
		 Alert alert=driver.switchTo().alert();
		 alert.sendKeys(searchstring);
		 alert.accept();
		 }
		 catch(NoAlertPresentException e)
		 {
			 fail("No alert found");
		 }
		 return this;
		 
	 }
	 public  MyAccountPO closeContactus()
	 {
		 driver.close();
		 driver.switchTo().window(mywindowhandler);
		 return new  MyAccountPO(driver);
	 }
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(),expectedTitle );
	}
	 }
	 
	 


