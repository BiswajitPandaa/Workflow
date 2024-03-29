package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookloginpresent {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		Thread.sleep(1000);
	boolean t = driver.findElement(By.name("login")).isEnabled();
	if(t==true)
		System.out.println("login button is enabled");
	else
		System.out.println("login button is disabled");
	driver.close();

}
}
