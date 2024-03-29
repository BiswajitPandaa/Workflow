package Qsp;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class radiaobuttonforgender {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
		int yf=driver.findElement(By.xpath("(//input[@type='radio'])[1]")).getLocation().getY();
		int ym=driver.findElement(By.xpath("(//input[@type='radio'])[2]")).getLocation().getY();
		int yc=driver.findElement(By.xpath("(//input[@type='radio'])[3]")).getLocation().getY();
		if(yf==ym&&yf==yc) {
			System.out.println("radio buttons are aligned properly and pass");
		}
		else {
		System.out.println("radio buttons are not aligned properly and fail");
		}
		driver.quit();
	}
	
	

}
