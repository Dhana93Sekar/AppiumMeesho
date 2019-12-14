package com.meesho.androidapp.lib.reports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.meesho.androidapp.lib.generic.BaseConfig;
import com.meesho.androidapp.lib.generic.MobileActionUtils;

public class EventListeners implements ITestListener
{

@Override
	public void onStart(ITestContext context)
	{
		ExtReportsManager.report(context);
		ExtReportsManager.testlog.log(Status.INFO, context.getName()+"suite is started");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ExtReportsManager.testlog.log(Status.FAIL, result.getName()+" failed");
		System.out.println("Test Execution failed"+result.FAILURE+result.getName());
		try {
			String dest = MobileActionUtils.captureScreenshot(BaseConfig.gv.driver, result.getName());
			ExtReportsManager.testlog.addScreenCaptureFromPath(dest+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtReportsManager.testlog.log(Status.SKIP, result.getName()+" is skipped");
		System.out.println("Test Skipped"+result.SKIP+result.getName()+" is skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtReportsManager.testlog.log(Status.INFO, "Test Started Succesfully "+result.getName()+" is started");
		System.out.println("Test Started"+result.STARTED+result.getName()+" is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtReportsManager.testlog.log(Status.PASS, "Test Passed"+result.getName()+" is success");
		System.out.println("onTestSuccess"+result.SUCCESS+result.getName()+" is success");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtReportsManager.report.flush();
		ExtReportsManager.testlog.log(Status.INFO, context.getName()+" Suite is Completed");
	}
}