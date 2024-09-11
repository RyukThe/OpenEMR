package OMRHospitalLoginTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OMRHospitalLogin.OMRHospitalLoginPage;

public class OMRHospitalLoginTest extends BaseClass
{
	int TestCaseId;
	OMRHospitalLoginPage login;
	
	
	@Test(dataProvider = "Dataprovider",description = "Saurav Kasture")
	public void verification_of_loginPage_for_Multiple_Role(String userName, String Password) throws IOException, InterruptedException
	{
		TestCaseId=6;
		openBrowserHospital();
		login= new OMRHospitalLoginPage(driver);
		login.inpOMRHospitalLoginPageUserName(userName);
		login.inpOMRHospitalLoginPagePassword(Password);
		login.clickOMRHospitalLoginPageloginButton();
		Thread.sleep(3000);
	
		driver.close();
		
	}
	
	
	
	@DataProvider
	public String[][] Dataprovider() throws IOException
	{
		String [][] data= {{UtilityClass.getPropertyFileData("username"),UtilityClass.getPropertyFileData("password")},{UtilityClass.getPropertyFileData("username1"),
			UtilityClass.getPropertyFileData("password1")},
		{UtilityClass.getPropertyFileData("username2"),UtilityClass.getPropertyFileData("password2")},
		{UtilityClass.getPropertyFileData("username3"),UtilityClass.getPropertyFileData("password3")},
		{UtilityClass.getPropertyFileData("username4"),UtilityClass.getPropertyFileData("password4")}
		};
		
		return data;
	}

}
