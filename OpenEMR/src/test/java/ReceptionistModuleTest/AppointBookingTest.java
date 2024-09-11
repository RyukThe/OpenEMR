package ReceptionistModuleTest;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import static LibraryFiles.UtilityClass.getPropertyFileData;
import OMRHospitalLogin.OMRHospitalLoginPage;
import ReceptionistModule.HomePage;



public class AppointBookingTest extends BaseClass
{
	OMRHospitalLoginPage login;
	HomePage home;
	int TestCase;
	
	@BeforeClass
	public void OpenApplication() throws IOException
	{
		openBrowserHospital();
		login = new  OMRHospitalLoginPage(driver);
		home= new HomePage(driver);
		
		
	}
	
	@BeforeMethod
	public void loginintoApplication() throws IOException
	{
		login.inpOMRHospitalLoginPageUserName(getPropertyFileData("username4"));
		login.inpOMRHospitalLoginPagePassword(getPropertyFileData("password4"));
		login.clickOMRHospitalLoginPageloginButton();
	}
	
	@Test
	public void appointment_scheduling()
	{
	home.switchToIframeCalender(driver);
	home.clickonMonth();
	home.seletMonth(driver);
	home.selectDate(driver);
	home.selectTimeSlot(driver);
		
		
		
	}
	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(3000);
	closeBroswer();
	}
	
	
	
}
