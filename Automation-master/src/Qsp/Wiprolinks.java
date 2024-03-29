package Qsp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wiprolinks {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wipro.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String txt=allLinks.get(i).getText();
			System.out.println(txt);
		}
		driver.quit();
			

	}

}
