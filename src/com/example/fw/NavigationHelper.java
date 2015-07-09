package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	public void openMainPage() {
		// open main page
	    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}
	
	public void gotoGroupsPage() {
		// open group page
	    driver.findElement(By.linkText("groups")).click();
	}

	public void submitCreation() {
		// submit group creation
	    driver.findElement(By.name("submit")).click();
	}

}
