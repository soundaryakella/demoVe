import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vezet.generic.Core;
import com.vezet.methods.ActionsMethods;
import com.vezet.methods.ElementMethods;
import com.vezet.methods.JavaScriptExecutorMethods;
import com.vezet.methods.ListenersMethods;
import com.vezet.methods.SelectMethods;

@Listeners(ListenersMethods.class)
public class Testclass extends Core {
	
	@Test
	public void select() throws IOException, InterruptedException
	{
//		SelectMethods.selectTheValueFromTheDropDownList("multipleSel", f.driver, "Asia");
//		SelectMethods.selectTheValueFromTheDropDownList("multipleSel", f.driver, "Europe");
//		List<WebElement> list = SelectMethods.getAllSelectedOptions("multipleSel",f.driver);
//		for(WebElement l:list)	
//		{
//			System.out.println(l.getText());
//			Assert.assertEquals(l.getText(), "Asa");
//		}
		
//		ActionsMethods.performActions("ringsmenu",null,f.driver,"contextclick");
//		Thread.sleep(2000);
		
//		JavaScriptExecutorMethods.scrollByElement(f.driver, ElementMethods.findElementMethod("viewmoreoptions", f.driver));
//		Thread.sleep(2000);
		JavaScriptExecutorMethods.scrollVertical(f.driver,0, 6000);
		Thread.sleep(2000);
	}

}
