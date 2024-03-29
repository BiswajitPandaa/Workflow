package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autoclick {
static{
	System.setProperty("Webdriver.chrome.diver","./driver/Chromedriver.exe");
	
}
public static void main(String[] args) throws InterruptedException{
	WebDriver driver= new ChromeDriver();
	driver.get("C:\\Users\\biswa\\OneDrive\\Documents/A.html");
	driver.findElement(By.tagName("a")).click();
	driver.manage().window().fullscreen();
	driver.navigate().back();
	driver.quit();
}
}
