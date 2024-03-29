package Qsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notepadfileinput {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commondata.property");
		Properties p = new Properties();
p.load(fis);
WebDriver driver= new  ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get( p.getProperty("url"));
driver.findElement(By.id("username")).sendKeys(p.getProperty("username"));
driver.findElement(By.name("pwd")).sendKeys(p.getProperty("password"));
driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}

}
