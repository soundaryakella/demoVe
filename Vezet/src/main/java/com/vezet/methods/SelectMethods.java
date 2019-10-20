package com.vezet.methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class SelectMethods {
	//method to select using visibleText
	public static void selectTheValueFromTheDropDownList(String object,WebDriver driver,String valueToBeSelected)
	{
		WebElement element = ElementMethods.findElementMethod(object, driver);
		Select sel=new Select(element);
		sel.selectByVisibleText(valueToBeSelected);	
	}
	
	//method to select using index (overloading)
	public static void selectTheValueFromTheDropDownList(String object,WebDriver driver,int index)
	{
		WebElement element = ElementMethods.findElementMethod(object, driver);
		Select sel=new Select(element);
		sel.selectByIndex(index);	
	}
	
	//method to deselect the option using visible Text
	public static void deSelectTheValueFromTheDropDownList(String object,WebDriver driver,String valueToBeSelected)
	{
		WebElement element = ElementMethods.findElementMethod(object, driver);
		Select sel=new Select(element);
		if(sel.isMultiple())
		{
			sel.deselectByVisibleText(valueToBeSelected);
		}
		else
		{
			Reporter.log("The list is not multiple select. Can't be deselect",true);
		}
		
	}
	//method to deselect the option using index(overloading)
		public static void deSelectTheValueFromTheDropDownList(String object,WebDriver driver,int index)
		{
			WebElement element = ElementMethods.findElementMethod(object, driver);
			Select sel=new Select(element);
			if(sel.isMultiple())
			{
				sel.deselectByIndex(index);
			}
			else
			{
				Reporter.log("The list is not multiple select. Can't be deselect",true);
			}
			;
		}
		
		//method to get the all options from present in listbox
		public static List<WebElement> getOptionsFromTheListBox(String object,WebDriver driver)
		{
			WebElement element = ElementMethods.findElementMethod(object, driver);
			Select sel=new Select(element);
			List<WebElement> list = sel.getOptions();
			return list;
		}
		
		//method to deselect all the options present in the list
		public static void deSelectAllTheOptionsFromList(String object,WebDriver driver)
		{
			WebElement element = ElementMethods.findElementMethod(object, driver);
			Select sel=new Select(element);
			if(sel.isMultiple())
			{
				sel.deselectAll();
			}
			else
			{
				Reporter.log("The list is not multiple select and can't be deselected",true);
			}
		}
		
		//method checkTheListIsMultipleSelectOrNot
		public static boolean checkTheListIsMultipleSelectOrNot(String object,WebDriver driver)
		{
			WebElement element = ElementMethods.findElementMethod(object, driver);
			Select sel=new Select(element);
			return sel.isMultiple();
		}
		
		//method to get the options selected from list
		public static List<WebElement> getAllSelectedOptions(String object,WebDriver driver)
		{
			WebElement element = ElementMethods.findElementMethod(object, driver);
			Select sel=new Select(element);
			List<WebElement> list = sel.getAllSelectedOptions();
			return list;
		}
	

}
