package OMRHospitalLogin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OMRHospitalLoginPage 
{
	@FindBy(xpath = "//div[@class='mx-auto m-4 w-75']") private WebElement OpenEMRLogo;
	@FindBy(xpath = "//p") private WebElement TagLine;
	@FindBy(xpath = "//a") private WebElement Acknowledgments_Licensing_CertificationHyperLink;
	@FindBy(xpath = "//label[1]") private WebElement UsernameLable;
	@FindBy(xpath = "//input[@placeholder='Username']") private WebElement UserNameInp;
	@FindBy(xpath = "(//label)[2]") private WebElement PasswordLabel;
	@FindBy(xpath = "//input[@placeholder='Password']") private WebElement PasswordInp;
	@FindBy(xpath = "(//label)[3]") private WebElement LanguangeLabel;
	@FindBy(xpath = "//select") private WebElement SelectLangague;
	@FindBy(xpath = "//button[@id='login-button']") private WebElement LoginButton;
	
	public OMRHospitalLoginPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyOMRHospitalLoginPageLogo()
	{
		boolean actualResult = OpenEMRLogo.isDisplayed();
		return actualResult;
	}
	
	public String verifyOMRHospitalLoginPageTagLine()
	{
		String actualResult = TagLine.getText();
		return actualResult;
	}
	
	public String verifyOMRHospitalLoginPageAcknowledgments_Licensing_CertificationHyperLink()
	{
		String linktext=Acknowledgments_Licensing_CertificationHyperLink.getText();
		Acknowledgments_Licensing_CertificationHyperLink.click();
		return linktext;
	}
	
	public String verifyOMRHospitalLoginPageUserNameLabel()
	{
		String actualResult = UsernameLable.getText();
	
		return actualResult;
	}
	
	public void inpOMRHospitalLoginPageUserName(String userName)
	{
		UserNameInp.sendKeys( userName);
	}
	
	public String verifyOMRHospitalLoginPagePasswordLabel()
	{
		String actResult = PasswordLabel.getText();
		return actResult;
	}
	
	public void inpOMRHospitalLoginPagePassword(String password)
	{
		PasswordInp.sendKeys(password);
	}
	
	public String verifyOMRHospitalLoginPageLangaunageLabel()
	{
		String actResult=LanguangeLabel.getText();
		return actResult;
	}
	
	public List<String> selectOMRHospitalLoginPageLangauge()
	{
		Select sl= new Select(SelectLangague);
		sl.selectByIndex(1);;
		List<WebElement> alloptions = sl.getOptions();
		
		List <String> allLangauges= new ArrayList<String>();
		
		for(WebElement language: alloptions)
		{
			String lang = language.getText();
			allLangauges.add(lang);
			
		}
		return allLangauges;
		
		
		
	}
	
	public void clickOMRHospitalLoginPageloginButton()
	{
		LoginButton.click();
	}
}
