package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void initContactCreation() {
		//init new contact creation
		manager.driver.findElement(By.linkText("add new")).click();
		}

	public void fillContactForm(ApplicationManager applicationManager, ContactData contact) {
		// fill new contact form
	    manager.driver.findElement(By.name("firstname")).clear();
	    manager.driver.findElement(By.name("firstname")).sendKeys(contact.first_name);
	    manager.driver.findElement(By.name("lastname")).clear();
	    manager.driver.findElement(By.name("lastname")).sendKeys(contact.second_name);
	    manager.driver.findElement(By.name("address")).clear();
	    manager.driver.findElement(By.name("address")).sendKeys(contact.address);
	    manager.driver.findElement(By.name("home")).clear();
	    manager.driver.findElement(By.name("home")).sendKeys(contact.home_phone);
	    manager.driver.findElement(By.name("mobile")).clear();
	    manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile_phone);
	    manager.driver.findElement(By.name("work")).clear();
	    manager.driver.findElement(By.name("work")).sendKeys(contact.work_phone);
	    manager.driver.findElement(By.name("email")).clear();
	    manager.driver.findElement(By.name("email")).sendKeys(contact.email);
	    manager.driver.findElement(By.name("email2")).clear();
	    manager.driver.findElement(By.name("email2")).sendKeys(contact.second_email);
	    new Select(manager.driver.findElement(By.name("bday"))).selectByVisibleText(contact.day_of_birth);
	    new Select(manager.driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.mon_of_birth);
	    manager.driver.findElement(By.name("byear")).clear();
	    manager.driver.findElement(By.name("byear")).sendKeys(contact.year_of_birth);
	    new Select(manager.driver.findElement(By.name("new_group"))).selectByVisibleText(contact.in_group);
	    manager.driver.findElement(By.name("address2")).clear();
	    manager.driver.findElement(By.name("address2")).sendKeys(contact.second_address);
	    manager.driver.findElement(By.name("phone2")).clear();
	    manager.driver.findElement(By.name("phone2")).sendKeys(contact.sec_home_phone);
	}

}
