package com.vezet.methods;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.vezet.generic.Core;
import com.vezet.generic.Flexibles;

import freemarker.core.ReturnInstruction.Return;


public class ElementMethods extends Flexibles {
	//method to find the element
	public static WebElement  findElementMethod(String object,WebDriver driver)
	{
		By by=null;
		WebElement e=null;
		String[] locator = Flexibles.elementsLocator.getProperty(object).split("--");
		if(locator[0].equalsIgnoreCase("tagName"))
		{
			by=By.tagName(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("id"))
		{
			by=By.id(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("name"))
		{
			by=By.name(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("className"))
		{
			by=By.className(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("linkText"))
		{
			by=By.linkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("partialLinkText"))
		{
			by=By.partialLinkText(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("cssSelector"))
		{
			by=By.cssSelector(locator[1]);
		}
		else if(locator[0].equalsIgnoreCase("xpath"))
		{
			by=By.xpath(locator[1]);
		}
		
		return e=driver.findElement(by);
	}
	//method to list of webElements
		public static List<WebElement>  findElementsMethod(String object,WebDriver driver)
		{
			By by=null;
			List<WebElement> e=null;
			String[] locator = Flexibles.elementsLocator.getProperty(object).split("--");
			if(locator[0].equalsIgnoreCase("tagName"))
			{
				by=By.tagName(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("id"))
			{
				by=By.id(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("name"))
			{
				by=By.name(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("className"))
			{
				by=By.className(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("linkText"))
			{
				by=By.linkText(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("partialLinkText"))
			{
				by=By.partialLinkText(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("cssSelector"))
			{
				by=By.cssSelector(locator[1]);
			}
			else if(locator[0].equalsIgnoreCase("xpath"))
			{
				by=By.xpath(locator[1]);
			}
			
			return e=driver.findElements(by);
		}
		//method to enter the data into webelement
		public static void sendDataToElement(String object,WebDriver driver,String data)
		{
			WebElement element = findElementMethod(object, driver);
//			 WebDriverWait wait=new WebDriverWait(driver, 10);
//			 wait.until(ExpectedConditions.visibilityOf(element));
			 element.sendKeys(data);
			
		}
		//method to click on the element
		public static void clickOnElement(String object,WebDriver driver)
		{
			WebElement element = findElementMethod(object, driver);
			 WebDriverWait wait=new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		
		//method to check whether the element is displayed or not
		public static boolean isElementDisplayed(String object,WebDriver driver)
		{
			return findElementMethod(object,driver).isDisplayed();
		} 
		
		//method to clear the data present in the text field and sending new data
		public static void clearAndSendData(String object,WebDriver driver,String data)
		{
			 WebElement clearedElement = findElementMethod(object,driver);
			 clearedElement.clear();
			 clearedElement.sendKeys(data);
		}
		
		public static boolean checkElementClickable(String object,WebDriver driver)
		{
			return findElementMethod(object,driver).isEnabled();
		}

		
		//method for broken links
		public static void checkLinksStatus(String object,WebDriver driver) throws IOException
		{
			List<WebElement> listOfLinksElements = findElementsMethod(object, driver);
			for(WebElement link:listOfLinksElements)
			{
				String li = link.getAttribute("href");
				URL u = new URL(li);
				URLConnection ulink = u.openConnection();
				HttpURLConnection connection = (HttpURLConnection)ulink;
				int Rcode = connection.getResponseCode();
				if(Rcode==200)
				{
					Reporter.log(li+"-"+"with Response Code"+Rcode+" Response message is :"+connection.getResponseMessage()+"  Status :"+"Not Broken",true);
				}
				else
				{
					Reporter.log(li+"-"+"with Response Code"+Rcode+" Response message is :"+connection.getResponseMessage()+"  Status :"+"Broken",true);
				}
			}
		}
}
	
	
