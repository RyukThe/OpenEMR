package ReceptionistModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class PatientSearchPage 
{
	@FindBy(xpath = "//iframe[@name='findPatient']") private WebElement iframe;
	@FindBy(xpath = "//h5[@class='modal-title']") private WebElement titleofpage;
	@FindBy(xpath = "//select[@name='searchby']") private WebElement selectsearchBy;
	@FindBy(xpath = "//input[@id='searchparm']") private WebElement inpsearchphram;
	@FindBy(xpath="//input[@id='submitbtn']") private WebElement searchbutton;
	@FindBy(xpath = "//div[@id='searchstatus']") private WebElement success_error_msg;
	@FindBy(xpath = "//table[@class='table table-sm']/tbody[@id='searchResults']/tr") private WebElement listofpaitnet;
	
	public PatientSearchPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void switchToFrame(WebDriver driver)
	{
		UtilityClass.switchToIFrame(driver, iframe);
	}
	public String verify_Title_Of_Patient_SearchPage()
	{
		 return titleofpage.getText();
	}
	
	public void selectSerachByOption_of_Patinet_SearchPage(String text )
	{
		UtilityClass.selectoptionsbyvisibleText(selectsearchBy, text);
	}
	
	public void  inpserachFor(String value)
	{
		inpsearchphram.sendKeys(value);
	}
	 
	public void clickonSerachbutton()
	{
		searchbutton.click();
	}
	
	
	public String verifySuccess_Or_ErrorMessage()
	{
		return success_error_msg.getText();
		
	}
	
	
	public void selectPatientFromList(WebDriver driver,String text)
	{
		List<WebElement> patinetList = driver.findElements(By.xpath("//table[@class='table table-sm']/tbody[@id='searchResults']/tr"));
		
		for(WebElement patinet:patinetList)
		{
	
			if(patinet.getText().contains(text))
			{
				patinet.click();
				break;
			
			}
			else
			{
				patinet.click();
				break;
			}
		
			
		
	}
	
	
	}
	
}
