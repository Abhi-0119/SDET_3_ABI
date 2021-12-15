package com.sdet2.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLess_Browser {
	public static void main(String[] args) {

		//HtmlUnitDriver driver= new HtmlUnitDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		WebDriver driver= new ChromeDriver(options);

		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());

	}
}
