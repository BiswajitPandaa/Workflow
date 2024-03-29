package Qsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelfilehandeling {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./data/acti.xlsx");
		Workbook w= WorkbookFactory.create(fis);
		String url = w.getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
		String un = w.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String pw = w.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		Thread.sleep(2000);
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

	}

}
