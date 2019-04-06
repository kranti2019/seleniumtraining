package scripts.po.interactions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GmailLoginPO extends LoadableComponent<GmailLoginPO>
{

	 WebDriverWait wait;
	@FindBy (name = "identifier")
    @CacheLookup
    private WebElement username;
    //private WebElement username = driver.findElement(By.id("loginname"));
	//@FindBy (name = "Next")
	@FindBy (xpath="//span[contains(.,'Next')]")
	private WebElement nextbutton;

    @FindBy (xpath="//input[@name='password']")
    private WebElement userpass;
     
    private WebDriver driver;
    private Object expectedTitle = "Sign in – Google accounts";
    public GmailLoginPO() 
    {
    
        System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
        driver = new FirefoxDriver();
       //wait= new WebDriverWait(driver,60,250);
        PageFactory.initElements(driver, this);
    }
         
    public GmailLoginPO(WebDriver driver) 
    {
       this.driver=driver;
       PageFactory.initElements(driver, this);
    }
     
     
//    public void loginusername(String user) throws InterruptedException
//    {
//        username.clear();
//        username.sendKeys(user);
//        Thread.sleep(10000);
//        nextbutton.click();
//		
//    }
//    public void loginpassword( String pass) throws InterruptedException
//    {
//    	Thread.sleep(10000);
//        userpass.sendKeys(pass);
//        Thread.sleep(10000);
//        nextbutton.click();
//        driver.get("https://mail.google.com/mail/u/0/?tab=km#inbox");
//		
//    }
     
   
    public  GmailInBoxPO  logindetails(String user, String pass) throws InterruptedException
  {
    	username.clear();
      username.sendKeys(user);
      Thread.sleep(10000);
      nextbutton.click();
  	Thread.sleep(10000);
      userpass.sendKeys(pass);
      Thread.sleep(10000);
      nextbutton.click();
      driver.get("https://mail.google.com/mail/u/0/?tab=km#inbox");
      GmailInBoxPO gmailinboxpo=new  GmailInBoxPO(driver);
      return gmailinboxpo;
		
	     
    
  }
   
    public String getTitle() 
    {
        return driver.getTitle();
    }
 
    public void close()
    {
        // TODO Auto-generated method stub
        driver.quit();
    }
 
    @Override
    protected void load() {
        // TODO Auto-generated method stub
        driver.get("https://accounts.google.com/");
    }
 
    @Override
    protected void isLoaded() throws Error {
        // TODO Auto-generated method stub
        assertEquals(driver.getTitle(),expectedTitle );
         
    }
     
}


