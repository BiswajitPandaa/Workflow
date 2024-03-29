package Biswa;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Testuset {
	@Test
	public void valid() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.actitime.com/");
		Pomlogin l = new Pomlogin(driver);
		l.setlogin("admi", "manager");
		driver.close();
		
	}

}
