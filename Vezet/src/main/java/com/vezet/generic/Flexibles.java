package com.vezet.generic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Flexibles {
	public Properties browserAttributes;
	public static Properties elementsLocator;

	  
	public static String userDir=System.getProperty("user.dir");
	public WebDriver driver;
	
	public static ExtentHtmlReporter report;
	public static ExtentReports extent;
	public static ExtentTest test;

}
