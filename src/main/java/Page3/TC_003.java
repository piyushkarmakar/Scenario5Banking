package Page3;
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

public class TC_003 
{
	WebDriver wd;
	
	//Initialization
	public TC_003(WebDriver wd) 
	{
		this.wd=wd;

	}
	Common_Methods cm = new Common_Methods(wd);
	public void Delete_account(WebDriver wd) throws IOException, InterruptedException
	{
		//clicking on delete_account page 
		cm.Please_wait(wd);
		wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();		
		//getting in to table
		cm.Please_wait(wd);
        wd.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]"));
        
        //WebTable automation column wise to know all the information about newly added customer
        String l1 = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[";
        String l2 = "]";
        
        System.out.println("new Customer added :F_name,L-name,Pin,Account_no : ");
        
        for(int i=1;i<=4;i++) 
        {
        String mxp = l1+i+l2;
        WebElement el = wd.findElement(By.xpath(mxp));
        System.out.println(el.getText());
		cm.Please_wait(wd);
        }
		//Delete account page validation
		File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshots/DELETE_ACCOUNT.png"));
        //As per TC deleting the newly added Record
        cm.Please_wait(wd);
        cm.Please_wait(wd);
		//wd.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]")).click();        
		wd.findElement(By.cssSelector("tr.ng-scope:nth-child(6) > td:nth-child(5) > button:nth-child(1)")).click();
		cm.Please_wait(wd);
		cm.Please_wait(wd);
		
        //WebTable automation row wise to know all the information about the customers left
        String l3 = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[";
        String l4 = "]/td[1]";
        
        System.out.println("Customers left after deleting customer");

        for(int i=1;i<=5;i++) 
        {
        String mxp = l3+i+l4;
        WebElement el = wd.findElement(By.xpath(mxp));
        System.out.println(el.getText());
        Thread.sleep(2000);
        }
	}
}
