package com.vezet.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vezet.generic.Core;

public class ActionsMethods extends Core {
	public static void performActions(String object1,String object2,WebDriver driver,String action)
	{
		WebElement element1;
		WebElement element2=null;
	if(object2!=null) {
	 element1 = ElementMethods.findElementMethod(object1,driver);
	 element2= ElementMethods.findElementMethod(object2,driver);
	}
	
	else
	{
		 element1 = ElementMethods.findElementMethod(object1,driver);
	}
	Actions act =new Actions(driver);
	if(action.equalsIgnoreCase("mousehover"))
	{
		act.moveToElement(element1).perform();
	}
	else if(action.equalsIgnoreCase("draganddrop"))
	{
		act.dragAndDrop(element1, element2).perform();
	}
	else if(action.equalsIgnoreCase("doubleclick"))
	{
		act.doubleClick(element1).perform();
	}
	else if(action.equalsIgnoreCase("contextclick"))
	{
		act.contextClick(element1).perform();
	}
	
	}
	

}
