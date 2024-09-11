package ReceptionistModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_or_Search_Patient 
{
	@FindBy(xpath = "//h2[text()='Search or Add Patient']") private WebElement Title_of_Page;
	@FindBy(xpath = "//div[text()='Title:']") private WebElement titleLabel;
	@FindBy(xpath = "//select[@id='form_title']") private WebElement selectTitle;
	@FindBy(xpath = "//div[text()='Name:']") private WebElement nameLable;
	@FindBy(xpath = "//input[@id='form_fname']") private WebElement FirstnameInp;
	@FindBy(xpath = "//input[@id='form_mname']") private WebElement mNameinp;
	@FindBy(xpath = "//input[@id='form_lname']") private WebElement lnameinp;
	@FindBy(xpath = "//input[@id='form_suffix']") private WebElement namesufix;
	@FindBy(xpath = "//div[text()='External ID:']") private WebElement externalIDLabel;
	@FindBy(xpath = "//input[@id='form_pubpid']") private WebElement externalIdinp;
	@FindBy(xpath = "//div[text()='DOB:']") private WebElement DOBLable;
	@FindBy(xpath = "//input[@id='form_DOB']") private WebElement DOBinp;
	@FindBy(xpath = "//div[text()='Sex:']") private WebElement sexlable;
	@FindBy(xpath = "//select[@title='Sex']") private WebElement selectSex;
	@FindBy(xpath = "//div[text()='S.S.:']") private WebElement SSLabel;
	@FindBy(xpath = "//input[@id='form_ss']") private WebElement SSinp;
	@FindBy(xpath = "//div[text()='License/ID:']") private WebElement License_IDlabel;
	@FindBy(xpath = "//input[@id='form_drivers_license']") private WebElement license_IDinp;
	@FindBy(xpath = "//div[text()='Marital Status:']") private WebElement maritalStatusLabel;
	@FindBy(xpath = "//select[@id='form_status']") private WebElement selectMaritalStatus;
	@FindBy(xpath = "//div[text()='User Defined:']") private WebElement userDefinedlabel;
	@FindBy(xpath = "//input[@id='form_genericname1']") private WebElement userDefindeinp1;
	@FindBy(xpath = "//input[@id='form_genericval1']") private WebElement userDefinedinp2;
	@FindBy(xpath = "//input[@id='form_genericname2']") private WebElement userDefinedinp3;
	@FindBy(xpath = "//input[@id='form_genericval2']") private WebElement userDefindinp4;
	@FindBy(xpath = "//div[text()='Billing Note:']") private WebElement billingNoteLabel;
	@FindBy(xpath = "//input[@id='form_billing_note']") private WebElement billingIdinp;
	@FindBy(xpath = "(//div[@id='label_gender_identity'])[1]") private WebElement genderIndetityLabel;
	@FindBy(xpath = "//select[@id='form_gender_identity']") private WebElement selectGenderIdentity;
	@FindBy(xpath = "//div[@id='label_sexual_orientation']") private WebElement sexualOrientationLabel;
	@FindBy(xpath = "//select[@id='form_sexual_orientation']") private WebElement selectSexualOrientation;
	@FindBy(xpath = "//div[@id='label_birth_fname']") private WebElement birthnameLabel;
	@FindBy(xpath = "//input[@id='form_birth_fname']") private WebElement bithnameFistNameinp;
	@FindBy(xpath = "//input[@id='form_birth_mname']") private WebElement birthmnameinp;
	@FindBy(xpath = "//input[@id='form_birth_lname']") private WebElement birthlnameinp;
	@FindBy(xpath = "//button[@id='create']") private WebElement cretepatintButton;
	@FindBy(xpath = "//button[@id='search']") private WebElement searchButton;
	
	
	public Add_or_Search_Patient(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
  
}
