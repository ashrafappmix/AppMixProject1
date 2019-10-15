package AppMixProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
	public static WebDriver driver;
	String Alerts;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashraf\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://web-dev.ieswebservices.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void login() {
		do {
			driver.findElement(By.id("txtUserName")).sendKeys("Ashraf");
			driver.findElement(By.id("txtPassword")).sendKeys("Ashraf2018");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			try {
				driver.switchTo().alert().accept();
				break;
			} catch (Exception e) {
				System.out.println("Alert Not present");
				// break;
			}
		} while (driver.getCurrentUrl().equals("https://web-dev.ieswebservices.com"));

		/*
		 * String ExpectedURL =
		 * "https://web-dev.ieswebservices.com/CaseSelectionPage.aspx";
		 * Assert.assertEquals(driver.getCurrentUrl(), ExpectedURL);
		 */

	}

	/*
	 * @AfterMethod
	 * 
	 * public void teardown() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */

}
