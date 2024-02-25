package stepDefinitions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import baseclass.BaseClass;
import crossBrowser.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

//public class stepsWithDDT extends BaseClass {   passing values from base class
	public class stepsWithDDT {	
		
//	public stepsWithDDT(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	public WebDriver driver= driverFactory.driver; //as u extended from parent base;
	public static Properties properties;
	private final static String propertyFilePath = "./src/test/resources/config.properties";
	LoginPage lp=new LoginPage(driver);

	//	@Before
//	public void setup() throws IOException {		
////******** adding logger ( instantiating logger)******************
//		logger=Logger.getLogger("chrome Browser");
//		PropertyConfigurator.configure("log4j.properties");
//		WebDriverManager.chromedriver().setup();
//		//System.setProperty(Constants.CHROME_DRIVER,Constants.DRIVER_LOCATION);
//		driver=new ChromeDriver();
//	}


	@Given("Launch Chrome browser")
	public void launch_chrome_browser() {
		System.out.println("Opening Browser:");	
	}
	
	@When("open nopcommerce link for DDT {string}")
	public void open_nopcommerce_link_for_ddt(String string) throws IOException {
		//logger.info(" launching url");
		System.out.println("Open nop commerce site: ");
		
	////////////////////////////////////////
/*		        driver.get("chrome-extension://loopjjegnlccnhgfehekecpanpmielcj/testCaseStudio/studioWindow.html");
				String testCaseStudioId=driver.getWindowHandle();
		

				FileInputStream stream = new FileInputStream(propertyFilePath);
				properties = new Properties();
			
				properties.load(stream);
				stream.close();
			
		
				properties.setProperty("TestCaseStudioWindowID", testCaseStudioId);
				driver.switchTo().newWindow(WindowType.TAB);
*/
	/////////////////////////////////////////
				
		driver.get(string);     // passing values from feature file 
		//driver.get(APP_URL);  passing values from base class
		
		driver.manage().window().maximize();
	}
	
	@When("Enter username {string} and password {string}")
	public void enter_username_and_password(String userName, String passWord) throws InterruptedException {
		//logger.info("providing login details");
		System.out.println("Enter credentials:");
		//LoginPage lp=new LoginPage(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginDDT(userName, passWord);
	}	
	
	@When("Click on login button")
	public void click_on_login_button() {
		//logger.info(" openeing dashboard page");
		System.out.println("opening dashboard page:");
		//PageFactory.initElements(driver, LoginPage.class);
		//driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	//	LoginPage.loginButton.click();		
	}
	
	@Then("User must be successfully able to login to dashboard page")
	public void user_must_be_successfully_able_to_login_to_dashboard_page() {
		System.out.println("loging out of nop commerce:");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			{System.out.println(" successful login");
			System.out.println("back to home page :");
			driver.close();	
			}
	   }
}
