package com.vezet.methods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.vezet.generic.Core;
import com.vezet.generic.Flexibles;

public class ListenersMethods  extends ExtentReportMethods implements ITestListener {

	public void onTestStart(ITestResult result) {
	String getTestCaseName = result.getTestClass().getName().toString();
	test=extent.createTest(getTestCaseName);
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test is failed");
		
		String getTestCaseName = result.getTestClass().getName().toString();
		System.out.println(getTestCaseName);
		
		
			try {
				 TakeScreenshotMethods.takeScreenShot(getTestCaseName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentReportMethod();
		
	}

	public void onFinish(ITestContext context) {
		test.log(Status.INFO, "Test is completed");
		extent.flush();
		
		
	}

}
