package com.locallypanda.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.locallypanda.BaseClass;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BaseClass{
	public HomePage(Page page) throws FileNotFoundException {
		this.page=page;
	}
	Locator emailField=page.locator("id=username");
	Locator passwordField=page.locator("xpath=/html/body/div/form/div/div/p[2]/input");
    Locator signButton=page.locator("xpath=/html/body/div/form/div/div/p[4]/input");
    Locator signinTitle=page.locator("xpath=/html/body/div/h2");
    
	public void setemailField(String email) {
		emailField.fill(email);
	}
	public void setpasswordField(String pswd) {
		passwordField.fill(pswd);
	}
	public void clickSignButton() {
		signButton.click();
	}
	public void checkTitle() {
		boolean msg =signinTitle.isDisabled();
		if (msg=true) {
//			String textString= signinTitle.innerText();
//			System.out.println(textString);
			System.out.println("Flight Select is displayed");
		}
		else {
			System.out.println("Flight Select is not displayed");
		}
	}
}
