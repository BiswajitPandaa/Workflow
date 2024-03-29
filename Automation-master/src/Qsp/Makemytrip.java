package Qsp;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Makemytrip {
	
		public static void main(String[] args) throws InterruptedException {
			
			
					WebDriver driver = new ChromeDriver();
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					driver.get("https://www.makemytrip.com/");
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
							By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));
					driver.findElement(By.xpath("//a[@class='close']")).click();	
				Actions a = new Actions(driver);
			Thread.sleep(5000);
			a.doubleClick().perform();
				 
		}
	}


