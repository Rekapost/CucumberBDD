package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utilities.WaitHelper;
import crossBrowser.driverFactory;

public class LoginPage {
	
 public static WebDriver driver=driverFactory.driver;	
 WaitHelper waithelper;
  
//  What is CacheLookup in Selenium?
//	@CacheLookup, as the name suggests helps us control when to cache a WebElement and when not to. 
//	This annotation, when applied over a WebElement, instructs Selenium to keep a cache of the WebElement 
//	instead of searching for the WebElement every time from the WebPage. This helps us save a lot of time.
	
	@FindBy(how=How.ID,using="Email")
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.ID,using="Password")
	@CacheLookup
	WebElement password;
	
	//@FindBy(how=How.XPATH,using="//button[normalize-space()='Log in']")
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	@CacheLookup   
	WebElement loginButton;
	
	
	//using constructor to initialze webelements in pagefactory	
		public LoginPage(WebDriver driver)
		{   
			this.driver=driver;
			PageFactory.initElements(driver,this);
			waithelper=new WaitHelper(driver);
		}
		
// if u r collecting multiple row elements from a table //tbody/tr
// List<WebElement> tableRows;
// if u r collecting multiple column elements from a table //tbody/tr/td
// List<WebElement> tableColumns;

	public void username(String uname)
	{
		//waithelper.WaitForElement(username,30);
		username.clear();
		username.sendKeys(uname);
	}
	
	public void password(String pwd)
		{
		//waithelper.WaitForElement(PASSWORD,30);
		password.clear();
		password.sendKeys(pwd);
		}
	
	public void login()
		{
	//waithelper.WaitForElement(PASSWORD,30);
		loginButton.click();		
	   }
	
	public void loginDDT(String userName, String passWord) throws InterruptedException {
		// TODO Auto-generated method stub		
		username.clear();
		username.sendKeys(userName);
		password.clear();
		password.sendKeys(passWord);
		loginButton.click();
	}
	
	
//	comparing one value with multiple value ,
//	if matched , say record found  pass, else fail
//	public void clickSearch()
//	{
//		btnSearch.click();
//		waithelper.WaitForElement(btnSearch,30);	
//	}
	
//	public int getNoOfRows() {
//		return(tableRows.size());
//	}
//	public int getNoOfColumns() {
//		return(tableColumns.size());
//	}
	
//	public boolean searchCustomerByEmail(String email)
//	{
//		boolean flag=false;
//		for(int i=1;i<=getNoOfRows();i++)
//		{
//			String emailid=table.findElement(****/tbody/tr["+i+"]/td[2].getText******)
//			System.out.println(emailid));
//			if (emailid.equals(email))
//			{
//				flag=true;
//			}
//		}
//		return flag;
//	}
	
//	public boolean searchCustomerByName(String Name)
//	{
//		boolean flag=false;
//		for(int =1;i<=getNoofRows();i++)
//		{
//			String name=table.findElement(****/tbody/tr["+i+"]/td[3]**);
//			String names[]=name.split(" "); //seperating fname & lname
//			if(names[0].equals("Reka")&& names[1].equals("NV"))
//			{
//				flag=true;
//			}
//		}
//		return false;
//	}

}
