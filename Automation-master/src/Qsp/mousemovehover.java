package Qsp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousemovehover {

public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	WebElement target = driver.findElement(By.id("draggable"));
	WebElement t = driver.findElement(By.id("droppable"));
	Actions a= new Actions(driver);
a.dragAndDrop(target, t).perform();
	
	
	
	
	

}
}
