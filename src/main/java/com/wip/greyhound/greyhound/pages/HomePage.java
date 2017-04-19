package com.wip.greyhound.greyhound.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	String usernameField = "input[name='username']";
	String username = "gtestsatyam1@gmail.com";
	String passwordField = "input[name='password']";
	String password = "satyam123";
	String submitButton = "#rewards-login-go";
	String helpandInfo = ".//*[@id='nav-main']/ul/li[5]/a";

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//signing in to the app
	public void gotoLogin() {
		//clickxpath("//a[4]/span/span[1]");
		//click("#nav-main ul li:nth-child(6) a");
		enterText(usernameField, username);
		enterText(passwordField, password);
		click(submitButton);
	}

	public void gotoMexicoSite() {
		clickxpath("//a[@href='http://www.greyhound.com.mx/']");
	}
	
	public CanadaSite gotoCanadaSite() {
		click("a[href='http://www.greyhound.ca']");
		
		return new CanadaSite(driver);
	}

	public HelpandInfoPage goToHelpAndInfo() {
		driver.findElement(By.xpath("//a[@href='/en/help-and-info']")).click();
		return new HelpandInfoPage(driver);
	}



}
