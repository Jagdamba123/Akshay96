package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.auto.common.Visibility;


public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	//personal loan Heading
	@FindBy(xpath="//p[text()='Personal loan']")
	private WebElement personalLoanHeading;
	//personal loan description
	@FindBy (xpath="//*[@id='Log-in.']")
	private WebElement logInDescription;
	//username functionality
	@FindBy (xpath="//input[@name='Username']")
	private WebElement username;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	public String headingPL()
	{
		String a=personalLoanHeading.getText();
		System.out.println(a);
		return a;
	}
	public String descriptionlogin()
	{
		String a=logInDescription.getText();
		System.out.println(a);
		return a;
		
	}
	public void username(String Username)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='Username']")));
		username.sendKeys("Username");
	}
	

}
