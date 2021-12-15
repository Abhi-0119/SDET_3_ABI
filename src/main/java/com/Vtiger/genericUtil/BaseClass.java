package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public  WebDriver driver;
	public LoginPage lp;
	public WebDriverUtil webutil;
	public static WebDriver sdriver;


	@BeforeSuite(groups = {"smokeTest"})
	public void setUp() 
	{
		System.out.println("Connect to DB");

	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest"})
	public void launchBrowser_URL() throws IOException {
		String bname=FileUtil.objforfileutil().readDatafromPropfile("browser");
		//Launch browser
		if(bname.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			sdriver = new ChromeDriver();
		}
		else if(bname.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			sdriver = new FirefoxDriver();
		}
		else if(bname.equals("ie")) 
		{
			WebDriverManager.iedriver().setup();
			sdriver = new InternetExplorerDriver();
		}
		else 
		{
			WebDriverManager.chromedriver().setup();
			sdriver = new ChromeDriver();
		}
		driver=sdriver;
		//get url
		driver.get(FileUtil.objforfileutil().readDatafromPropfile("url"));
		//Maximise window and wait
		webutil = new WebDriverUtil(driver);
		webutil.maximisewindow();
		webutil.pageloadtimeout();
		lp = new LoginPage(driver);
		sdriver=driver;
	}

	@BeforeMethod(groups = {"smokeTest"})
	public void logintoApp() throws IOException 
	{
		//Login to app

		lp.logintoApp();

	}

	@AfterMethod(groups = {"smokeTest"})
	public void logoutfromApp() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		hp.logOutfromApp();
	}

	@AfterClass(groups ={"smokeTest","RegressionTest"})
	public void tearDown() throws InterruptedException 
	{

		Thread.sleep(1000);
		driver.close();
	}
	@AfterSuite(groups = {"smokeTest"})
	public void disconnectfromDB() {
		System.out.println("Disconnect");
	}
	
	public static void takeScreenshot(String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);
	}


}
