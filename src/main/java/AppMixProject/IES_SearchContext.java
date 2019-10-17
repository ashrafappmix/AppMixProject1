package AppMixProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.mainpackage.BaseClass;

public class IES_SearchContext extends BaseClass {
	@BeforeMethod
	public void setup() {
		initialization();
	}

	@Test
	public void Search_Result() throws InterruptedException {
		driver.findElement(By.id("txtUserName")).sendKeys("Ashraf");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("Ashraf2019");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		Select Case_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlCase']")));
		List<WebElement> Case_list = Case_dropdown.getOptions();
		int Case_size = Case_list.size();
		for (int i = 0; i < Case_size; i++) {
			String case_name = Case_list.get(i).getText();
			if (case_name.equals("HPAE")) {
				Case_dropdown.selectByIndex(i);
				break;
			}
		}
		Select Location_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlLocation']")));
		List<WebElement> Location_list = Location_dropdown.getOptions();
		int Location_size = Location_list.size();
		for (int i = 0; i < Location_size; i++) {
			String location_name = Location_list.get(i).getText();
			if (location_name.equals("HPEA Payroll Location")) {
				Location_dropdown.selectByIndex(i);
				break;
			}

		}
		// Search Results
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(2000);
		List<WebElement> radioButton_list = driver.findElements(
				By.xpath("//div[@class='col-sm-8']//div[@class='form-group']//span/descendant::input[@type='radio']"));
		for (int i=0; i<radioButton_list.size();i++ ) {
			radioButton_list = driver.findElements(
					By.xpath("//div[@class='col-sm-8']//div[@class='form-group']//span/descendant::input[@type='radio']"));
			if(radioButton_list.get(i).isDisplayed()||radioButton_list.get(i).isSelected()) {
				radioButton_list.get(i).click();
			}
			String Name_content = radioButton_list.get(i).findElement(By.xpath("//span["+i+"]/label")).getText();
			switch (Name_content) {
			case "First Name":
				driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys("A");
				Thread.sleep(2000);
				List<WebElement> first_list = driver.findElements(
						By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
				for (WebElement first_name : first_list) {
					String name = first_name.getText();
					if (name.contains("Ashraf Test")) {
						first_name.click();
						break;
					}

				}
				driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
				break;

			case "Last Name":
				driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys("Test");
				Thread.sleep(2000);
				List<WebElement> lastName_list = driver.findElements(
						By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
				for (int j = 0; j < lastName_list.size(); j++) {
					String last_name = lastName_list.get(j).getText();
					System.out.println(last_name);
					if (last_name.contains("Ashraf Test")) {
						lastName_list.get(j).click();
						break;
					}

				}
				driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
				break;

			case "Last 4 Digits SSN":
				driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys("8");
				Thread.sleep(2000);
				List<WebElement> SSN_list = driver.findElements(
						By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
				for (int j = 0; j < SSN_list.size(); j++) {
					String SSN_name = SSN_list.get(j).getText();
					System.out.println(SSN_name);
					if (SSN_name.contains("Ashraf Test")) {
						SSN_list.get(j).click();
						break;
					}

				}
				driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
				break;

			case "Employee Number":
				driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys("8");
				Thread.sleep(2000);
				List<WebElement> EmployeeNumber_list = driver.findElements(
						By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
				for (int j = 0; j < EmployeeNumber_list.size(); j++) {
					String EmployeeNumber_name = EmployeeNumber_list.get(j).getText();
					System.out.println(EmployeeNumber_name);
					if (EmployeeNumber_name.contains("Ashraf Test")) {
						EmployeeNumber_list.get(j).click();
						break;
					}

				}
				driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
				break;

			}
		}

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.quit();
	}

}
