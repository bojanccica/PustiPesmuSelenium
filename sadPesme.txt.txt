import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class YoutubePesma {
	
	public static final String URL="https://www.youtube.com/";
		public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		SoftAssert sa = new SoftAssert();
		
		driver.get(URL);
		WebElement search = driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input"));
		search.sendKeys("https://www.youtube.com/watch?v=DdRP532H4RY");
	
		WebElement btn= driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/button"));
		btn.click();
		WebElement pesma = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a"));
		pesma.click();
		sa.assertAll();
		
		try {
			File f= new File("dokument2.xlsx");
			InputStream inp = new FileInputStream(f); // Citanje iz fajla
			XSSFWorkbook wb = new XSSFWorkbook(inp); // Pretvaranje fajla u odgovarajuci format
			Sheet sheet = wb.getSheetAt(0); // Dohvata sheet
			Row row = sheet.getRow(0); // Dohvata red
			Cell cell = row.getCell(0);
			int broj=sheet.getLastRowNum();
			String poema = "Stine potrosilo je more";
			for(int i = 0; i<=broj;i++) {
				Row row1=sheet.getRow(i);
				Cell cell1= row.getCell(0);
				if(cell1 ==null) {
					System.out.println("prazno polje");
					break;
				}
				if(cell1.getRichStringCellValue().equals(poema)) {
					System.out.println(cell1.getStringCellValue()); 
				}
				else {
					continue;
				}
			}
			
			
			wb.close();
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		} 
		
		}
}

