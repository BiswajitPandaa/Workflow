package Qsp;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class handlingscrolltoparticularelement {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
	Actions a = new Actions(driver);
	a.scrollToElement(driver.findElement(By.xpath("//h2[text()='Today’s Deals']"))).perform();
	}
	

}
