package com.frontend.fe.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

@Service
public class WebDriverFactory {

	public WebDriver getInstance() {
		setFirefoxDriver();
		return new FirefoxDriver();
	}

	private static void setFirefoxDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String firefoxBinary = "src/main/resources/geckodriver" + (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.gecko.driver", firefoxBinary);
	}
}
