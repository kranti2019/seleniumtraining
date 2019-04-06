package scripts.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgConfig1 
{
  @Test
  public void test1() 
  {
	  System.out.println( "inside test1 of TestNgConfig1 ");
  }
  @Test
  public void test2() 
  {
	  System.out.println( "inside test2 of TestNgConfig1 ");
  }
  @Test
  public void test3()
  {
	  System.out.println( "inside test3 of TestNgConfig1 ");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println( "inside beforemethod of TestNgConfig1 ");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println( "inside afterMethod of TestNgConfig1 ");
  }

  @BeforeClass
  public void beforeClass()
  {
	  System.out.println( "inside beforeClass of TestNgConfig1 ");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println( "inside afterClass of TestNgConfig1 ");
  }

  @BeforeTest
  public void beforeTest()
  {
	  System.out.println( "inside beforeTest of TestNgConfig1 ");
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println( "inside afterTest of TestNgConfig1 ");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println( "inside beforeSuite of TestNgConfig1 ");
  }

  @AfterSuite
  public void afterSuite()
  {
	  System.out.println( "inside afterSuite of TestNgConfig1 ");
  }

}
