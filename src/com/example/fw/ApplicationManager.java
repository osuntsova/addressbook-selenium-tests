package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ApplicationManager {

	public WebDriver driver;
	public String baseUrl;
	
	private NavigationHelper navigationHelper;
	private HelperBase groupHelper;
	private ContactHelper contactHelper;
		
	
	public ApplicationManager (){
		driver = new FirefoxDriver(); // initialization with class constructor 
	    // = create new object "FirefoxDriver" and put it in var "driver"
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
//	    navigationHelper = new NavigationHelper (this);
//	    groupHelper = new GroupHelper (this);
//	    contactHelper = new ContactHelper (this);
	    
	}


	public void stop() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public NavigationHelper getNavigationHepler (){
	if (navigationHelper == null){
		navigationHelper = new NavigationHelper (this);
		} return navigationHelper;
	}
	
	public HelperBase getGroupHepler (){
		if (groupHelper == null){
			groupHelper = new GroupHelper (this);
			} return groupHelper;
		}
	
	public ContactHelper getContactHepler (){
		if (contactHelper == null){
			contactHelper = new ContactHelper (this);
			} return contactHelper;
		}
}
