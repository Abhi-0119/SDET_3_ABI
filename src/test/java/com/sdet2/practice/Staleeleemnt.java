package com.sdet2.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Vtiger.genericUtil.FileUtil;
import com.Vtiger.genericUtil.WebDriverUtil;

public class Staleeleemnt {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		String browser=FileUtil.objforfileutil().readDatafromPropfile("browser");
		//Launch browser
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver= new SafariDriver();
		}
		else
		{
			driver=	new ChromeDriver();
		}	
		//get url
		driver.get(FileUtil.objforfileutil().readDatafromPropfile("url"));
		//Maximise window and wait
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		webdriverutil.maximisewindow();
		webdriverutil.pageloadtimeout();


		//Login to app
		driver.findElement(By.name("user_name")).sendKeys(FileUtil.objforfileutil().readDatafromPropfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FileUtil.objforfileutil().readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//Click on org and create org
		WebElement orglink = driver.findElement(By.xpath("//a[text()='Organizations']"));
		driver.navigate().refresh();
		orglink.click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//String Orgname=JavaUtil.objforJavaUtil().getFirstName()+JavaUtil.objforJavaUtil().generateRandomNumber();

	}

}
