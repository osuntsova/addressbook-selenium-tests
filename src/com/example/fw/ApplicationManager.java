package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;


public static WebDriver driver;
public static String baseUrl;
public static boolean acceptNextAlert = true;
private static StringBuffer verificationErrors = new StringBuffer();

public class ApplicationManager {
	
	public ApplicationManager (){
		driver = new FirefoxDriver(); // initialization with class constructor 
	    // = create new object "FirefoxDriver" and put it in var "driver"
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void gotoGroupsPage(TestBase testBase) {
		// open group page
	    testBase.driver.findElement(By.linkText("groups")).click();
	}

	public void initGroupCreation(TestBase testBase) {
		// init new group creation
	    testBase.driver.findElement(By.name("new")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		// fill new form
	    testBase.driver.findElement(By.name("group_name")).clear();
	    testBase.driver.findElement(By.name("group_name")).sendKeys(group.name);
	    testBase.driver.findElement(By.name("group_header")).clear();
	    testBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
	    testBase.driver.findElement(By.name("group_footer")).clear();
	    testBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void returnToGroupsPage(TestBase testBase) {
		// return to groups page
	    testBase.driver.findElement(By.linkText("group page")).click();
	}

	public void initContactCreation(TestBase testBase) {
		//init new contact creation
		testBase.driver.findElement(By.linkText("add new")).click();
		}

	public void fillContactForm(TestBase testBase, ContactData contact) {
		// fill new contact form
	    testBase.driver.findElement(By.name("firstname")).clear();
	    testBase.driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
	    testBase.driver.findElement(By.name("lastname")).clear();
	    testBase.driver.findElement(By.name("lastname")).sendKeys(contact.second_name);
	    testBase.driver.findElement(By.name("address")).clear();
	    testBase.driver.findElement(By.name("address")).sendKeys(contact.address);
	    testBase.driver.findElement(By.name("home")).clear();
	    testBase.driver.findElement(By.name("home")).sendKeys(contact.home_phone);
	    testBase.driver.findElement(By.name("mobile")).clear();
	    testBase.driver.findElement(By.name("mobile")).sendKeys(contact.mobile_phone);
	    testBase.driver.findElement(By.name("work")).clear();
	    testBase.driver.findElement(By.name("work")).sendKeys(contact.work_phone);
	    testBase.driver.findElement(By.name("email")).clear();
	    testBase.driver.findElement(By.name("email")).sendKeys(contact.email);
	    testBase.driver.findElement(By.name("email2")).clear();
	    testBase.driver.findElement(By.name("email2")).sendKeys(contact.second_email);
	    new Select(testBase.driver.findElement(By.name("bday"))).selectByVisibleText(contact.day_of_birth);
	    new Select(testBase.driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.mon_of_birth);
	    testBase.driver.findElement(By.name("byear")).clear();
	    testBase.driver.findElement(By.name("byear")).sendKeys(contact.year_of_birth);
	    new Select(testBase.driver.findElement(By.name("new_group"))).selectByVisibleText(contact.in_group);
	    testBase.driver.findElement(By.name("address2")).clear();
	    testBase.driver.findElement(By.name("address2")).sendKeys(contact.second_address);
	    testBase.driver.findElement(By.name("phone2")).clear();
	    testBase.driver.findElement(By.name("phone2")).sendKeys(contact.sec_home_phone);
	}

	public void submitCreation(TestBase testBase) {
		// submit group creation
	    testBase.driver.findElement(By.name("submit")).click();
	}

	public void unfillContactForm(TestBase testBase, ContactData contact) {
		 new Select(testBase.driver.findElement(By.name("bday"))).deselectByVisibleText(contact.day_of_birth);
		 new Select(testBase.driver.findElement(By.name("bmonth"))).deselectByVisibleText(contact.mon_of_birth);
	}

	public void openMainPage(TestBase testBase) {
		// open main page
	    testBase.driver.get(testBase.baseUrl + "/addressbookv4.1.4/");
	}

	public boolean isElementPresent(TestBase testBase, By by) {
	    try {
	      testBase.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent(TestBase testBase) {
	    try {
	      testBase.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText(TestBase testBase) {
	    try {
	      Alert alert = testBase.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (testBase.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      testBase.acceptNextAlert = true;
	    }
	  }

	public void stop() {
		// TODO Auto-generated method stub
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	}

}
