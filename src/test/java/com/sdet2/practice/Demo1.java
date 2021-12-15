package com.sdet2.practice;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.sdet2.practice.ListnersImplementation.class)
public class Demo1
{
	public static WebDriver driver;
	@Test(priority = 0)
	public void facebook() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://flipkart.com");
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		Assert.assertEquals("https://facebook.com",currenturl );
	}

	@Test(priority = 1)
	public void amazon() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://myntra.com");
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		Assert.assertEquals("https://facebook.com",currenturl );

	}
	public static  void takeScreenshot(String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);
	}


}
