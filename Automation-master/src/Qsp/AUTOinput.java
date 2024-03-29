package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AUTOinput {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.actitime.com/login.do");
	Thread.sleep(1000);
driver.findElement(By.id("username")).sendKeys("admin");
  driver.findElement(By.name("pwd")).sendKeys("manager");
  Thread.sleep(1000);
  driver.findElement(By.id("loginButton")).click();

 

}
}
