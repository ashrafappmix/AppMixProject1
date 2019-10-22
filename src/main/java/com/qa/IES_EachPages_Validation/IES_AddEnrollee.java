package com.qa.IES_EachPages_Validation;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utils.Utilities;
import com.qa.mainpackage.BaseClass;

public class IES_AddEnrollee extends BaseClass {

	WebElement SSN_Web;
	// String sheetName = "Enrolle";
	String sheetName = "IES_HPAE";
	Select select;

	@BeforeMethod
	public void setup() {

		initialization();
	}

	@DataProvider
	public Object[][] getEnrolleeTestData() {
		Object[][] data = Utilities.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getEnrolleeTestData")
	public void Enrolle_Addition(String First_Name, String Middle_Name, String Last_Name, String Address,
			String Address2, String City, String Zip_Code, String SSN, String Date_of_Birth, String Cell_Phone,
			String Email, String Weight, String Date_of_Hire, String Occupation, String Annual_Salary)
			throws InterruptedException {
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
//			if (case_name.equals("Appmix CLEAT")) {
//				Case_dropdown.selectByIndex(i);
//				break;
//			}
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
//			if (location_name.equals("Central Headquarter")) {
//				Location_dropdown.selectByIndex(i);
//				break;
//			}

		}
		// Search Results
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("ContentPlaceHolder1_btnAdd")).click();
		try {
			driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			try {
				
				driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);

			
				driver.findElement(By.id("ContentPlaceHolder1_txtMI")).sendKeys(Middle_Name);

				
				driver.findElement(By.id("ContentPlaceHolder1_txtLastName")).sendKeys(Last_Name);

				
				driver.findElement(By.id("ContentPlaceHolder1_txtAddress")).sendKeys(Address);

		
				driver.findElement(By.id("ContentPlaceHolder1_txtAddress2")).sendKeys(Address2);

				driver.findElement(By.id("ContentPlaceHolder1_txtCity")).sendKeys(City);

				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
				select.selectByVisibleText("Indiana");
				driver.findElement(By.id("ContentPlaceHolder1_txtZipCode")).sendKeys(Zip_Code);
				SSN_Web = driver.findElement(By.id("ContentPlaceHolder1_txtSSN"));
				jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);

//			DOB = driver.findElement(By.id("ContentPlaceHolder1_txtMDOB"));
//			jse.executeScript("arguments[0].value=' " + Date_of_Birth + " ';", DOB);
				jse.executeScript(
						"document.getElementById('ContentPlaceHolder1_txtMDOB').value='" + Date_of_Birth + "';");
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlGender")));
				select.selectByVisibleText("Male");

				driver.findElement(By.id("ContentPlaceHolder1_txtCellPhone")).sendKeys(Cell_Phone);

				driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys(Email);
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlHeightFt")));
				select.selectByValue("4");
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlHeightIn")));
				select.selectByValue("6");
				driver.findElement(By.id("ContentPlaceHolder1_txtWieght")).sendKeys(Weight);
				jse.executeScript(
						"document.getElementById('ContentPlaceHolder1_txtMHireDate').value='" + Date_of_Hire + "';");
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlLocation")));
				select.selectByVisibleText("Location One");

				driver.findElement(By.id("ContentPlaceHolder1_txtOccupation")).sendKeys(Occupation);
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlPayFrquency")));
				select.selectByVisibleText("Weekly");
				driver.findElement(By.id("ContentPlaceHolder1_txtAnnualCompensation")).sendKeys(Annual_Salary);
				select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlTobaco")));
				select.selectByValue("N");
				driver.findElement(By.id("ContentPlaceHolder1_btnSaveAndContinue")).click();
//				driver.findElement(By.id("ContentPlaceHolder1_ucNavigation1_imgSearch")).click();
//				driver.findElement(By.id("ContentPlaceHolder1_btnAdd")).click();
			} catch (UnhandledAlertException e) {
				e.printStackTrace();
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NullPointerException |NoAlertPresentException e) {
				driver.switchTo().alert().accept();

			}
		}
//		try {
//			driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);
//
//		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).sendKeys(First_Name);
//			driver.findElement(By.id("ContentPlaceHolder1_txtMI")).sendKeys(Middle_Name);
//			driver.findElement(By.id("ContentPlaceHolder1_txtLastName")).sendKeys(Last_Name);
//			driver.findElement(By.id("ContentPlaceHolder1_txtAddress")).sendKeys(Address);
//			driver.findElement(By.id("ContentPlaceHolder1_txtAddress2")).sendKeys(Address2);
//			driver.findElement(By.id("ContentPlaceHolder1_txtCity")).sendKeys(City);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
//			select.selectByVisibleText("Indiana");
//			driver.findElement(By.id("ContentPlaceHolder1_txtZipCode")).sendKeys(Zip_Code);
//			SSN_Web = driver.findElement(By.id("ContentPlaceHolder1_txtSSN"));
//			jse.executeScript("arguments[0].value='" + SSN + "';", SSN_Web);
//			DOB = driver.findElement(By.id("ContentPlaceHolder1_txtMDOB"));
//			jse.executeScript("arguments[0].value=' " + Date_of_Birth + " ';", DOB);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlGender")));
//			select.selectByVisibleText("Male");
//			driver.findElement(By.id("ContentPlaceHolder1_txtCellPhone")).sendKeys(Cell_Phone);
//			driver.findElement(By.id("ContentPlaceHolder1_txtEmail")).sendKeys(Email);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlHeightFt")));
//			select.selectByValue("4");
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlHeightIn")));
//			select.selectByValue("6");
//			driver.findElement(By.id("ContentPlaceHolder1_txtWieght")).sendKeys(Weight);
//			DOH = driver.findElement(By.id("ContentPlaceHolder1_txtMHireDate"));
//			jse.executeScript("arguments[0].value=' " + Date_of_Hire + " ';", DOH);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlLocation")));
//			select.selectByVisibleText("The Store in Texas");
//			driver.findElement(By.id("ContentPlaceHolder1_txtMemberId")).sendKeys(Employee_Id);
//			driver.findElement(By.id("ContentPlaceHolder1_txtOccupation")).sendKeys(Occupation);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlPayFrquency")));
//			select.selectByVisibleText("Semi-monthly");
//			driver.findElement(By.id("ContentPlaceHolder1_txtAnnualCompensation")).sendKeys(Annual_Salary);
//			driver.findElement(By.id("ContentPlaceHolder1_txtDepartmentNumber"))
//					.sendKeys(Business_Unit_Department_Number);
//			select = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlTobaco")));
//			select.selectByValue("N");
//			driver.findElement(By.id("ContentPlaceHolder1_btnSaveAndContinue")).click();
//		}
	}

//	@AfterMethod
//	public void teardown() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
//		driver.quit();
//	}
}