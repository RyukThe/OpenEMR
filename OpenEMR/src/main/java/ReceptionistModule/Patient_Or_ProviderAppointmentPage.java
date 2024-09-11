package ReceptionistModule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class Patient_Or_ProviderAppointmentPage 
{
	@FindBy(xpath ="//iframe[@id='modalframe']") private WebElement iframe;
	@FindBy(id ="form_category" ) private WebElement selectformCategory;
	@FindBy(id="facility") private WebElement selectFacility;
	@FindBy(id="billing_facility") private WebElement selectBillingfacility;
	@FindBy(id="form_patient") private WebElement selectpatient;
	@FindBy(id = "provd") private WebElement selectProvider;
	@FindBy(xpath = "(//input[@name='form_allday'])[1]")private WebElement alldayradiobutton;
	@FindBy(xpath = "//input[@id='form_date']") private WebElement calenderinput;
	@FindBy(xpath = "(//div[@class='xdsoft_label xdsoft_month'])[2]") private WebElement Month;
	@FindBy(xpath = "(//div[@class='xdsoft_select xdsoft_monthselect xdsoft_scroller_box'])[2]") private WebElement selectMonth;
	@FindBy(xpath = "(//div[@class='xdsoft_label xdsoft_year'])[2]") private  WebElement year;
	@FindBy(xpath = "(//div[@class='xdsoft_select xdsoft_yearselect xdsoft_scroller_box'])[2]")private WebElement selectYear;
	@FindBy(xpath = "(//div[@class='xdsoft_calendar'])[2]//td") private WebElement selectdate;
	@FindBy(xpath = "//input[@id='rballday2']") private WebElement timeradiobutton;
	@FindBy(xpath = "//input[@name='form_hour']") private WebElement hourinp;
	@FindBy(xpath = "//input[@name='form_minute']") private WebElement minuteinp;
	@FindBy(xpath = "//select[@id='form_apptstatus']") private WebElement selectStatus;
	@FindBy(xpath = "//select[@id='form_room']") private WebElement SelectRoom;
	@FindBy(xpath = "//input[@name='form_comments']") private WebElement inpComment;
	@FindBy(xpath = "//input[@value='Save']") private WebElement savebutton;
	
	public Patient_Or_ProviderAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void switchToiframe(WebDriver driver)
	{
		UtilityClass.switchToIFrame(driver, iframe);
	}
	public void selectCategory(String text)
	{
		UtilityClass.selectoptionsbyvisibleText(selectformCategory, text);
	}
	
	public void selectFacility(int index)
	{
		UtilityClass.selectoptionsbyIndex(selectFacility, index);
	}
	
	public void selectBillinFacility(int index)
	{
		UtilityClass.selectoptionsbyIndex(selectBillingfacility, index);
	}
	
	public void clickselectPatient()
	{
		selectpatient.click();
	}
	public void select_Provider(int provider)
	{
		UtilityClass.selectoptionsbyIndex(selectProvider, provider);
	}
	
	public void clickOnAllDay()
	{
		alldayradiobutton.click();
	}
	
	
	public void click_on_Time_radio_button()
	{
		timeradiobutton.click();
	}
	
	
	public void inpHour_in_time_input()
	{
		String time=new SimpleDateFormat("HH").format(new Date());
		hourinp.sendKeys(time);
	}
	
	public void inpmin_in_time_input()
	{
		String min= new SimpleDateFormat("mm").format(new Date());
		minuteinp.sendKeys(min);
	}
	
	public void selectStatus(String text)
	{
		UtilityClass.selectoptionsbyvisibleText(selectStatus, text);
	}
	
	public void selectRoom(String text)
	{
		UtilityClass.selectoptionsbyvisibleText(SelectRoom, text);
	}
	
	public void inpComment(String comment)
	{
		inpComment.sendKeys(comment);
	}
	
	public void click_on_Savebutton()
	{
		savebutton.click();
		
	}





	
}
