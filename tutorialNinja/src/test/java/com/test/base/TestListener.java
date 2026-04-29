package com.test.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== Test Suite Started ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Test Suite Finished ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED: " + result.getName());

        ScreenshotUtil.takeScreenshot(BaseTest.driver, result.getName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }
}