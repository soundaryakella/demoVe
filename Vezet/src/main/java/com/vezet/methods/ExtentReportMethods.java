package com.vezet.methods;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vezet.generic.Flexibles;

public class ExtentReportMethods extends Flexibles {
	public static void ExtentReportMethod()
	{
		String filepath = "D:\\soundarya\\Vezet\\Ex.html";
		Flexibles.report=new ExtentHtmlReporter(new File(filepath));
		Flexibles.extent=new ExtentReports();
		extent.attachReporter(report);
	}

}
