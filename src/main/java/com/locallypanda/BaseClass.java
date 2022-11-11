package com.locallypanda;

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.microsoft.playwright.*;

public class BaseClass {
	public static FileInputStream fileInputStream;
	public static Properties properties;
    public static Playwright playwright;
    public static BrowserContext browserContext;
    public static Browser browser;
    public static Page page;
    public static BrowserType browserType;
	
	public BaseClass() throws FileNotFoundException {
		try {
		// TODO Auto-generated constructor stub
			properties=new Properties();
		fileInputStream=new FileInputStream("Configuration/configuration.properties");
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		playwright= Playwright.create();
		String browserName= properties.getProperty("browser");
		if (browserName.equals("chromium")) {
			browserType=playwright.chromium();
			browser=browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
		}
		else if (browserName.equals("firefox")) {
			browserType=playwright.firefox();
			browser=browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
		}
		else if (browserName.equals("webkit")) {
			browserType=playwright.webkit();
			browser=browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
		}
		else {
			System.out.println("Browser not supported, please use either chromnium, firefox or webkit");
		}
		browserContext=browser.newContext();
		page=browser.newPage();
		page.navigate(properties.getProperty("BaseUrl"));
		page.setDefaultTimeout(500000);
		
	}

}
