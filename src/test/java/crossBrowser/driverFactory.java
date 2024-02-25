package crossBrowser;
import java.io.*;
import java.util.Properties;
import java.time.Duration;
//import org.bouncycastle.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	public static WebDriver driver;
	public static String BROWSER = "chrome";
	public static String CHROME_DRIVER = "webdriver.chrome.driver";
	public static String DRIVER_LOCATION = "C:\\Users\\Reka\\Drivers\\chromedriver.exe";
	public static Properties properties;
	//private final static String propertyFilePath = "C:\\Users\\Reka\\eclipse-workspace\\CucumberBDDandTestCaseStudio\\src\\test\\resources\\config.properties";
	public static String TestCaseStudioWID;
	
	public WebDriver initializeDrivers() throws IOException
	      {
		    //WebDriver driver=null;	
			System.out.println("Testing on chrome");
		    System.setProperty(CHROME_DRIVER, DRIVER_LOCATION);	
		    //System.setProperty(CHROME_DRIVER, System.getProperty("user.dir")+"//drivers//chromedriver.exe");	
			//WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.setAcceptInsecureCerts(true);
			//chromeOptions.setScriptTimeout(Duration.ofSeconds(20));
			//chromeOptions.setPageLoadTimeout(Duration.ofMillis(2000));
			//chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
			chromeOptions.addExtensions(new File("C://Users//Reka//Drivers//extension_1_4_0_0.crx"));//////////////////
			chromeOptions.addArguments("--remote-allow-origins=*");	  	
			driver =new ChromeDriver(chromeOptions);
		    driver.manage().deleteAllCookies();
			
		    // Set Page load timeout
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
			//driver.manage().window().maximize();
			driver.get("chrome-extension://loopjjegnlccnhgfehekecpanpmielcj/testCaseStudio/studioWindow.html");
			TestCaseStudioWID=driver.getWindowHandle();
			
//			File propertyFilePath=new File("C:\\Users\\Reka\\eclipse-workspace\\CucumberBDDandTestCaseStudio\\src\\test\\resources\\writeIntoConfig.properties");
//			FileOutputStream outputStream = new FileOutputStream(propertyFilePath);  // to open file in read mode 
			
//			properties.setProperty("testCaseStudioWindowId", TestCaseStudioWID);
//			properties.store(outputStream, null);
			

			driver.switchTo().newWindow(WindowType.TAB); 		  
			  
			//Properties properties= new Properties();	
			//properties.store(new FileWriter("config.properties"),"testCaseStudioWindowId");

//			driver.switchTo().newWindow(WindowType.TAB);
//			driver.get(properties.getProperty("url"));
			return driver;	
	}
	
	public void closeallDriver() {
		driver.close();	  //*************************
	}
	
//	public static WebDriver getdriver() {
//		return driver;
//	}

}
