package IES_EachPages_Validation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.mainpackage.BaseClass;

public class IES_Login extends BaseClass {

	public IES_Login()throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
	}

	@Test
	public void login() throws InterruptedException {

		int rowc;
		rowc = wso.getLastRowNum();
		for (int i = 1; i <= rowc; i++) {
			r = wso.getRow(i);
			try {
				driver.findElement(By.id("txtUsername")).clear();
				driver.findElement(By.id("txtUserName")).sendKeys(r.getCell(0).getStringCellValue());
				Thread.sleep(2000);
				driver.findElement(By.id("txtPassword")).clear();
				driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
				Thread.sleep(2000);
			} catch (NullPointerException NPE) {
				System.out.println("Blank Value is Passed");
			}
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			Thread.sleep(2000);
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				System.out.println("Alert Not present");
			}
			String ExpectedURL = "https://web-dev.ieswebservices.com/CaseSelectionPage.aspx";
			if (driver.getCurrentUrl().equals(ExpectedURL)) {
				r.createCell(2).setCellValue("Pass");
				driver.findElement(By.id("btnCancel")).click();
				/*
				 * driver.navigate().back(); 
				 * driver.switchTo().alert().accept();
				 */

			} else {

				r.createCell(2).setCellValue("Fail");
			}
		}
	}

	@AfterMethod

	public void teardown() {
		try {
			fo = new FileOutputStream("C:\\Users\\Ashraf\\Ashraf Documents\\LoginData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wbo.write(fo);
		} catch (IOException e) {

			e.printStackTrace();
		}

		driver.quit();

	}

}
