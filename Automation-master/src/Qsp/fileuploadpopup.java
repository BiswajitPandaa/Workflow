package Qsp;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileuploadpopup {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.naukri.com/mnjuser/homepage");
		driver.findElement(By.id("usernameField")).sendKeys("Biswajitmy4@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Biswajitmy4@");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		driver.findElement(By.linkText("View & Update Profile")).click();

		File f= new File("./Data/LITU resume.docx");
		String text = f.getAbsolutePath();
		driver.findElement(By.id("attachCV")).sendKeys(text);
		
		
	}

}
