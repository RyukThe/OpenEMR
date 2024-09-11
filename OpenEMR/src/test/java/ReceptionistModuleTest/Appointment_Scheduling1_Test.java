package ReceptionistModuleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;

import static LibraryFiles.UtilityClass.getExcelData;
import static LibraryFiles.UtilityClass.getExcelData;

import OMRHospitalLogin.Acknowledgments_Licensing_and_CertificationPage;
import OMRHospitalLogin.OMRHospitalLoginPage;
import ReceptionistModule.HomePage;
import ReceptionistModule.PatientSearchPage;
import ReceptionistModule.Patient_Or_ProviderAppointmentPage;

public class Appointment_Scheduling1_Test extends BaseClass
{

	
	
	String  TestCaseId;
	OMRHospitalLoginPage login;
	Acknowledgments_Licensing_and_CertificationPage ALC;
	HomePage home;
Patient_Or_ProviderAppointmentPage pop;
	PatientSearchPage psp;
	SoftAssert sft;
	
	
	@BeforeClass
	public void OpenApplication() throws IOException
	{
		openBrowserHospital();
		log.info(" ************ Application open **************");
		login = new OMRHospitalLoginPage(driver);
		ALC= new Acknowledgments_Licensing_and_CertificationPage(driver);
		home= new HomePage(driver);
		pop= new Patient_Or_ProviderAppointmentPage(driver);
		psp= new PatientSearchPage(driver);
		sft= new SoftAssert();
		
	}
	
	
	@BeforeClass
	public void login_to_OpenEMR_Application() throws IOException
	{
		log.info("*********** login in Application *************");
		login.inpOMRHospitalLoginPageUserName(UtilityClass.getPropertyFileData("username4"));
		login.inpOMRHospitalLoginPagePassword(UtilityClass.getPropertyFileData("password4"));
		
		sft.assertEquals(getExcelData(1, 0), login.verifyOMRHospitalLoginPageTagLine());
		log.info("********** verify tagline of OpenEMR ***************");
		
		
		login.clickOMRHospitalLoginPageloginButton();
	}
	
	
	@Test(description = "Saurav Kasture")
	public void verify_Appointmnet_Scheduling_of_patinet_by_Passing_all_valid_information() throws EncryptedDocumentException, IOException
	{
		log.info("********* Test Case Execution started ******************");
		TestCaseId="OpenEMR-TC003";
		home.switchToIframeCalender(driver);
		log.info("********* Switch to iframe ");
		home.clickonMonth();
		home.seletMonth(driver);
		home.selectDate(driver);
		home.selectTimeSlot(driver);
		driver.switchTo().defaultContent();
		pop.switchToiframe(driver);
		
		pop.selectCategory(getExcelData("Appointmnet Scheduling", 13, 5));
		pop.selectFacility(0);
		pop.selectBillinFacility(0);
		pop.clickselectPatient();
		driver.switchTo().defaultContent();
		System.out.println(psp.verify_Title_Of_Patient_SearchPage());
		psp.switchToFrame(driver);
		

		psp.selectSerachByOption_of_Patinet_SearchPage(getExcelData("Appointmnet Scheduling", 15, 5));
		psp.inpserachFor(getExcelData("Appointmnet Scheduling", 16, 5));
		psp.clickonSerachbutton();
		psp.selectPatientFromList(driver,getExcelData("Appointmnet Scheduling", 18, 5));
		driver.switchTo().defaultContent();
		pop.switchToiframe(driver);
		pop.clickOnAllDay();
		pop.click_on_Time_radio_button();
		pop.inpHour_in_time_input();
		pop.inpmin_in_time_input();
		pop.selectStatus(getExcelData("Appointmnet Scheduling", 22, 5));
		pop.selectRoom(getExcelData("Appointmnet Scheduling", 23, 5));
		pop.inpComment(getExcelData("Appointmnet Scheduling", 24, 5));
		pop.click_on_Savebutton();
		
		
		home.overMouseonProfileDropDown(driver);
		home.clickOnLogOutButton(driver);
		
		log.info("*********  Test Execution completed  ********");
		
		
		
	}
	
	
	@AfterClass
	public void close_Broswer()
	{
		closeBroswer();
	}
	
	
	
	
}
