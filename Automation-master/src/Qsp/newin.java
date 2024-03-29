package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class newin {
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name ='username']")).sendKeys("biswajitmy4@gmail.com");
		RemoteWebDriver r = (RemoteWebDriver)driver;
	
	r.executeScript("document.getElementsByTagName('(//input)[2]'),values('biswajit')");
	}

}
