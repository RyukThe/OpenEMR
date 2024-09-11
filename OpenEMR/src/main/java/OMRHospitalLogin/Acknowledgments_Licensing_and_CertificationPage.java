package OMRHospitalLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Acknowledgments_Licensing_and_CertificationPage 
{
	@FindBy(xpath = "//h1") private WebElement Title;
	
	public Acknowledgments_Licensing_and_CertificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyAcknowledgments_Licensing_and_CertificationPageTitle() 
	{
		boolean ActualResult = Title.isDisplayed();
		return ActualResult;
		
	}
	
	public String VerifyAcknowledgments_Licensing_and_CertificationPageTextPresntOnTitle()
	{
		String actualResult = Title.getText();
		return actualResult;
	}
	
}
