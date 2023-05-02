package testPackage;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.LoginPage;

public class TestClass extends BaseClass  {
	LoginPage login;
	SoftAssert Check;
	
	@BeforeClass
	public void beforeclass()
	{
		Check= new SoftAssert();
		login= new LoginPage(driver);
	}
	@Test(priority=1)
	public void heading1()
	{
		logger=report.createTest("Verify Personal Loan Heading");
		String EText="Personal load";
		String AText=login.headingPL();
		Check.assertEquals(EText, AText);
		Check.assertAll();
	}
	@Test(priority=2)
	public void description()
	{
		logger=report.createTest("Verify Description");
		String descriptione="If you'r a current U.S. Bank customer, start by using your login credentials to streamline the application process.";
		String descriptiona=login.descriptionlogin();
		Check.assertEquals(descriptione, descriptiona);
		Check.assertAll();
	}
	@Test(priority=3)
	public void username1()
	{
		logger=report.createTest("Verify Username");
		login.username("Akshay");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	

}
