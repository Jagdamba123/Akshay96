package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

import testUtility.Screenshot;
import testUtility.Staticbrowser;

public class BaseClass {
	static WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger;
	@Parameters ({"browser"})
	
	@BeforeTest
	public void beforeTest(String browser)
	{
		WebDriver driver=Staticbrowser.openbrowser(browser, "https://onboarding.usbank.com/consumer/loans-and-lines/uns/nsdcf/login");
		this.driver=driver;
		report=new ExtentReports();
		extent =new ExtentHtmlReporter("test-output\\Reports\\"+System.currentTimeMillis()+".html");
		report.attachReporter(extent);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String path=Screenshot.screenshotus(driver);
			logger.fail("This test is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
	}
	@AfterTest
	public void AfterTest()
	{
		driver.quit();
	}

	

}

