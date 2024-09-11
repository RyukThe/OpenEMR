package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass
{
		
		//This method is used to fetch data from excel sheet.
		// User Have to pass two input 1st: Row Index. 2nd: Cell Index
		//Author: Saurav Kasture
		public static String getExcelData(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file= new FileInputStream("D:\\eclipse\\OpenEMR\\TestData\\OpenEMR.xlsx");
			
			String TestData = WorkbookFactory.create(file).getSheet("Sheet1").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			
			return TestData;
		}
		
		
		//This Method is used to Fetch data from excel sheet.
		// User Have to Pass 3 Input 1st String Sheet Name, 2nd Row Index, 3rd Cell Index.
		//Author: Saurav kasture
		public static String getExcelData(String sheetName,int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file= new FileInputStream("D:\\eclipse\\OpenEMR\\TestData\\OpenEMR.xlsx");
			String TestData = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			return TestData;
		}
		
		//This method is used to fecth data from property file.
		//User Have to Pass String key As a input.
		//Author: Saurav Kasture 
		public static String getPropertyFileData(String key) throws IOException
		{
			FileInputStream file=new  FileInputStream("D:\\eclipse\\OpenEMR\\OpenEMR.properties");
			Properties property= new Properties();
			property.load(file);
			String value = property.getProperty(key);
			return value;
		
		}
		
		//This method is used to take ScreenShot of webpage 
		//User Have to pass 2 inputs 1st. driver, 2nd TestCaseId.
		//Author: Saurav Kasture
		public static void getScrenshot(WebDriver driver,int TestCaseId) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File des= new File("D:\\eclipse\\OpenEMR\\FailedTestCasesSS\\TestCaseId"+TestCaseId+".png");
			FileHandler.copy(src, des);
		}
		
	
		
		public static void selectoptionsbyIndex(WebElement element,int value)
		{
			Select sel= new Select(element);
			sel.selectByIndex(value);
			
		}
		
		
		
		
		public static void selectoptionsbyvisibleText(WebElement element,String text)
		{
			Select sel= new Select(element);
			sel.selectByVisibleText(text);
			
		}
		
		
		public static String confirmationPopUp(WebDriver driver)
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return alert.getText();
		}
		
		public static void switchToIFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		
		public static void getHandelDropDown(WebDriver driver,WebElement element)
		{
			Actions act= new Actions(driver);
			act.moveToElement(element).perform();
		}
	}


