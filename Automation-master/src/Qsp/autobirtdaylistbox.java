package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class autobirtdaylistbox {
public static void main(String[] args){
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	WebElement allday = driver.findElement(By.id("day"));
	Select s = new Select(allday);
	s.selectByIndex(5);

	WebElement allmont = driver.findElement(By.id("month"));
	Select s1 = new Select(allmont);
	s1.selectByValue("3");
	
	WebElement allyr = driver.findElement(By.id("year"));
	Select s2 = new Select(allyr);
   	s2.selectByVisibleText("1997");
	
	
	
}
}
