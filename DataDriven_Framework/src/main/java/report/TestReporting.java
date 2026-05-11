package report;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class TestReporting {

	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		WebDriver driver = new ChromeDriver();
		ExtentTest test = extent.createTest("Google search test");
		try {
			driver.get("https://www.googlecom");
			test.pass("Navigated to Google");
		} catch (Exception e) {
			test.fail("Test failed due to exception: "+e.getMessage());			
		}
		finally {
			driver.quit();
			extent.flush();
		}

	}

}
