package Qsp;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartmobile {
public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.flipkart.com/");
driver.findElement(By.name("q")).sendKeys("i Phone 14 Pro max"+Keys.ENTER);
List<WebElement> prod = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]"));
List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]/../../div[2]/div[1]/div[1]/div[1]"));
for(int i=0;i<=prod.size();i++)
{
	
		System.out.println(prod.get(i).getText() + " " + price.get(i).getText());
}



}
}
