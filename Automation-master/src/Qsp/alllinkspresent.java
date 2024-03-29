package Qsp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alllinkspresent {

	public static void main(String[] args) throws InterruptedException {
	 WebDriver driver= new ChromeDriver();
	 driver.get("https://demo.opensourcebilling.org/en/users/sign_in");
	 Thread.sleep(2000);
List<WebElement> alllinks= driver.findElements(By.xpath("//a"));
int count= alllinks.size();
System.out.println(count);
for(int i =0; i<count;i++)
{
	String text= alllinks.get(i).getText();
	System.out.println(text);
}
driver.quit();


	
	}

}
