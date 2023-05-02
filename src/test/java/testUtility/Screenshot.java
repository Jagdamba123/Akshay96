package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static String screenshotus(WebDriver driver) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\test-output\\Screenshot\\"+System.currentTimeMillis()+".png";
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destiny=new File(path);
		FileHandler.copy(source, destiny);
		return path;
		}

}
