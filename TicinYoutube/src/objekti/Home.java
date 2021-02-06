package objekti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	public static final String URL= "https://www.youtube.com/";
	public static final String SEARCH_FIELD = "//*[@id=\"search\"]";
	public static final String BTN_XPATH = "//*[@id=\"search-icon-legacy\"]";
	
	
	public static void typeSong(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(SEARCH_FIELD));
		we.click();
		we.sendKeys(Songs.pesmeTabela());
	}
	public static void pressBtn(WebDriver driver) {
		driver.findElement(By.xpath(BTN_XPATH)).click();
	}
}
