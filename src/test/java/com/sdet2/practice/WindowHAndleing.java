package com.sdet2.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.genericUtil.WebDriverUtil;

public class WindowHAndleing {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://naukri.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		

		Set<String> winids = driver.getWindowHandles();
		for(String id: winids) 
		{
			String currenttitle=driver.switchTo().window(id).getTitle()	;
			System.out.println(currenttitle);
			//			if(currenttitle.equalsIgnoreCase(title)) 
			//			{
			//				break;
			//			}

			//		WebDriverUtil util = new WebDriverUtil(driver);
			//		util.switchTowindow("Cognizant");
			//		driver.manage().window().maximize();

		}
	}
}
