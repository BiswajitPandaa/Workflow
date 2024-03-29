package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class careinsurance {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.careinsurance.com/rhicl/proposalcp/renew/index-care");
		driver.findElement(By.id("policynumber")).sendKeys("123");
		driver.findElement(By.id("dob")).click();
		
		 WebElement t = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
		 Select s = new Select(t);
		 s.selectByIndex(4);
		 WebElement t1 = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		 Select s1 = new Select(t1);
		 s1.selectByValue("1997");
		 driver.findElement(By.xpath("//a[@data-date='6']")).click();
		 driver.findElement(By.id("alternative_number")).sendKeys("7978996648");
		 driver.findElement(By.id("renew_policy_submit")).click();
		boolean text = driver.findElement(By.id("policynumberError")).isDisplayed();
		if(text== true)
			System.err.println("please enter valid policy number is displayed and pass");
		else
			System.err.println("please enter valid policy number is not displayed and fail");
		driver.quit();
			
		
			
		 
		 
		
		 
		
		 
		

}
}
