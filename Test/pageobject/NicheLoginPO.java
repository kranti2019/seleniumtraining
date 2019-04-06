package pageobject;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import scripts.po.interactions.MyAccountPO;

public class NicheLoginPO extends LoadableComponent<NicheLoginPO>
{
	 @FindBy (id = "loginname")
	    @CacheLookup
	    private WebElement username;
	    //private WebElement username = driver.findElement(By.id("loginname"));
	    @FindBy (id = "loginpassword")
	    private WebElement userpass;
	     
	    @FindBy (id = "loginbutton")
	    private WebElement loginButton;
	     
	    @FindBy (tagName = "a")
	    private List<WebElement> allTags; 
	     
	    private WebDriver driver;
	    private Object expectedTitle = "STC Tourism";
	     
	    public NicheLoginPO() {
	        System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
	        driver = new FirefoxDriver();
	        PageFactory.initElements(driver, this);
	         
	    }
	     
	    public void login(String user, String pass)
	    {
	        username.clear();
	        username.sendKeys(user);
	        userpass.sendKeys(pass);
	        loginButton.click();
	     
	    }
	    
	     
	   
	    
	    public String getTitle() {
	        return driver.getTitle();
	    }
	 
	    public void close() {
	        // TODO Auto-generated method stub
	        driver.quit();
	    }
	 
	    @Override
	    protected void load() {
	        // TODO Auto-generated method stub
	        driver.get("http://selenium-examples.nichethyself.com/");
	    }
	 
	    @Override
	    protected void isLoaded() throws Error {
	        // TODO Auto-generated method stub
	        assertEquals(driver.getTitle(),expectedTitle );
	         
	    }
	     
	}