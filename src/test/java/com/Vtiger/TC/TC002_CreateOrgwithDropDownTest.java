package com.Vtiger.TC;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateOrgPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtil;

public class TC002_CreateOrgwithDropDownTest extends BaseClass  {

	@Test(groups="RegressionTest")
	public void CreateorgwithDD() throws InterruptedException, EncryptedDocumentException, IOException {

		//Navigate to organizations

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		String Orgname=JavaUtil.objforJavaUtil().getFirstName()+JavaUtil.objforJavaUtil().generateRandomNumber();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getcreateorgnametxtfld().sendKeys(Orgname);

		webutil.selectValuefromDD(cop.getIndustry(), "Technology");

		webutil.selectValuefromDD(cop.getType(), "Analyst");

		webutil.selectValuefromDD(cop.getRating(), "Active");

		cop.getSaveorgbtn().click();

		//refresh
		driver.navigate().refresh();
		hp.getOrglink().click();


		//Validating
		orginfopage.searchfororg(Orgname, "Organization Name");

		WebElement orgname=null;

		orgname	=driver.findElement(By.xpath("//a[text()='"+Orgname+"' and @title='Organizations']"));
		
	
		Assert.assertEquals(orgname.isDisplayed(), true);

		String actual=orgname.getText();
		Assert.assertEquals(Orgname, actual);

	}

}
