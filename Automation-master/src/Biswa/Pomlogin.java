package Biswa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomlogin {
@FindBy(id="username")
private WebElement utbx;
@FindBy(name="pwd")
private WebElement ptbx;
@FindBy(xpath = "//div[text()='login']")
private WebElement lgbtn;

public Pomlogin(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public void setlogin(String un, String pwd)
{
	utbx.sendKeys(un);
	ptbx.sendKeys(pwd);
	lgbtn.click();
	
}

}
