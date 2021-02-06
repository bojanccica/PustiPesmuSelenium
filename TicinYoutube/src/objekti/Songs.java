package objekti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;


public class Songs {
	public static final String SPISAK_PESMA_URL = "https://www.youtube.com/results?search_query=tonci+huljic";
	public static final String PESMA_XPATH ="//*[@id=\"video-title\"]/yt-formatted-string";
	
	
	public static void pustiPesmu(WebDriver driver){
		WebElement we = driver.findElement(By.xpath(PESMA_XPATH));
		we.click();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
		//caps.setCapability(ChromeOptions.CAPABILITY, options);

			
		}
	public static String pesmeTabela() {
		File f = new File ("pesme.xlsx");
			InputStream inp = null;
			try {
				inp = new FileInputStream(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			XSSFWorkbook wb = null;
			try {
				wb = new XSSFWorkbook (inp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			String pesmica = cell.getStringCellValue();
			return pesmica.toString();
		}
	
	public static int brojPesme() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj pesme:");
		int broj = sc.nextInt();
		return broj;
	}
	public static void hideElement(WebDriver driver, String xpath) {
	    WebElement element = driver.findElement(By.xpath(xpath));       
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
	}
}