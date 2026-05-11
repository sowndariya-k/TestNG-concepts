package practice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadPDF {

	public static void main(String[] args) throws Exception {

		String downloadpath = System.getProperty("user.dir")
				+ File.separator + "downloads";

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", downloadpath);

		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://freetestdata.com/document-files/pdf/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.fc-dialog-overlay')?.remove();");

		js.executeScript("document.querySelector('.fc-monetization-dialog-container')?.remove();");

		Thread.sleep(2000);

		WebElement downloadBtn = driver.findElement(By.xpath("//a[contains(@href,'.pdf')]"));
		js.executeScript("arguments[0].click();", downloadBtn);
		Thread.sleep(5000);
		File file = new File(downloadpath + "/Free_Test_Data_100KB_PDF.pdf");

		if (file.exists()) {

			System.out.println("PDF Downloaded");

		} else {

			System.out.println("Download Failed");
		}

		driver.quit();
	}
}