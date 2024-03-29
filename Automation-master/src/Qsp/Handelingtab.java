package Qsp;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handelingtab {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]")).click();
		driver.findElement(By.linkText("About your actiTIME")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Read Service Agreement']")).click();

	
		Set<String> allwh = driver.getWindowHandles();
		for(String e:allwh) {
			driver.switchTo().window(e);	
		}
		List<WebElement> text = driver.findElements(By.xpath("//h2"));
		
		for(WebElement t:text)
		{
			System.out.println(t.getText());
		}
		driver.quit();
	}

}
