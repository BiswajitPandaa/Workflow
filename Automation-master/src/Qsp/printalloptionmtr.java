package Qsp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class printalloptionmtr {
	public static void main(String[] args) throws InterruptedException {

HashSet hs = new HashSet();
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/biswa/OneDrive/Documents/MTR.html");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 WebElement alllink = driver.findElement(By.id("mtr"));
	Select s= new Select(alllink);
	List<WebElement> alloption = s.getOptions();
	for(int i= 0; i<alloption.size();i++)
	{
		String st = alloption.get(i).getText();
		hs.add(st);
	}

	for( Object o:hs)
	{
		System.out.println(o);
	}

	driver.quit();
	}

	
		
	
}
