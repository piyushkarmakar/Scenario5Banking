package Page1;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.google.common.io.Files;
import Utilities.*;

public class TC_001 
{
	
WebDriver wd;
	//Initialization
public TC_001(WebDriver wd) 
{
	this.wd=wd;
}
Common_Methods cm = new Common_Methods(wd);
public void add_a_new_Customer(WebDriver wd) throws InterruptedException, IOException
{
//page invoke
cm.page_invoke(wd);
cm.Please_wait(wd);
//clicking on bank login
//Hitting Bank Manager Login
cm.Bank_manager_login(wd);
cm.Please_wait(wd);


//Bank Manager login Page Validation
if(wd.findElement(By.xpath("/html/body/div/div/div[1]/strong")).isDisplayed()) 
{
System.out.println("Redirected to Bank Manager Login Portal ");

}
else 
{
System.out.println("FAILED TO GO to Bank Manager Login Portal ");
}


//clicking  on add customer
cm.Please_wait(wd);
cm.Please_wait(wd);
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();

cm.Please_wait(wd);
//add_customer validation
if(wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).isDisplayed()) {
System.out.println("Redirected to Add_Customer webpage");
cm.Please_wait(wd);
File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
Files.copy(src,new File("./Screenshots/ADD_CUSTOMER.png"));
}
else 
{
System.out.println("FAILED TO GO to Add_Customer webpage ");
}

cm.Please_wait(wd);

//giving firstname 
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).clear();
cm.Please_wait(wd);
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Piyush");

//giving lastname
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).clear();
cm.Please_wait(wd);
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys("Rati");

//giiving pincode
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).clear();
cm.Please_wait(wd);
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys("751021");

//clicking on add_customer button
wd.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
cm.Please_wait(wd);

//pop-up message validation
int id=5;
++id;
String expected ="Customer added successfully with customer id :"+id;
String actual=wd.switchTo().alert().getText();

if(actual.equalsIgnoreCase(expected)) {
System.out.println("Customer added successfully");
cm.Please_wait(wd);
wd.switchTo().alert().accept();
cm.Please_wait(wd);

}
else 
{
System.out.println("enter the user details ");
}

}
}
