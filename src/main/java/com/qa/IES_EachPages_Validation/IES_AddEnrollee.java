package com.qa.IES_EachPages_Validation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utils.Utilities;
import com.qa.mainpackage.BaseClass;

public class IES_AddEnrollee extends BaseClass {

	WebElement SSN_Web;
	WebElement DOB;
	String sheetName = "Enrolle";

	@BeforeMethod
	public void setup() {

		initialization();
	}

	@DataProvider
	public Object[][] getEnrolleeTestData() {
		Object data[][] = Utilities.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getEnrolleeTestData")
	public void Enrolle_Addition(String First_Name, String Middle_Name, String Last_Name, String Address,
			String Address2, String City, String Zip_Code, String SSN, String Date_of_Birth, String Cell_Phone,
			String Email, String Weight, String Employee_Id, String Occupation, String Annual_Salary,
			String Business_Unit_Department_Number) throws InterruptedException {

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
			if (case_name.equals("Appmix CLEAT")) {
				Case_dropdown.selectByIndex(i);
				break;
			}
		}
		Select Location_dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddlLocation']")));
		List<WebElement> Location_list = Location_dropdown.getOptions();
		int Location_size = Location_list.size();
		for (int i = 0; i < Location_size; i++) {
			String location_name = Location_list.get(i).getText();
			if (location_name.equals("Central Headquarter")) {
				Location_dropdown.selectByIndex(i);
				break;
			}

		}
		// Search Results
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolder1_btnAdd")).click();
		try {
	driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);
//		driver.findElement(By.id("ContentPlaceHolder1_txtMI")).sendKeys(Middle_Name);
//		driver.findElement(By.id("ContentPlaceHolder1_txtLastName")).sendKeys(Last_Name);
//		driver.findElement(By.id("ContentPlaceHolder1_txtAddress")).sendKeys(Address);
//		driver.findElement(By.id("ContentPlaceHolder1_txtAddress2")).sendKeys(Address2);
//		driver.findElement(By.id("ContentPlaceHolder1_txtCity")).sendKeys(City);
//		driver.findElement(By.id("ContentPlaceHolder1_txtZipCode")).sendKeys(Zip_Code);
//		SSN_Web = driver.findElement(By.id("ContentPlaceHolder1_txtSSN"));
//		jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
//		DOB = driver.findElement(By.id("ContentPlaceHolder1_txtMDOB"));
//		jse.executeScript("arguments[0].value=' " + Date_of_Birth + " ';", DOB);
//		driver.findElement(By.id("ContentPlaceHolder1_txtCellPhone")).sendKeys(Cell_Phone);
//		driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys(Email);
//		driver.findElement(By.id("ContentPlaceHolder1_txtWieght")).sendKeys(Weight);
//		driver.findElement(By.id("ContentPlaceHolder1_txtMemberId")).sendKeys(Employee_Id);
//		driver.findElement(By.id("ContentPlaceHolder1_txtOccupation")).sendKeys(Occupation);
//		driver.findElement(By.id("ContentPlaceHolder1_txtAnnualCompensation")).sendKeys(Annual_Salary);
//		driver.findElement(By.id("ContentPlaceHolder1_txtDepartmentNumber")).sendKeys(Business_Unit_Department_Number);
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {

			driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);
			driver.findElement(By.id("ContentPlaceHolder1_txtMI")).sendKeys(Middle_Name);
			driver.findElement(By.id("ContentPlaceHolder1_txtLastName")).sendKeys(Last_Name);
			driver.findElement(By.id("ContentPlaceHolder1_txtAddress")).sendKeys(Address);
			driver.findElement(By.id("ContentPlaceHolder1_txtAddress2")).sendKeys(Address2);
			driver.findElement(By.id("ContentPlaceHolder1_txtCity")).sendKeys(City);
			driver.findElement(By.id("ContentPlaceHolder1_txtZipCode")).sendKeys(Zip_Code);
			SSN_Web = driver.findElement(By.id("ContentPlaceHolder1_txtSSN"));
			jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
			DOB = driver.findElement(By.id("ContentPlaceHolder1_txtMDOB"));
			jse.executeScript("arguments[0].value=' " + Date_of_Birth + " ';", DOB);
			driver.findElement(By.id("ContentPlaceHolder1_txtCellPhone")).sendKeys(Cell_Phone);
			driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys(Email);
			driver.findElement(By.id("ContentPlaceHolder1_txtWieght")).sendKeys(Weight);
			driver.findElement(By.id("ContentPlaceHolder1_txtMemberId")).sendKeys(Employee_Id);
			driver.findElement(By.id("ContentPlaceHolder1_txtOccupation")).sendKeys(Occupation);
			driver.findElement(By.id("ContentPlaceHolder1_txtAnnualCompensation")).sendKeys(Annual_Salary);
			driver.findElement(By.id("ContentPlaceHolder1_txtDepartmentNumber")).sendKeys(Business_Unit_Department_Number);
				
			
		}
	}

//	@AfterMethod
//	public void teardown() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
//		driver.quit();
//	}
}