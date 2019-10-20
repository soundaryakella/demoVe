package com.vezet.methods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.vezet.generic.Core;
import com.vezet.generic.Flexibles;

public class TakeScreenshotMethods extends Core {
	
	//method to take a screenshots
	
	public static void takeScreenShot(String testName) throws IOException
	{
		//Reporter.log(testName,true);
		TakesScreenshot ts = (TakesScreenshot) f.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(Flexibles.userDir+"\\src\\test\\resources\\"+testName+".png");
		FileUtils.copyFile(src, des);
	}
}
