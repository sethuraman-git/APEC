package org.baseclasscucumber;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobalcucumber {
	public static WebDriver driver;
	public static Actions ac;
	public static Robot r;
	
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void toLoadUrl(String url) {
		driver.get(url);
		
	}
	public static void toType(WebElement element, String value) {
		element.sendKeys(value);	

		}
		
		public static void toClick(WebElement element) {
			element.click();

		}
		public static void toGetUrl() {
			driver.getCurrentUrl();

		}
		public static void toGetTitle() {
			driver.getTitle();

		}
		public static void toQuit() {
			driver.quit();

		}
		public static void toMax() {
			driver.manage().window().maximize();
		}
		public static void implicitWait() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		public static void deteteallcookies() {
			driver.manage().deleteAllCookies();

		}
		public static void screenshot(String picName) throws IOException {
			TakesScreenshot t = (TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File des = new File("C:\\Users\\Sethu\\eclipse-workspace\\Cucumbermav\\screenshot"+picName+".png");
			FileUtils.copyFile(src, des);
		}
	    public static void toDragAndDrop(WebElement src, WebElement dest) {
	    	ac = new Actions(driver);
	    	ac.dragAndDrop(src, dest).perform();

		}
	    public static void toMouseHover(WebElement element) {
	    	ac = new Actions(driver);
	    	ac.moveToElement(element).perform();
	    }
	    public static void toSelectByValue(WebElement element, String value) {
	    	Select s = new Select(element);
	    	s.selectByValue(value);
	    }
	    public static void toSelectByIndex(WebElement element, int index) {
	    	Select s = new Select(element);
	    	s.selectByIndex(index);
	    }
	    public static void toSelectByText(WebElement element, String value) {
	    	Select s = new Select(element);
	    	s.selectByVisibleText(value);
	    }
	    public static void enter() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	    public static void tab() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

		}
	    public static void downArrow() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	    public static void n() throws AWTException {
	  		r=new Robot();
	  		r.keyPress(KeyEvent.VK_N);
	  		r.keyRelease(KeyEvent.VK_N);
	  	}
	    public static void upArrow() throws AWTException {
	    	r=new Robot();
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
	    public static void copy() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}
	    public static void paste() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
		}
	    public static String excelRead(String fileName,String sheetName, int rowNo, int cellNo) throws IOException {
			//1.path of the excel file
			File f = new File("C:\\Users\\Sethu\\eclipse-workspace\\Cucumbermav\\worksheet\\"+fileName+".xlsx");
			
			//2.to read a file
			FileInputStream input = new FileInputStream(f);
		
			//3.workbook instanciaiton  
			Workbook w = new XSSFWorkbook(input);
		
			//4.to read the sheet
			Sheet s = w.getSheet(sheetName);
		
			//5.to get row
			Row r = s.getRow(rowNo);
			
			//6.to get cell
	    	Cell c = r.getCell(cellNo);
	    	String value;
	    	int cellType = c.getCellType();
	    	if (cellType==1) {
				value = c.getStringCellValue();
				
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
				
			}
			else {
				double num = c.getNumericCellValue();
				long l = (long)num;
				value= String .valueOf(l);
				
			}
	 // 	System.out.println(value);
			return value;
	}
	    	
	    
	    
	    
	    public static void excelDate(String fileName,String sheetName, int rowNo, int cellNo) throws IOException {
	    	//1.path of the excel file
	    	File f = new File("C:\\Users\\Sethu\\eclipse-workspace\\MavenSam\\ExcelDatas\\"+fileName+".xlsx");
	    	
	    	//2.to read a file
	    	FileInputStream input = new FileInputStream(f);

	    	//3.workbook instanciaiton  
	    	Workbook w = new XSSFWorkbook(input);

	    	//4.to read the sheet
	    	Sheet s = w.getSheet(sheetName);

	    	//5.to get row
	    	Row r = s.getRow(rowNo);
	    	
	    	//6.to get cell
	    	Cell c = r.getCell(cellNo);
	    	String value;
	    	int cellType = c.getCellType();
	    	if (cellType==1) {
				value = c.getStringCellValue();
				
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
				
			}
			else {
				double num = c.getNumericCellValue();
				long l = (long)num;
				value= String .valueOf(l);
				
			}
			System.out.println(value);
	}
	    	
	    
	    
	    
	    
	    
	    
	    
	    public static void toReadAllData(String fileName, String sheetName) throws IOException {
	    	//1.path of the excel file
	    			File f = new File("C:\\Users\\Sethu\\eclipse-workspace\\MavenSam\\ExcelDatas\\"+fileName+".xlsx");
	    			
	    			//2.to read a file
	    			FileInputStream input = new FileInputStream(f);
	    		
	    			//3.workbook instanciaiton  
	    			Workbook w = new XSSFWorkbook(input);
	    		
	    			//4.to read the sheet
	    			Sheet s = w.getSheet(sheetName);
	    		
	    			//5.to get row
	    			Row r = s.getRow(0);
	    			
	    			//6.to get cell
	    			Cell c = r.getCell(0);
	    			
	    			//7.to fetch a value in the particular cell
	    			String value = c.getStringCellValue();
	    			
	    			System.out.println(value);
	    		
	    			int noofrows = s.getPhysicalNumberOfRows();
	    			System.out.println("Number of Rows "+noofrows);
	    		
	    			int noofcells = r.getPhysicalNumberOfCells();
	    			System.out.println("Number of cells "+noofcells);
	    			
	    			//getting all values (we use for)
	    			
	    			
	    				
	    				  for (int i = 0; i <noofrows ; i++) {
	    				    	Row rows = s.getRow(i);
	    				    	for (int j = 0; j <noofcells ; j++) {
	    				    		Cell cells = rows.getCell(j);
	    				    		int cellType = cells.getCellType();
	    				    		 
	    				    			if (cellType==1) {
	    									value = cells.getStringCellValue();
	    									
	    				    			}
	    				    			else if (DateUtil.isCellDateFormatted(cells)) {
	    				    				Date d = cells.getDateCellValue();
	    									SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
	    									value = sim.format(d);
	    									
	    				    			}
	    				    			else {
	    									double num = cells.getNumericCellValue();
	    									long l = (long)num;
	    									value= String .valueOf(l);
	    									
	    				    			}
	    				    			System.out.println(value);
	    				    	}
	    				  }
	    }
	    				    
	    				    
	    
	    			
	    		public  void toGetAttributeValue(WebElement element) {
					String value = element.getAttribute("Value");
	    			System.out.println(value);

	    		}
	    	
}
