package Qsp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class automatesuggation {
public static void main(String[] args) throws InterruptedException{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(2000);
	driver.findElement(By.name("q")).sendKeys("i phone");
	Thread.sleep(2000);
	List<WebElement> allsugg =driver.findElements(By.xpath("//span[contains(text(),'i phone')]"));
	int count =allsugg.size();
	for(int i=0; i<count;i++)
	{ String text=allsugg.get(i).getText();
	System.out.println(text);
	}
	Thread.sleep(2000);
	
	allsugg.get(count-1).click();
	
	
}

}
