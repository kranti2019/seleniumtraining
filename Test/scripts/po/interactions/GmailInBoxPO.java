package scripts.po.interactions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;

public class GmailInBoxPO extends LoadableComponent<GmailInBoxPO>
{
	   private WebDriver driver;
       private String expectedTitle = "My Account";

	@FindBy (xpath = "//div[contains(@gh,'cm')]")
    private WebElement composeLink;
	
	@FindBy (name = "to")
    private WebElement toField;
	
	@FindBy (xpath = "//input[@name='subjectbox']")
    private WebElement subjectbox;
	
	@FindBy (xpath= "//div[@aria-label='Message Body']")
    private WebElement meassagebody;
	
	@FindBy (xpath= "//div[@aria-label='Send ‪(Ctrl-Enter)‬']")
    private WebElement sendbutton;
	
	
	@FindBy (xpath= "//span[contains(@class,'gb_ya gbii')]")
    private WebElement menuclick;
	
	@FindBy (xpath= "//a[contains(.,'Sign out')]")
    private WebElement signoutClick;
	
	
	public GmailInBoxPO(WebDriver driver) 
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
         
    }
	  
	public GmailInBoxPO Composemail(String To,String Subject,String Message) throws InterruptedException
	    {
		  Thread.sleep(10000);
		  composeLink.click();
		  Thread.sleep(10000);
		  toField.sendKeys(To);
		  Thread.sleep(10000);
		  subjectbox.sendKeys(Subject);
		  Thread.sleep(10000);
		  meassagebody.sendKeys(Message);
		  Thread.sleep(10000);
		  sendbutton.click();
		  GmailInBoxPO gmailinboxpo=new  GmailInBoxPO(driver);
	      return gmailinboxpo;
		  	  
				  
	    }
	  public GmailLoginPO getSignOut1() throws InterruptedException
	    {
		  
		  System.out.println("))))))))))))))))))))))");
		  Thread.sleep(10000);
		  menuclick.click();
		  Thread.sleep(10000);
		  signoutClick.click();
		  return new GmailLoginPO(driver);
	    }
	  
	  public void close() {
	        // TODO Auto-generated method stub
	        driver.quit();
	    }
	
	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),expectedTitle );
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
