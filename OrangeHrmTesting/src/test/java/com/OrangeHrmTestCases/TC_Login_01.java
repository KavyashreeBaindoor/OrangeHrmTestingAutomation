package com.OrangeHrmTestCases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHrmPageObjects.LoginPage;
import com.OrangeHrmUtilities.ReadDataFromExcelFile;

public class TC_Login_01 extends BaseClass{
	
	@Test(dataProvider="getData",dataProviderClass=ReadDataFromExcelFile.class)
	public void LoginTest(String unname,String pw) throws InterruptedException {
		String expected="Invalid credentials";
	LoginPage l=new LoginPage(driver);
	l.userName(unname);
	l.password(pw);
	l.clickLogin();
  Thread.sleep(2000);
	
	if(driver.getCurrentUrl().contains("dashboard")) {
		Assert.assertTrue(true);
	  l.logout();
	}
	else
	{
		System.out.println("negative test case");
		String actual=l.displayErrMssg();
		Assert.assertEquals(actual, expected);
	}
		
	
    Thread.sleep(1000);
	//driver.switchTo().defaultContent();

	}}
