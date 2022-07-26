package objectropository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class imdb {
	
	WebDriver driver;
	
	By searchInput = By.id("suggestion-search");
	By searchResult = By.xpath("//*[@id=\"react-autowhatever-1--item-0\"]/a/div[2]/div[1]");
	
	public imdb(WebDriver driver) {
		this.driver = driver;
}
	

	public void searchInputOnImdb(String data) 
	{
		driver.findElement(searchInput).sendKeys(data);
	}
	
	public void SearchResult() 
	{
		driver.findElement(searchResult).click();
	}
}