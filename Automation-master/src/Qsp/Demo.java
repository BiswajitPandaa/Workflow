package Qsp;

import org.openqa.selenium.WebDriver;

public class Demo {
	static void Test(WebDriver driver) {
		driver.get("https://www.aelenium.dev/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
