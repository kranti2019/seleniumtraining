package pageobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class GmailLoginTest
{
	GmailLoginPO gmailpo;
	
  @Test
  public void f() 
  {

		try {
			gmailpo.loginusername("kranti.patil8@gmail.com");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			gmailpo.loginpassword("kranti@2020");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	       
	      assertEquals(gmailpo.getTitle(),"Google Account");
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
