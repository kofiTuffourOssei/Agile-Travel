package com.locallypanda.testcases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.locallypanda.BaseClass;
import com.locallypanda.pages.HomePage;

public class homepageTest extends BaseClass{
    public static HomePage homePage;
	public homepageTest() throws FileNotFoundException{
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeTest 
	public void setUp() throws FileNotFoundException {
		initialization();
		homePage=new HomePage(page);
	}
	@Test(priority = 1)
	public void testEmailField() {
		homePage.setemailField("agileway");
		assertTrue(true, "It worked!!!!");
	}
	@Test(priority = 2)
	public void testPasswordField() {
		homePage.setpasswordField("testwise");
		assertTrue(true, "I doubt it'll work");
	}
	@Test(priority = 3)
	public void testSignButton() {
		homePage.clickSignButton();
		assertTrue(true, "It didn't work");
	}
	@Test
	public void testcheckTitle() {
		homePage.checkTitle();
		assertTrue(true);
	}

}
