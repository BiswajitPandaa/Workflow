package Qsp;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertpopup {
	public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.automationtesting.in/Alerts.html");
			driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();	
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert a = driver.switchTo().alert();
			a.dismiss();
			boolean text = driver.findElement(By.id("demo")).isDisplayed();		
		if(text==true)
			System.out.println("you press cancel text is showing and pass ");
		else
			System.out.println("fail");
			
		
			driver.quit();
			
			
	}

}
