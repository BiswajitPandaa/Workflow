package Qsp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class allselectedoptionmtr {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/biswa/OneDrive/Documents/MTR.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebElement alllink = driver.findElement(By.id("slv"));
		Select s= new Select(alllink);
		List<WebElement> alloption = s.getAllSelectedOptions();
		for(int i =0; i<alloption.size();i++)
		{
			String text = alloption.get(i).getText();
			System.out.println(text);
		}
		//for each loop
		for(WebElement option:alloption) {
			System.out.println(option.getText());
		}
		driver.quit();
	}

}
