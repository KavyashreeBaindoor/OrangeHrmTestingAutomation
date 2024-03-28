package com.OrangeHrmUtilities;




import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.OrangeHrmTestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extent;
	ExtentTest test;
	

	
	//before start of every test in testng it comes here
		@Override
		public void onTestStart(ITestResult result) {
			
			System.out.println("i execute on every test start 1");
			if(extent==null) {
			 extent = new ExtentReports();
			}
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/extentsparkreport.html");
			extent.attachReporter(spark);
			
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("MyReport");
			test=extent.createTest(result.getMethod().getMethodName()).assignAuthor("kavya").assignCategory("smoke suite").assignDevice("chrome");
			}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println("i execute on every test success");
		test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		//test.pass("passed");
	  }
	

	@Override
	public void onTestFailure(ITestResult result) {
	    // not implemented
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("i execute on every test fail"+"   "+result.getMethod().getMethodName());
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it failed!");
		
		String sc = System.getProperty("user.dir")+"//Screenshots//"+result.getName()+".png";
		  
        
        try {
		Screenshot(sc);
		//attaching screeshot from path sc to reports
		test.fail("screenshot is below"+test.addScreenCaptureFromPath(sc));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	  }
	
	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("extent report  finished");
		extent.flush();
	}
	
	

}
