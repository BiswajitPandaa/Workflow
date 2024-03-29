package Qsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C {
	static {
		System.setProperty("WebDriver.Chrome.driver","./driver/ChromeDriver.exe");
		
	}
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.selenium.dev/"));
		{
			System.out.println("URL is navigating successfuly and pass");
		}
	
		driver.quit();
}
}
