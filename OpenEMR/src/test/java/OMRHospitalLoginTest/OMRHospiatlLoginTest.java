package OMRHospitalLoginTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OMRHospitalLogin.OMRHospitalLoginPage;

public class OMRHospiatlLoginTest extends BaseClass
{
	
	
	OMRHospitalLoginPage loginPage;
	int TestCaseId;
	
	@BeforeClass
	public void OpenBrowser() throws IOException
	{
		openBrowserHospital();
		loginPage=new OMRHospitalLoginPage(driver);
	}
	
	@Test
	public void verificationOfLoginPage() throws IOException
	{
		TestCaseId=1;
		
		boolean actRetult = loginPage.verifyOMRHospitalLoginPageLogo();
		Assert.assertTrue(actRetult);
		
		
	}
	
	@Test 
	public void verifiaction_of_TageLine_Of_LoginPage() throws EncryptedDocumentException, IOException
	{
		TestCaseId=2;
		String actResult = loginPage.verifyOMRHospitalLoginPageTagLine();
		Assert.assertEquals(actResult, UtilityClass.getExcelData(1, 0));
		
	}
	
	@Test
	public void verification_OF_UserName_Lable() throws EncryptedDocumentException, IOException
	{
		TestCaseId=3;
		
		Assert.assertEquals(loginPage.verifyOMRHospitalLoginPageUserNameLabel(), UtilityClass.getExcelData(1, 1));
	}
	
	@Test
	public void verification_OF_Password_Label() throws EncryptedDocumentException, IOException
	{
		TestCaseId=4;
		Assert.assertEquals(loginPage.verifyOMRHospitalLoginPagePasswordLabel(), UtilityClass.getExcelData(2, 1));
	}
	
	@Test
	public void verification_of_all_languagesPresent()
	{
		TestCaseId=5;
		List<String> langaues = loginPage.selectOMRHospitalLoginPageLangauge();
		for(String lang:langaues)
		{
			Reporter.log(lang,true);
		}
	}
	@AfterMethod
	public void getScreenShotOfFailedTestCase(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.getScrenshot(driver, TestCaseId);
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
