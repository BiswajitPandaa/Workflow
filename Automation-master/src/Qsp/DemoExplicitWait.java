package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoExplicitWait {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();    
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

		int i = 0;                                                                      
		while(i<=1) {
		try {
	driver.findElement(By.id("logoutLink")).click();
		}
		catch(Exception e)
		{
			i++;
			
		}
		driver.quit();

		}
		System.out.println(i);

		
		
	}

}
