package com.BankingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class readConfig {
	Properties p;
	
	
	public readConfig() {
		//loading file at run time
		File f=new File("./Configurations/config.properties");
		try {
		FileInputStream fis=new FileInputStream(f);
		p=new Properties();
		p.load(fis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	
	
	//reading values
	public String getUrl() {
		return p.getProperty("base_url");
		
	}
	
	public String getUsername() {
		return p.getProperty("un");
		
	}
	public String getPassword() {
		return p.getProperty("pw");
		
	}
	
	public String getBrowser() {
		return p.getProperty("browser");
		
	}
	
	
	
	
	
	}
