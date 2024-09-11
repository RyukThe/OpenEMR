package ReceptionistModule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class HomePage 
{
	@FindBy(xpath = "//div[text()='Calendar']") private WebElement calenderTab;
	@FindBy(xpath = "//div[text()='Finder']") private WebElement patinetFinderTab;
	@FindBy(xpath = "//div[text()='Patient']") private WebElement PatientTab;
	@FindBy(xpath = "//div[text()='New/Search']") private WebElement Create_or_searchPatinetTab;
	@FindBy(xpath = "//td[@class='tdMonthName-small']") private WebElement month;
	@FindBy(xpath = "//div[@id='monthPicker']/table//tr") private WebElement monthlist;
	@FindBy(xpath = "//table[@class='table table-sm table-borderless']//tr[position()>=3 and last()<=7]//td") private WebElement dates;
	@FindBy(xpath = "//table[@class='table']") private WebElement timeslots;
	@FindBy(name ="cal" ) private WebElement iframeCalender;
	@FindBy(linkText = "10:00") private WebElement defaultTime;
	@FindBy(xpath = "//iframe[@id='logoutinnerframe']") private WebElement logoutFrame;
	@FindBy(xpath = "//span[@class='fa-stack']") private WebElement profileDropDown;
	@FindBy(xpath = "(//li[@class='menuLabel'])[6]") private WebElement logoutbutton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void switchToIframeCalender(WebDriver driver)
	{
		driver.switchTo().frame("cal");
	}
	public void clickonMonth( )
	{
		month.click();
	}
	public void seletMonth(WebDriver driver)
	{
		List<WebElement> monthlist1 = driver.findElements(By.xpath("//div[@id='monthPicker']/table//tr"));
		String month_=new SimpleDateFormat("MMMM").format(new Date());
		System.out.println(month_);
		for(WebElement mon:monthlist1)
		{
			String m = mon.getText();
			
			if(m.equals(month_))
			{
				mon.click();
				break;
			}
		}
	}
	
	
	public void selectDate(WebDriver driver)
	{
		List<WebElement> dates_ = driver.findElements(By.xpath("//table[@class='table table-sm table-borderless']//tr[position()>=3 and last()<=7]//td"));
		String date1=new SimpleDateFormat("dd").format(new Date());
		System.out.println(date1);
		for(WebElement date:dates_)
		{
			String d=date.getText();
		
			if(d.equals(date1))
			{
				date.click();
			System.out.println(d+"click is perfrom");
				break;
			}
			
		}
	}
	
	public void selectTimeSlot(WebDriver driver)
	{
		List<WebElement> Tslots = driver.findElements(By.xpath("//table[@class='table']"));
		String time1=new SimpleDateFormat("HH:mm").format(new Date());
		System.out.println(time1);
		for(WebElement time:Tslots)
		{
			String t = time.getText();
		
			if(t.equals(time1))
			{
				time.click();
				break;
			}
			else
			{
				System.out.println("time not match");
				defaultTime.click();
				break;
			}
		}
	}

	public void switchToHomePageLogoutFrame(WebDriver driver)
	{
		UtilityClass.switchToIFrame(driver, logoutFrame);
	}
	
	public void overMouseonProfileDropDown(WebDriver driver)
	{
		UtilityClass.getHandelDropDown(driver, profileDropDown);
	}
	
	public void clickOnLogOutButton(WebDriver driver)
	{
			logoutbutton.click();
	}
	
}
