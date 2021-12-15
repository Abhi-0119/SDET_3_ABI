package com.Vtiger.TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.ContactInfoPage;
import com.Vtiger.POMClasses.ContactOrg_popup;
import com.Vtiger.POMClasses.CreateContactPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtil;



public class TC003_CreateContactWithOrgTest extends BaseClass {

	
	@Test(groups="RegressionTest")
	public void createcontactwithorg() throws InterruptedException {
		//Navigate to Contacts
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getCreatecontactsimg().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastNameEdt().sendKeys(JavaUtil.objforJavaUtil().getFirstName());
		ccp.getOrganizationLookUpImage().click();

		webutil.switchTowindow("contact");
		ContactOrg_popup popup= new ContactOrg_popup(driver);
		popup.getSearchorgtxtfld().sendKeys("SDET3");
		popup.getSearchbtn().click();
		popup.getSelectorg().click();

		webutil.switchTowindow("Administrator");
		ccp.getSaveBtn().click();

		//Validating
		driver.navigate().refresh();
		Thread.sleep(3000);
		hp.getContactslink().click();
		cip.getSearchcontacttxtfld().sendKeys("SDET3");

		webutil.selectValuefromDD("Organization Name", cip.getSearchforcontactDD());
		cip.getSearchcontactbtn().click();

		WebElement element=driver.findElement(By.xpath("//a[@title='Organizations']"));

		Assert.assertEquals("SDET3", element.getText());
	}
	@Test(groups="smokeTest")
	public void createcontact() throws InterruptedException {

		//Navigate to Contacts
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getCreatecontactsimg().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		String name=JavaUtil.objforJavaUtil().getFirstName();
		ccp.getLastNameEdt().sendKeys(name);
		
		ccp.getSaveBtn().click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		hp.getContactslink().click();
		Thread.sleep(2000);
		cip.getSearchcontacttxtfld().sendKeys(name);

		webutil.selectValuefromDD("Last Name", cip.getSearchforcontactDD());
		cip.getSearchcontactbtn().click();

		WebElement element=driver.findElement(By.xpath("//a[@title='Contacts' and text()='"+name+"']"));

		Assert.assertEquals(element.getText(), name);
	}
}
