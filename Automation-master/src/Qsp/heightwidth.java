package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class heightwidth {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(1000);
	int height1 = driver.findElement(By.id("username")).getSize().getHeight();
	int width1=driver.findElement(By.id("username")).getSize().getWidth();
	int height2 = driver.findElement(By.name("pwd")).getSize().getHeight();
	int width2=driver.findElement(By.name("pwd")).getSize().getWidth();
	if(height1==height2&&width1==width2)
		System.out.println("username and passowrd text field height and width is equal ");
	else
		System.out.println("username and passowrd text field height and width is not equal ");
	driver.quit();
	
	}
}
