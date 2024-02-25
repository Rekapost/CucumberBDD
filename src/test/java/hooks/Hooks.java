package hooks;
import java.io.IOException;
import java.time.Duration;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utilities.WaitHelper;
import crossBrowser.driverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks{
	
	private static WebDriver driver;	
	private static driverFactory driverfactory;
	static Scenario scenario;
	public static Properties properties;
	
	// @BeforeClass
	// public void setup()
	@BeforeAll
	public static void setup() throws IOException  {
		System.out.println(" start");
		
		// Initialize driver from driver factory
		driverfactory = new driverFactory();
		driver = driverfactory.initializeDrivers();
		
		
		/*
		 * WebDriverManager.chromedriver().setup();
		 * ChromeOptions chromeOptions = new
		 * ChromeOptions(); chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		 * chromeOptions.setAcceptInsecureCerts(true);
		 * chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		 * chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
		 * chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
		 * chromeOptions.addArguments("--remote-allow-origins=*"); 
		 * driver =new ChromeDriver(chromeOptions);
		 */
	}

//	@AfterClass
//	public void tearDown() throws InterruptedException
	@AfterAll
	public  static void after() throws InterruptedException {
		driver.switchTo().window(Properties.getPropertyValue("TestCaseStudioWindowID"));/////////////////////////////////////////
		//driver.switchTo().window("TestCaseStudioWindowID");
		Thread.sleep(3000);///////////////////////////////////////////
		driver.findElement(By.cssSelector("input[title='Edit test case name']")).sendKeys("GoogleTest");  ////////////////////
		driver.findElement(By.id("save_btn")).click();   ////////////////////////////////////		
		//driver.quit();
	}
}
