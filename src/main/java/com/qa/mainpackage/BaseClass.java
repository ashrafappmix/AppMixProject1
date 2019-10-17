package com.qa.mainpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public static WebDriver driver;
	public String Alerts;
	public FileInputStream fs;
	public XSSFWorkbook wbo;
	public XSSFSheet wso;
	public FileOutputStream fo;
	public Row r;
	public DataFormatter formatter;

	public BaseClass() {
		try {
			fs = new FileInputStream(
					"C:\\Users\\Ashraf\\eclipse-workspace\\AppMixProject\\src\\main\\java\\com\\qa\\data\\LoginData.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wbo = new XSSFWorkbook(fs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wso = wbo.getSheet("Sheet1");

	}

	public BaseClass(int num) {
		try {
			fs = new FileInputStream(
					"C:\\Users\\Ashraf\\eclipse-workspace\\AppMixProject\\src\\main\\java\\com\\qa\\data\\SearchData.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wbo = new XSSFWorkbook(fs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wso = wbo.getSheet("Sheet1");
		formatter = new DataFormatter();
	}

	

	public static void initialization() {
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashraf\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(coptions);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://web-dev.ieswebservices.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
