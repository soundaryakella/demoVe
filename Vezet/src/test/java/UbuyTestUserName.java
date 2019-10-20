import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vezet.generic.Core;
import com.vezet.methods.ActionsMethods;
import com.vezet.methods.ElementMethods;
import com.vezet.methods.ListenersMethods;

@Listeners(ListenersMethods.class)
public class UbuyTestUserName extends Core {
	@Test
	public void ValidateName() throws InterruptedException
	{
		
		ActionsMethods.performActions("Account", null, f.driver, "mousehover");
		Thread.sleep(2000);
		ElementMethods.clickOnElement("signin",f.driver);
		Thread.sleep(2000);
	    Assert.assertEquals(f.driver.getTitle(),"Customer Login");
		ElementMethods.sendDataToElement("username",f.driver,"soundaryakella@gmail.com");
		ElementMethods.sendDataToElement("password",f.driver,"soundhu1234");
		ElementMethods.clickOnElement("loginBTN",f.driver);
		Thread.sleep(2000);
		String actualName = ElementMethods.findElementMethod("actualdisplayeduser", f.driver).getText();
		Thread.sleep(2000);
		Assert.assertEquals(actualName,"SOUNDARYA .," );
		
	}
	

}
