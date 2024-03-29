package Qsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B{
	static {
		System.setProperty("WebDriver.Chrome.driver","./driver/ChromeDriver.exe");
		
	}
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	     driver.manage().window().minimize();
	    Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.quit();
		
		
	
		
	
		
		
	}

	

}
