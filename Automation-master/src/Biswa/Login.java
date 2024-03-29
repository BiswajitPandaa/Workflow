package Biswa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id ="username")
	private WebElement un;

	@FindBy(name ="pwd")
	private WebElement pwd;
	  public Login( WebDriver  driver)
	  
	  { PageFactory.initElements( driver,this);
		  
	  }
	  public void setlogin(String u,String pw)
	  {
		  un.sendKeys("u");
		  pwd.sendKeys("pw");
	  }

		

}
