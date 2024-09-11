package LibraryFiles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManegar implements ITestListener
{
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public String name; 

	@Override
	public void onTestStart(ITestResult result)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		name="Extent-Report"+timestamp;
		spark= new ExtentSparkReporter("D:\\eclipse\\OpenEMR\\FailedTestCasesSS\\"+name);
		extent= new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("OpenEMR");
		spark.config().setTheme(Theme.DARK);
		
		new BaseClass();
		Capabilities cmp = ((RemoteWebDriver)BaseClass.driver).getCapabilities();
		
		extent.setSystemInfo("Browser Name",cmp.getBrowserName() );
		extent.setSystemInfo("Browser Version", cmp.getBrowserVersion());
		extent.setSystemInfo("Operating Systme", System.getProperty("os.name"));
		extent.setSystemInfo("Java version", System.getProperty("java.version"));
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		 String authorName = result.getMethod().getDescription(); 
		test= extent.createTest(result.getName());
		test.assignAuthor(authorName);
		test.assignDevice("Windows 10");
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Hurray!!! Test Cases Pass");
		

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Ohh No!!! Test Case Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		 try {
			String imagepath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Cases Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	
	}



	

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	
	}

}
