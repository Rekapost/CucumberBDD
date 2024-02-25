package stepDefinitions;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import baseclass.BaseClass;
import crossBrowser.driverFactory;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

//public class Steps extends BaseClass {   passing values from base class
public class Steps {	
//	public Steps(WebDriver driver) {
//	super(driver);
//	// TODO Auto-generated constructor stub
//	}
	
    public WebDriver driver= driverFactory.driver; //as u extended from parent base
	static Logger logger=Logger.getLogger(Steps.class);
	LoginPage lp=new LoginPage(driver);
	
//*************************************************************************************************
	
	@Given("open browser")
	public void open_browser() {
	System.out.println("Opening Browser:");
	}
	
	@When("open nopcommerce link {string}")
	public void open_nopcommerce_link(String string) {
		logger.info(" launching url");
		System.out.println("Open nop commerce site: ");
		
		driver.get(string);     // passing values from feature file 
		//driver.get(APP_URL);  passing values from base class
		
		driver.manage().window().maximize();
	}

	@Then("enter user id {string} and password {string}")
	public void enter_user_id_and_password(String string, String string2) {		
		logger.info("providing login details");
		System.out.println("Enter credentials:");
		lp.username(string);   // passing values from feature file 
		lp.password(string2);  // passing values from feature file 
		
		//LoginPage lp=new LoginPage();
//		lp.username(USERNAME);   passing values from base class
//		lp.password(PASSWORD);   passing values from base class
		lp.login();	
	}

	@Then("dashboard page opens")
	public void dashboard_page_opens() {
		logger.info(" openeing dashboard page");
		System.out.println("opening dashboard page:");
		//"Dashboard / nopCommerce administration"
		//PageFactory.initElements(driver, LoginPage.class);
		//driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		//LoginPage.loginButton.click();
	}

	@Then("click logout")
	public void click_logout() {
		System.out.println("loging out of nop commerce:");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			{
			Assert.assertTrue(true);
			System.out.println(" successful login");
			}
		else {
			Assert.assertTrue(false);
			}
		//Assert.assertEquals(expected: true, status);     for boolean output boolean status isDisplayed();
		//Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@Then("come to home page")
	public void come_to_home_page() {
		System.out.println("back to home page :");
		driver.close();	
	}
	
	
//	@When(" Enter Customer Email")
//	public void enter_customerEmail() {
//		searchcust=new SearchCustomerPage(driver);
//		searchcust.setEmail("reka@gmail.com");
//	}
	
//	@Then(" user should find email in search table")
//	public void user_should_find_email_in_search_table() {
//		boolean status=searchCust.searchCustomerByEmail("reka@gmail.com");
//      Assert.assertEquals(true,status);
//	}
	
//	@When("Enter customer firstName")
//	public void enter_customer_firstName() {
//		searchCust=new searchCustomerPage(driver);
//		searchCust.setFirstName("Reka")
//	}

}
