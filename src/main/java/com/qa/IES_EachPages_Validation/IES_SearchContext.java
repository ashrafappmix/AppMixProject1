package com.qa.IES_EachPages_Validation;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.mainpackage.BaseClass;

public class IES_SearchContext extends BaseClass {

	public IES_SearchContext() {
		super(1);
	}

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
		int rowc;

		rowc = wso.getLastRowNum();

		for (int i = 0; i < rowc; i++) {
			try {
				if (i == 0) {

					continue;
				}
				r = wso.getRow(i);
				Cell cell = r.getCell(0);
				String value_Content = formatter.formatCellValue(cell);
				for (int j = 0; j < radioButton_list.size(); j++) {
					radioButton_list = driver.findElements(By.xpath(
							"//div[@class='col-sm-8']//div[@class='form-group']//span/descendant::input[@type='radio']"));
					radioButton_list.get(j).click();

					switch (j) {
					case 0:

						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(value_Content);
						Thread.sleep(2000);
						List<WebElement> first_list = driver.findElements(
								By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
						System.out.println(first_list.size());
						if (first_list.size() != 0) {
							for (int k = 0; k < first_list.size(); k++) {
								String firstName = first_list.get(k).getText();
								if (firstName.contains("Ashraf Test")) {
									first_list.get(k).click();
									break;
								}

							}
						} else if (first_list.size() == 0) {

							driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(Keys.ENTER);
						}
						driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).clear();
						break;

					case 1:
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(value_Content);
						Thread.sleep(2000);
						List<WebElement> lastName_list = driver.findElements(
								By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
						if (lastName_list.size() != 0) {
							for (int m = 0; m < lastName_list.size(); m++) {
								String last_name = lastName_list.get(m).getText();
								System.out.println(last_name);
								if (last_name.contains("Ashraf Test")) {
									lastName_list.get(m).click();
									break;
								}

							}
						} else if (lastName_list.size() == 0) {

							driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(Keys.ENTER);
						}
						driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).clear();
						break;

					case 2:
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(value_Content);
						Thread.sleep(2000);
						List<WebElement> SSN_list = driver.findElements(
								By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
						System.out.println(SSN_list.size());
						if (SSN_list.size() != 0) {
							for (int n = 0; n < SSN_list.size(); n++) {
								radioButton_list = driver.findElements(By.xpath(
										"//div[@class='col-sm-8']//div[@class='form-group']//span/descendant::input[@type='radio']"));
								SSN_list = driver.findElements(By.xpath(
										"//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
								System.out.println(SSN_list.size());
								String SSN_name = SSN_list.get(n).getText();
								System.out.println(SSN_name);

								if (SSN_name.contains("Pratik Test")) {
									SSN_list.get(n).click();
									break;
								}
							}
						} else if (SSN_list.size() == 0) {

							driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(Keys.ENTER);
						}
						driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).clear();
						break;

					case 3:
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(value_Content);
						Thread.sleep(2000);
						List<WebElement> EmployeeNumber_list = driver.findElements(
								By.xpath("//ul[@id='ui-id-1']//li/descendant::div[@class='ui-menu-item-wrapper']"));
						if (EmployeeNumber_list.size() != 0) {
							for (int e = 0; e < EmployeeNumber_list.size(); e++) {
								String EmployeeNumber_name = EmployeeNumber_list.get(e).getText();
								System.out.println(EmployeeNumber_name);
								if (EmployeeNumber_name.contains("Ashraf Test")) {
									EmployeeNumber_list.get(e).click();
									break;
								}

							}
						} else if (EmployeeNumber_list.size() == 0) {

							driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).sendKeys(Keys.ENTER);
						}
						driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
						driver.findElement(By.id("ContentPlaceHolder1_txtSearch")).clear();
						break;

					}
				}
			} catch (NullPointerException NPE) {
				System.out.println("Blank Value is Passed");
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
