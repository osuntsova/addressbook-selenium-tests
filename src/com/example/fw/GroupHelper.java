package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void initGroupCreation() {
		// init new group creation
	    driver.findElement(By.name("new")).click();
	}

	public void fillGroupForm(ApplicationManager applicationManager, GroupData group) {
		// fill new form
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void returnToGroupsPage() {
		// return to groups page
	    driver.findElement(By.linkText("group page")).click();
	}

}
