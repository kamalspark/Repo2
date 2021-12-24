package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public WebDriver driver;

	public void browserlaunch() {
		System.setProperty("webdriver.chrome.driver",
				"/home/naveen/eclipse-workspace/Cloud/December24/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
	}
	
	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public void newwindow(String newwindowxpath, String verifyxpath, String pagecontent) {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath(newwindowxpath)).click();
		for (String childwindow : driver.getWindowHandles()) {
			driver.switchTo().window(childwindow);
		}
		String verifytext = driver.findElement(By.xpath(verifyxpath)).getText();
		verifytext.contentEquals(pagecontent);
		driver.close();
		driver.switchTo().window(parentwindow);
	}
	public void iframe(String iframeElementxpath) {
		WebElement iframe = driver.findElement(By.xpath(".//iframe[@id='courses-iframe']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath(iframeElementxpath)).click();
		driver.switchTo().defaultContent();
	}
	

}
