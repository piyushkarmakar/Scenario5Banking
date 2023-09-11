package Utilities;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common_Methods 
{	

	//Links
	String link="https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	WebDriver wd ;
	/*
	public WebElement Open_account=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]"));
	public WebElement Customers=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
	public WebElement Cust_table=wd.findElement(By.xpath("//input[@placeholder='Search Customer'])[1]"));
	public WebElement FirstName=wd.findElement(By.xpath("/html/body/div/div/div[1]/strong"));
	public WebElement LastName=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
	public WebElement process=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
	public WebElement Select_user=wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"));
	public WebElement Option7=wd.findElement(By.cssSelector("#userSelect"));
	public WebElement Option3=wd.findElement(By.cssSelector("#currency"));
	public WebElement Select_currency=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/select"));
	public WebElement PinCode=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
	public WebElement ADD_NEW_CUST=wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
	public WebElement delete=wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[5]/button[1]"));
	*/
	//Initialization
	public Common_Methods(WebDriver wd) 
	{
		this.wd=wd;
	}

	

	
	public void page_invoke(WebDriver wd)
	{
	wd.get(link);
	}
	public void Bank_manager_login(WebDriver wd)
	{
	wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
	}
	

	//Navigate Back
	public void Navigate_back(WebDriver wd) 
	{
		wd.navigate().back();;
	}
	//Navigate Forward
	public void Navigate_forward(WebDriver wd) 
	{
		wd.navigate().forward();
	}
	//Refresh The Page
	public void Navigate_refresh(WebDriver wd) 
	{
		wd.navigate().refresh();;
	}
	//Wait Statement using thread.sleep
	public void Please_wait(WebDriver wd) throws InterruptedException 
	{
		Thread.sleep(2000);
	}
	//Scroll Down
	public void ScrollDown(WebDriver wd) 
	{
		
		((JavascriptExecutor)wd).executeScript("scroll(0,250)");	
	}
	//Alert & iFrame
	public void Alert_handle() 
	{
		wd.switchTo().alert().accept();
	}
	//Close Application
	public void close_browser() 
	{
		wd.close();;
	}
	
}
