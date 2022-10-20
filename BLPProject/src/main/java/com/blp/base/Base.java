package com.blp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
    public static Properties prop;

	public Base() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\BLPProject\\src\\main\\java\\com\\blp\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void launchBrowser()  {
		String browserName=prop.getProperty("browser").trim();
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecho.driver", "gechodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else
		{
			try {
		  //System.out.println(browserName+"is not valid");
		  throw new Exception(browserName+"is not valid");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}
	}