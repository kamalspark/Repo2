package pac1;

import org.testng.annotations.Test;

public class Program1 extends Main {
	@Test
	public void LaunchanClicks() {
		browserlaunch();
		click(".//label/input[@id='bmwradio']");
		click(".//select/option[@value='bmw']");
		click(".//select/option[@value='apple']");
		newwindow("//button[@id='openwindow']", "//div/h1", "All Courses");
		iframe(".//select/option[@value='2022']");
	}
}
