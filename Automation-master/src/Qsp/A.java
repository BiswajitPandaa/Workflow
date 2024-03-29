package Qsp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class A {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.msedge.driver", "./driver/msedgedriver.exe");
	
	EdgeDriver driver= new EdgeDriver();
	driver.get("https://www.google.com/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.instagram.com/");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.close();
	
}
}
