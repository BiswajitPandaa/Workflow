package Biswa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class autofill {
@Test
public void validlogin(){
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.actitime.com/");
	Login l = new Login(driver);
	l.setlogin("admin", "manager");
	
}
}
