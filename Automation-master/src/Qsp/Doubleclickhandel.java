package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Doubleclickhandel{
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("http://vtiger.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	WebElement triger = driver.findElement(By.id("loginspan"));
	Actions a = new Actions(driver);
	a.doubleClick(triger).perform();
}

}
