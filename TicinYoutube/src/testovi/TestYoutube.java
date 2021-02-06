package testovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objekti.Home;
import objekti.Songs;

public class TestYoutube {
	private static WebDriver driver;
	public static final String REKLAMA = "//*[@id=\"movie_player\"]/div[1]/video";
	//public static final String URL= "https://www.youtube.com/";
	
	@BeforeClass
	public void createDriver() {
		//WebDriverWait wait = new WebDriverWait(driver,5);
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority = 1)
	public void testSearch() {
		driver.navigate().to(Home.URL);
		Home.typeSong(driver);
		Home.pressBtn(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/results?search_query=KA+HASHISH+-+TONCI+HULJIC+%26+MADRE+BADESSA+FT.+PETAR+GRASO";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void pustiPesmuTest() {
		driver.navigate().to(Songs.SPISAK_PESMA_URL);
		Songs.pustiPesmu(driver);
		String actual = driver.getCurrentUrl();
		String expected = "//*[@id=\"video-title\"]/yt-formatted-string";
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");

		Assert.assertEquals(actual, expected);
		}

	@Test(priority = 3)
	public void testUnosaPesme() {
		Home.typeSong(driver);
		String actual = driver.getCurrentUrl();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");

		String expected = "https://www.youtube.com/results?search_query=KA+HASHISH+-+TONCI+HULJIC+%26+MADRE+BADESSA+FT.+PETAR+GRASO";
		Assert.assertEquals(actual, expected);
	}
}
