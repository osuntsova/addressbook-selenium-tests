package com.example.tests;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class AddContactTest extends TestBase {
	
	
  @Test
  public void AddNotEmptyContactTest() throws Exception {
	app.openMainPage(this);
    app.initContactCreation(this);
    ContactData contact = new ContactData();
    contact.first_name = "First_name 1";
	contact.second_name = "Second_name 1";
	contact.address = "Address 1";
	contact.home_phone = "89687184485";
	contact.mobile_phone = "89687184486";
	contact.work_phone = "89687184487";
	contact.email = "ola@mail.ru";
	contact.second_email = "ola2@mail.ru";
	contact.day_of_birth = "13";
	contact.mon_of_birth = "June";
	contact.year_of_birth = "1989";
	contact.in_group = "Group 1";
	contact.second_address = "Address 2";
	contact.sec_home_phone = "сколько ж на форме телефонов...";
	app.fillContactForm(this, contact);
	app.submitCreation(this);
}

  /*@Test
  public void AddEmptyContactTest() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.first_name = "";
	contact.second_name = "";
	contact.address = "";
	contact.home_phone = "";
	contact.mobile_phone = "";
	contact.work_phone = "";
	contact.email = "";
	contact.second_email = "";
	contact.day_of_birth = "13";
	contact.mon_of_birth = "June";
	contact.year_of_birth = "";
	contact.in_group = "";
	contact.second_address = "";
	contact.sec_home_phone = "";
	fillContactForm(contact);
	unfillContactForm (contact);
	submitCreation();
}*/
}
 