package Qsp;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class childbrowswerpopup {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://secure.indeed.com/");
	driver.findElement(By.xpath("//span[text()='Continue with Apple']")).click();
	driver.findElement(By.xpath("//span[text()='Continue with Facebook']")).click();
	    Set<String> wh = driver.getWindowHandles();
	    for(String t :wh) 
	    {
	    driver.switchTo().window(t);
	    String title = driver.getTitle();
	    if(!title.equals("Sign in with Apple�ID")) {
	    	Thread.sleep(2000);
	  driver.close();
	    }
	    }
	    
}
}
