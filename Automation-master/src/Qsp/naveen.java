package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class naveen {
	
	public class Example_MakeMyTrip {
		public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("https://www.makemytrip.com/");
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
					By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));
			driver.findElement(By.xpath("//a[@class='close']")).click();
			driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		}
	}
}
		
		

	


