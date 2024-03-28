package com.OrangeHrmTestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.OrangeHrmPageObjects.LoginPage;
import com.OrangeHrmUtilities.readConfig;



public class BaseClass {

	
	public static WebDriver driver;
	readConfig c=new readConfig();
	public String url=c.getUrl();
	public String usernme=c.getUsername();
	public String pass=c.getPassword();
	public String browser=c.getBrowser();
	
	
	@BeforeClass
	public void setup() {
		if(browser.equals("chrome")) {
			
			 driver=new ChromeDriver();
		
		}else if(browser.equals("edge")) {
			
			 driver=new EdgeDriver();
		}
		   
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(url);
			
			
			
		}
	
	@AfterClass
	public void tearDown() {
		    driver.quit();
	}
	
	

	
	/*
	 * @BeforeMethod(alwaysRun =true) 
	 * public WebDriver Login() { LoginPage l=new
	 * LoginPage(driver); 
	 * l.login(un,pw);
	 *  return driver;
	 *   }
	 */
	
	
	
	public void Screenshot(String sc) throws IOException, InterruptedException {
		
		
        // Call Webdriver to click the screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot.
        FileHandler.copy(scrFile, new File(sc));
      //  FileUtils.copyFile(scrFile, new File(sc));
       
	}
	
	//method to generate unique mail id everytime

		public String generateRandomMailId() {
			RandomStringUtils r=new RandomStringUtils();
			String random=r.randomAlphabetic(7);
			
			return random;
		}		
			
		
	
	
	
}
