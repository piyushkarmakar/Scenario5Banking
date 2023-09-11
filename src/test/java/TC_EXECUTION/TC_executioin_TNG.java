package TC_EXECUTION;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Page1.TC_001;
import Page2.TC_002;
import Page3.TC_003;
import Utilities.Common_Methods;
import org.testng.annotations.Test;

public class TC_executioin_TNG 
{
WebDriver wd ;
TC_001 a=new TC_001(wd);
TC_002 b=new TC_002(wd);
TC_003 c=new TC_003(wd);
static ExtentTest test2;//Interface
static ExtentReports rep2;//class
Common_Methods cm =new Common_Methods(wd);


@BeforeTest
public void pre_condition()
{
wd=new FirefoxDriver();
wd.manage().deleteAllCookies();;
wd.manage().window().maximize();
rep2 = new ExtentReports(System.getProperty("user.dir")+"./Reports/Report1.html");
test2=rep2.startTest("script1");    //testNGclass
//We are using it here because it is a one Time Task
//wd=new FirefoxDriver();
}
@Test(priority = 1)
public void First_TC() throws InterruptedException, IOException
{
a.add_a_new_Customer(wd);
test2.log(LogStatus.PASS,"Testcase executed succesfully");
}
@Test(priority = 2)
public void Second_TC() throws InterruptedException, IOException
{
	int id=1015;
	++id;

b.open_acount(wd);
test2.log(LogStatus.PASS,"Testcase executed succesfully");
cm.Please_wait(wd);

}
@Test(priority = 3)
public void Third_TC() throws InterruptedException, IOException
{
c.Delete_account(wd);
test2.log(LogStatus.PASS,"Testcase executed succesfully");
rep2.endTest(test2);
rep2.flush();
rep2.close();
}

}
