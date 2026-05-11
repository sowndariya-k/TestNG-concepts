package practice;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIdPractice {
	public static void main(String args[]) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.get("https://pdf2doc.com/");
		WebElement file= driver.findElement(By.xpath("//span[text()='UPLOAD FILES']"));
		file.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Sowndariya\\Desktop\\demoAutoId\\fileUploadAuto.exe");
		driver.close();
	}
	
}