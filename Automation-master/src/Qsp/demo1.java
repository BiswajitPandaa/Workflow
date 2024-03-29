package Qsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class demo1 {
	static {
		System.setProperty("WebDriver.Chrome.driver","./driver/Chromedriver.exe");
		System.setProperty("WebDriver.msedge.driver","./driver/msedgedriver.exe");
		
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		Demo.Test(driver);
	WebDriver driver3= new EdgeDriver();
	Demo.Test(driver3);
	
	
		
		

	}
}
