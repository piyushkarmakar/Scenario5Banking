package Page2;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utilities.*;

import Utilities.Common_Methods;

public class TC_002 
{
	WebDriver wd;
	
	//Initialization
	public TC_002(WebDriver wd) 
	{
		this.wd=wd;

	}
	Common_Methods cm = new Common_Methods(wd);
	public void open_acount(WebDriver wd) throws IOException, InterruptedException
	{
		/*
		//Select sel = new Select(cm.Select_user);
		//sel.selectByVisibleText("Piyush Karmakar");
		//sel.selectByValue("6");
		//Select sel1 = new Select(cm.Select_currency);
	    //sel1.selectByValue("Rupee");
		//open account button
		*/
		 
		cm.Please_wait(wd);
		wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
		cm.Please_wait(wd);
		cm.Please_wait(wd);

		//Open account page validation
		if(wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/label")).isDisplayed()) 
		{
		System.out.println("Redirected to OPEN_ACCOUNT webpage");

		}
		else 
		{
		System.out.println("FAILED TO GO to OPEN_ACCOUNT webpage ");
		}

		cm.Please_wait(wd);
		
		//select user
		wd.findElement(By.cssSelector("#userSelect"));
		cm.Please_wait(wd);
		File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshots/OPEN_ACCOUNT.png"));
		
		//select user & send some value
		wd.findElement(By.cssSelector("#userSelect")).sendKeys("Piyush");
		cm.Please_wait(wd);		
		cm.Please_wait(wd);
		
		//select currency
		wd.findElement(By.cssSelector("#currency")).click();
		cm.Please_wait(wd);
		
		//select currency & giving some value 
		wd.findElement(By.cssSelector("#currency")).sendKeys("Rupee");
		cm.Please_wait(wd);
		cm.Please_wait(wd);	
		
		//clicking on process button
		wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		cm.Please_wait(wd);
		cm.Please_wait(wd);

		//pop-up message validation
		int id=1015;
		++id;
		String expected ="Account created successfully with account Number :"+id;
		String actual=wd.switchTo().alert().getText();
		
		if(actual.equalsIgnoreCase(expected)) {
		System.out.println("Currency added to Customer & account created having account no : "+id+"  successfully");
	
		cm.Please_wait(wd);
		wd.switchTo().alert().accept();
		}
		else 
		{
		System.out.println("enter the user details ");
		}

	}

	}
