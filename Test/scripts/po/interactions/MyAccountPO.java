package scripts.po.interactions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MyAccountPO extends LoadableComponent<MyAccountPO>
{
	@FindBy (className = "link")
    @CacheLookup
    private WebElement contactUsLink;
	
	@FindBy (className = "glyphicon-user")
    private WebElement signOutLink;
	private WebDriver driver;
	private String expectedTitle = "My Account";
	  public MyAccountPO(WebDriver driver) 
	    {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	         
	    }
	  public Contactus getContactUs()
	    {
		  contactUsLink.click();
		  String windowhandle=driver.getWindowHandle();
		  driver.switchTo().window("Contact");
		  Contactus  c1=new Contactus(driver,windowhandle);
		  return c1;
	    }
	  public NicheLoginPO1 getSignOut()
	    {
		  signOutLink.click();
		  return new NicheLoginPO1(driver);
	    }
	  public void close() {
	        // TODO Auto-generated method stub
	        driver.quit();
	    }
	@Override
	protected void isLoaded() throws Error
	{
		 assertEquals(driver.getTitle(),expectedTitle );
		
	}

	@Override
	protected void load() 
	{
		//driver.get("http://selenium-examples.nichethyself.com/");
		
	}

}
