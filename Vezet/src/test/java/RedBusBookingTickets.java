import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vezet.generic.Core;
import com.vezet.methods.ElementMethods;

public class RedBusBookingTickets extends Core{
	@Test
	public void bookingTicketsForNextThreeMonths() throws InterruptedException
	{
		
		ElementMethods.sendDataToElement("FromDate", f.driver, "Madiwala, Bangalore");
		ElementMethods.sendDataToElement("ToDate", f.driver,"Borivali East, Mumbai");
		Thread.sleep(2000);
		LocalDate FromDate = LocalDate.now().plusDays(100);
		DateTimeFormatter form = DateTimeFormatter.ofPattern("MMM yyyy");
		String s = form.format(FromDate);
		int date = FromDate.getDayOfMonth();
		System.out.println(s);
		ElementMethods.clickOnElement("FromCalender", f.driver);
		String presentMonth = ElementMethods.findElementMethod("PresentMonTitle", f.driver).getText();
		while(!presentMonth.contains("Dec 2019"))
		{
			try {

			       ElementMethods.findElementMethod("FromCalenderNextbutton", f.driver).click();
					Thread.sleep(2000);
					presentMonth = ElementMethods.findElementMethod("PresentMonTitle", f.driver).getText();
					
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		f.driver.findElement(By.xpath("(//td[text()="+date+"])[2]")).click();
		
			
		
	}
}
	

