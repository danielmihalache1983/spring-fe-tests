package com.frontend.fe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

	private final String HEADER_TEXT = "When Your Documents Flow,\nWork Flows.";

	private final String pageHeaderLocator = ".//h1";

	@FindBy(how = How.XPATH, using = pageHeaderLocator)
	private WebElement pageHeaderElement;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isDisplayed() {
		boolean status = false;
		try {
			status = pageHeaderElement.getText().equals(HEADER_TEXT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
