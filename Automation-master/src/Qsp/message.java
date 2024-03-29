package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class message {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.instagram.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("biswajitmy4@gmail.com");
		driver.findElement(By.name("password")).sendKeys("");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
 driver.findElement(By.xpath("(//a[@role='link'])[6]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='____Rupi________👣🧡👑']")).click();
		
	}

}
