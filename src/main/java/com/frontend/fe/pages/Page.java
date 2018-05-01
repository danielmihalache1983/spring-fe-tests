package com.frontend.fe.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public abstract boolean isDisplayed();
}
