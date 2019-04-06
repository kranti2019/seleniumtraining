package scripts.po.interactions;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class NicheLoginTest1
{
	  NicheLoginPO1 myLogin1;
	  MyAccountPO myaccount;
	  
//	  @Test
//	  public void nicheLoginTest() throws InterruptedException 
//	  {
////		  myaccount=myLogin1.login1("stc123", "12345"); 
////		  myaccount.getContactUs();
//		  myLogin1.login1("stc123", "12345").
//		  getContactUs().
//		  getSignOut().
//		  login1("stc123", "12345");
//		  Thread.sleep(10000);
//	  }
	  @Test
	  public void nicheLoginTest() throws InterruptedException 
	  {
//		  myaccount=myLogin1.login1("stc123", "12345"); 
//		  myaccount.getContactUs();
		  myLogin1.login1("stc123", "12345").
		  getContactUs().
		  serachLocation("Australia").closeContactus().getSignOut();
		  
		  
		  Thread.sleep(10000);
	  }
	  @BeforeMethod
	  public void beforeMethod()
	  {
	      myLogin1 = new NicheLoginPO1();
	      myLogin1.get();
//	      myaccount= new MyAccountPO(null);
//	      myaccount.get();
	  }
	 
	  @AfterMethod
	  public void afterMethod() 
	  {
	      myLogin1.close();
	  }
	 
	}
