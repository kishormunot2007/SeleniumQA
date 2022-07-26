package testVagrantTests;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectropository.Wikipedia;
import objectropository.imdb;



@Test
public class sampleTest {

	public static void VerifyMovieReleaseDate() throws IOException, InterruptedException, ParseException {
	
	System.setProperty("webdriver.chrome.driver", "/home/adminKT/Downloads/selenium-copy/TestVagrant/src/main/resources/chromedriver/chromedriver");
	ChromeDriver driver = new ChromeDriver();
	
	Wikipedia wiki= new Wikipedia(driver);
	imdb imdb = new imdb(driver);
	
	driver.get("https://en.wikipedia.org/wiki/Main_Page");
	wiki.searchInputOnWikipedia("Pushpa: The Rise");
	
	By firstVairable = By.xpath("//*[contains(text(),'Pushpa: The Rise')]"); 
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.presenceOfElementLocated(firstVairable));
	Thread.sleep(1000);
	wiki.SearchResult();
	
	String ReleaseDateInWikipedia = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")).getText();
	String CountryNameInWikipedia = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td")).getText();
	
	
	driver.get("https://www.imdb.com/");
	imdb.searchInputOnImdb("Pushpa: The Rise - Part 1");
	By newVariable = By.xpath("//*[contains(text(),'Pushpa: The Rise - Part 1')]"); 
	WebDriverWait wait2 = new WebDriverWait(driver,30);
	wait2.until(ExpectedConditions.presenceOfElementLocated(newVariable));
	imdb.SearchResult();
	Thread.sleep(1000);
	String date= driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a")).getText();
	System.out.println(date);
	String s = date;
	String[] parts = s.split("\\(");
	String firstPart = parts[0];
	System.out.println(firstPart);
	
	SimpleDateFormat input = new SimpleDateFormat("MMMM dd, yyyy");
	Thread.sleep(1000);	
	SimpleDateFormat output = new SimpleDateFormat("dd MMMM yyyy");
	String ReleaseDateInImdb = output.format(input.parse(firstPart));    
	System.out.println(ReleaseDateInImdb);
	
	String CountryNameInImdb = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul/li/a")).getText();
	
	Assert.assertEquals(ReleaseDateInWikipedia,ReleaseDateInImdb);  
	Assert.assertEquals(CountryNameInWikipedia, CountryNameInImdb);
	
	System.out.println("Test Case Passed");
	driver.manage().deleteAllCookies();
	driver.quit();
	
	
	
	
	
	
	
	}

}
