package com.vezet.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vezet.generic.Core;
import com.vezet.generic.Flexibles;

public class JavaScriptExecutorMethods extends Core {
	//method to scroll By pixels 
	public static void scrollVertical(WebDriver driver, int StartPoint,int EndPoint) throws InterruptedException
	{
	 JavascriptExecutor js = (JavascriptExecutor)f.driver;
	 Thread.sleep(2000);
	 js.executeScript("window.scrollBy("+StartPoint+","+EndPoint+")");
	}
	
	//method to scroll by webElement
	public static void scrollByElement(WebDriver driver,WebElement element) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)f.driver;
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].scrollIntoView();", element);
	}

	

}
