package com.wip.greyhound.greyhound;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wip.greyhound.greyhound.pages.ExplorePage;
import com.wip.greyhound.greyhound.pages.HelpandInfoPage;
import com.wip.greyhound.greyhound.pages.HomePage;
import com.wip.greyhound.greyhound.pages.LoginPage;
import com.wip.greyhound.greyhound.pages.TripSearchResultsPage;
import com.wip.greyhound.greyhound.pages.WebDriverBuilder;

public class HomePageTest {
	public static WebDriver driver;
	public Properties OR;

	public HomePageTest() {
		driver = WebDriverBuilder.getDriver();
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void verifyLogin() {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		home.gotoLogin();
	}

	@Test
	public void verifyMemberId() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		home.gotoLogin();
		LoginPage login = new LoginPage(driver);
		Thread.sleep(1000);
		Assert.assertEquals("172893321", login.getMemberId());
	}

	@Test
	public void verifyLogout() {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		home.gotoLogin();
		LoginPage login = new LoginPage(driver);
		login.signout();
		// Assert.assertTrue(driver.getCurrentUrl().endsWith("help-and-info/road-rewards"));
	}

	@Test
	public void verifyBookingAtrip() {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		home.gotoLogin();
		LoginPage login = new LoginPage(driver);
		login.bookAtrip();
		
		
	}

	@Test
	public void verifyEditTripDetails() {
		verifyBookingAtrip();
		new TripSearchResultsPage(driver);
	}

	@Test
	public void verifyMexicoSite() {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		driver.getCurrentUrl();
		home.gotoMexicoSite();
		// Assert.assertEquals("http://www.greyhound.com.mx/",
		// driver.getCurrentUrl());
		// Assert.assertEquals("LAS TARIFAS", driver.);
		// driver.assertTrue(driver.is_element_present(By.cssSelector(".whitelabel-home-title.title-orange"));
		driver.getPageSource().contains("LAS TARIFAS");

	}

	@Test
	public void rewardsPoint() {
		HomePage home = new HomePage(driver);
		HelpandInfoPage HelpandInfo = new HelpandInfoPage(driver);
		home.loadUrl();
		home.goToHelpAndInfo();
		HelpandInfo.GotoRoadRewards();
	}

	@Test
	public void gotoExplorePlaces() {
		HomePage home = new HomePage(driver);
		home.loadUrl();
		LoginPage login = new LoginPage(driver);
		ExplorePage explore = login.gotoExplorePlaces();
		System.out.println(driver.getCurrentUrl());
		// Assert.assertTrue(driver.getCurrentUrl().endsWith("en/explore-places"));
	}

	@Test
	public void verifyExplorePlaces() {
		gotoExplorePlaces();
		ExplorePage explore = new ExplorePage(driver);
		explore.getListOfPlaces();
	}

	
}
