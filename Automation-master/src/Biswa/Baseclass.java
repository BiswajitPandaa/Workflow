package Biswa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import dev.failsafe.internal.util.Assert;

public class Baseclass {
public static WebDriver driver;
@BeforeTest
public void openbrowser()
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
}
@AfterTest
public void closebrowser() {
	driver.quit();
}
@BeforeMethod
public void login() {
	driver.get("http://demo.actitime.com/");
	driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.id("loginButton")).click();
	 
}
@AfterMethod
public void logout(){
	driver.findElement(By.id("logoutLin")).click();
}
}
