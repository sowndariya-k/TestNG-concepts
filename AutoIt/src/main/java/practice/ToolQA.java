package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ToolQA {
	public static void main(String arg[]) {
		ChromeOptions options=new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/upload-download");
		WebElement choosen = driver.findElement(By.cssSelector("#uploadFile"));
		choosen.sendKeys("C:\\Users\\Sowndariya\\Desktop\\Sowndariya_Expleo(LOI).pdf");
		String msg=driver.findElement(By.id("uploadedFilePath")).getText();
		System.out.println("the message was:"+msg);
		driver.close();
		
	}

}
