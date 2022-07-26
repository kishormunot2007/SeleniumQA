package objectropository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wikipedia {
	
	WebDriver driver;
	
	By searchInput = By.id("searchInput");
	By searchResult = By.xpath("/html/body/div[5]/div/a[1]");
	
	public Wikipedia(WebDriver driver) {
		this.driver = driver;
}
	

	public void searchInputOnWikipedia(String data) 
	{
		driver.findElement(searchInput).sendKeys(data);
	}
	
	public void SearchResult() 
	{
		driver.findElement(searchResult).click();
	}
}