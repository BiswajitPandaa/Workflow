package Qsp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class qspiderauto {
	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("qspider"+ Keys.ENTER);
		List<WebElement> link = driver.findElements(By.xpath("//a"));
		for(int i=0;i<link.size();i++)
		{
			System.out.println(link.get(i).getAttribute("href"));
		}
	
		
		

		
		
		
	}

}
