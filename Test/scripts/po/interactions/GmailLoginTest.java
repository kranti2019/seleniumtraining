package scripts.po.interactions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class GmailLoginTest
{
	GmailLoginPO gmailpo;
	
	GmailInBoxPO gi1;
	 private WebDriver driver;
	 
  @Test
  public void gmailtest() 
  {

		try {
			gmailpo.logindetails("kranti.patil8@gmail.com", "kranti@2020").
			Composemail("kranti.patil8@gmail.com", " Hi  I am Kranti", "I have done my assignment.").
			getSignOut1();
			/*gi1=new GmailInBoxPO(driver);
			gi1.getSignOut1();
			*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	       
	      //assertEquals(gmailpo.getTitle(),"Google Account");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  gmailpo = new GmailLoginPO();
	  gmailpo.get();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  //gmailpo.close();
  }

}
