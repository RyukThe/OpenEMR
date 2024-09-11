package LibraryFiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass
{
	public ChromeOptions op;
	public static WebDriver driver;
	public Logger log;
	
	public void openBrowserHospital() throws IOException
	{
		op= new ChromeOptions();

		op.addArguments("--remote-allow-origins=*");
		driver=new  ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		log=LogManager.getLogger(this.getClass());
		log.debug("debugging........");
	}
	public void openBrowserHospitalPatient() throws IOException
	{
		op= new ChromeOptions();

		op.addArguments("--remote-allow-origins=*");
		driver=new  ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URLPatient"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void openBrowserHospital(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			op=  new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(op);
		}
		else if (BrowserName.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void openBrowserPatient(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			op=  new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(op);
		}
		else if (BrowserName.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URLPatient"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String des="D:\\eclipse\\OpenEMR\\Screenshot\\"+tname+"_"+timeStamp+".png";
		
		FileHandler.copy(src, new File(des));
		return des;
	}
	
	public void closeBroswer()
	{
		driver.close();
	}
}
