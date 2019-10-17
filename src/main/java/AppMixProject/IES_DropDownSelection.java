package AppMixProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.mainpackage.BaseClass;

public class IES_DropDownSelection extends BaseClass {

	@BeforeMethod
	public void setup() {
		initialization();
	}

	@Test
	public void Select_Multi_dropdown() throws InterruptedException {

		driver.findElement(By.id("txtUserName")).sendKeys("Ashraf");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("Ashraf2019");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		try {

			Select Case_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlCase']")));
			List<WebElement> Case_list = Case_dropdown.getOptions();
			int Case_size = Case_list.size();
			System.out.println(Case_size);

			for (int i = 0; i < Case_size; i++) {
				Case_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlCase']")));
				Case_list = Case_dropdown.getOptions();
				if (i == 0) {

					continue;
				}
				String case_name = Case_list.get(i).getText();
				System.out.println(case_name);
				Case_dropdown.selectByIndex(i);
				Select Location_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlLocation']")));
				List<WebElement> Location_list = Location_dropdown.getOptions();
				int Location_size = Location_list.size();
				for (int j = 0; j < Location_size; j++) {
					Location_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlLocation']")));
					Location_list = Location_dropdown.getOptions();
					if (j == 0) {

						continue;
					}
					String location_name = Location_list.get(j).getText();
					System.out.println(location_name);
					Location_dropdown.selectByIndex(j);
					Thread.sleep(2000);

				}

			}
		} catch (StaleElementReferenceException e) {

		}

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
