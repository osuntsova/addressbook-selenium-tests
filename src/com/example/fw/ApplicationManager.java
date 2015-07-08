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
	    driver.findElement(By.linkText("groups")).click();
	}

	public void initGroupCreation(TestBase testBase) {
		// init new group creation
	    driver.findElement(By.name("new")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		// fill new form
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void returnToGroupsPage(TestBase testBase) {
		// return to groups page
	    driver.findElement(By.linkText("group page")).click();
	}

	public void initContactCreation(TestBase testBase) {
		//init new contact creation
		driver.findElement(By.linkText("add new")).click();
		}

	public void fillContactForm(TestBase testBase, ContactData contact) {
		// fill new contact form
	    driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.second_name);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.address);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.home_phone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mobile_phone);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contact.work_phone);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.email);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contact.second_email);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.day_of_birth);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.mon_of_birth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.year_of_birth);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.in_group);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.second_address);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contact.sec_home_phone);
	}

	public void submitCreation(TestBase testBase) {
		// submit group creation
	    driver.findElement(By.name("submit")).click();
	}

	public void unfillContactForm(TestBase testBase, ContactData contact) {
		 new Select(driver.findElement(By.name("bday"))).deselectByVisibleText(contact.day_of_birth);
		 new Select(driver.findElement(By.name("bmonth"))).deselectByVisibleText(contact.mon_of_birth);
	}

	public void openMainPage(TestBase testBase) {
		// open main page
	    driver.get(testBase.baseUrl + "/addressbookv4.1.4/");
	}

	public boolean isElementPresent(TestBase testBase, By by) {
	    try {
	     driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent(TestBase testBase) {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText(TestBase testBase) {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
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
