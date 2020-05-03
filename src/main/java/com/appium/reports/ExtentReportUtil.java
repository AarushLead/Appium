package com.appium.reports;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.appium.baseother.ApiDemosBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil extends ApiDemosBase implements ITestListener {

	private ExtentHtmlReporter htmlReporter;
	private ExtentReports report;
	private ExtentTest test;
	private File reportPath;
	private String hostName;
	private String ipAddress;

	@Override
	public void onStart(ITestContext context) {
		String reportPathStr = System.getProperty("user.dir") + "/reports";
		try {
			hostName = java.net.InetAddress.getLocalHost().getHostName();
			ipAddress = java.net.InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		reportPath = new File(reportPathStr);
		if (!reportPath.exists()) {
			if (reportPath.mkdir()) {
				System.out.println("Report folder created successfully");
			} else {
				throw new RuntimeException("report folder creation  failed at path:"+reportPathStr);
			}
		}
		File reportFile = new File(reportPath, getCurrentDate() + ".html");

		htmlReporter = new ExtentHtmlReporter(reportFile);
		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Script Execution Status");
		htmlReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();

		report.setSystemInfo("OS Name: ", System.getProperty("os.name"));
		report.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
		report.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		report.setSystemInfo("User Name : ", System.getProperty("user.name"));
		report.setSystemInfo("Host name", hostName);
		report.setSystemInfo("IP Address : ", ipAddress);
		report.setSystemInfo("Application Name", "Grossery Store");
		report.setSystemInfo("Environemnt", "QA");

		report.attachReporter(htmlReporter);

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName() + "is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test case PASSED", ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test case FAILED", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-Test case FAILED", ExtentColor.RED));
		try {
			test.fail("Test case snapshot is below" + test.addScreencastFromPath(getScreenShotPath(result.getName())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test case SKIPPED", ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public String getScreenShotPath(String methodname) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshot/" + methodname + "-" + getCurrentDate()
				+ ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Error in the getScreenShotPath method: " + e.getMessage());
		}
		return destination;
	}

	public String getCurrentDate() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}

}
