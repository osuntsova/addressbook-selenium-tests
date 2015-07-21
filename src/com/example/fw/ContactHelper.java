package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
		}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.first_name);
		type(By.name("lastname"), contact.second_name);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home_phone);
		type(By.name("mobile"), contact.mobile_phone);
		type(By.name("work"), contact.work_phone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.second_email);
	    selectByText(By.name("bday"), contact.day_of_birth);
	    selectByText(By.name("bmonth"), contact.mon_of_birth);
	    type(By.name("byear"), contact.year_of_birth);
	    //selectByText(By.name("new_group"), contact.in_group);
	    type(By.name("address2"), contact.second_address);
	    type(By.name("phone2"), contact.sec_home_phone);
	   }

	
}
