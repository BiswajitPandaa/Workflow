package Qsp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mtr {
	public static void main(String[] args) throws InterruptedException {
		ArrayList hs = new ArrayList();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/biswa/OneDrive/Documents/MTR.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebElement alllink = driver.findElement(By.id("mtr"));
		Select s= new Select(alllink);
		List<WebElement> alloption = s.getOptions();
	for(   WebElement text :alloption)
	{  
		hs.add(text.getText());
	}
	Collections.sort(hs);
	for(Object o: hs)
	{
		System.out.println(o);
	}
	driver.quit();
		
	
		
		
	}

}
