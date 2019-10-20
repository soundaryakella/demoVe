package com.vezet.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Core {
	public static Flexibles f=new Flexibles();
	//property for browser
	public void valuesProperites() throws FileNotFoundException, IOException
	{
		f.browserAttributes = new Properties();
		f.elementsLocator=new Properties();
		
		String propertyFilePathForBrowser=Flexibles.userDir+"\\src\\main\\resources\\browserAttributes.properties";
		f.browserAttributes.load(new FileInputStream(propertyFilePathForBrowser));
		
		String propertyFilePathForLocators=Flexibles.userDir+"\\src\\main\\resources\\ElementsLocator.properties";
		
		f.elementsLocator.load(new FileInputStream(propertyFilePathForLocators));
	}
	public void openingTheApplication()
	{
		String URLValue = f.browserAttributes.getProperty("URL");
		f.driver.get(URLValue);
	}
	@BeforeTest
	public void invokePropertyFile() throws FileNotFoundException, IOException
	{
		//invoking browser propertyfile
		valuesProperites();
	}
	@BeforeMethod
	public void openingTheBrowser()
	{
		String valueOfBrowser = f.browserAttributes.getProperty("browserName");
		if(valueOfBrowser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
//			ChromeOptions opt=new ChromeOptions();
//			opt.addArguments("--disable-notifications");
//			f.driver=new ChromeDriver(opt);
			f.driver=new ChromeDriver();
		}
		else if(valueOfBrowser.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			f.driver=new FirefoxDriver();
		}
		f.driver.manage().window().maximize();
		openingTheApplication();
	}
	@AfterMethod
	public void CloseTheBrowser()
	{
		f.driver.close();
	}

}
