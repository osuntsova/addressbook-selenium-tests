package com.example.tests;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class GroupCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage(this);
    app.gotoGroupsPage(this);
    app.initGroupCreation(this);
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.fillGroupForm(this, group);
    app.submitCreation(this);
    app.returnToGroupsPage(this);
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage(this);
    app.gotoGroupsPage(this);
    app.initGroupCreation(this);
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitCreation(this);
    app.returnToGroupsPage(this);
  }
}
