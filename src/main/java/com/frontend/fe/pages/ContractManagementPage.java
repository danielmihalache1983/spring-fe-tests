package com.frontend.fe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContractManagementPage extends Page {

	private final String pageHeaderLocator = ".//h1";
	private final String productDemoButtonLocator = ".//span[contains(text(), 'WATCH OUR')]";

	@FindBy(how = How.XPATH, using = pageHeaderLocator)
	private WebElement pageHeaderElement;

	@FindBy(how = How.XPATH, using = productDemoButtonLocator)
	private WebElement productDemoButtonElement;

	public ContractManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed() {
		boolean status = false;
		try {
			status = pageHeaderElement.getText().contains("Contract Management")
					&& productDemoButtonElement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public void clickProductDemoButton() {
		productDemoButtonElement.click();
	}

}
