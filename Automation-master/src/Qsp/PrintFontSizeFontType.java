package Qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintFontSizeFontType {

	public static void main(String[] args) {	
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement e = driver.findElement(By.linkText("Forgotten password?"));
		String fontsize = e.getCssValue("font-size");
		String fontType = e.getCssValue("font-family");
		System.out.println(fontsize);
		System.out.println(fontType);
		driver.close();
	}

}
