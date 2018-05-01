package com.frontend.fe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frontend.fe.util.Helpers;

public class SpringCMActionPage extends Page {

	private final String[] expectedErrorMessages = { "Please complete this required field.",
			"Please complete this required field.", "Please complete this required field.",
			"Please complete this required field.", "Please complete all required fields." };

	private final String pageHeaderLocator = ".//h1";
	private final String playVideoButtonLocator = ".//input[@value='PLAY VIDEO']";
	private final String errorMessageListLocator = ".//ul[@class = 'hs-error-msgs inputs-list']";
	private final String firstNameLocator = ".//input[contains(@id, 'firstname')]";
	private final String lastNameLocator = ".//input[contains(@id, 'lastname')]";
	private final String emailLocator = ".//input[contains(@id, 'email')]";
	private final String phoneLocator = ".//input[contains(@id, 'phone')]";
	private final String videoContainerLocator = ".//div[@class='row-fluid-wrapper row-depth-1 row-number-5 ']";

	@FindBy(how = How.XPATH, using = pageHeaderLocator)
	private WebElement pageHeaderElement;

	@FindBy(how = How.XPATH, using = playVideoButtonLocator)
	private WebElement playVideoButtonElement;

	@FindBy(how = How.XPATH, using = firstNameLocator)
	private WebElement firstNameElement;

	@FindBy(how = How.XPATH, using = lastNameLocator)
	private WebElement lastNameElement;

	@FindBy(how = How.XPATH, using = emailLocator)
	private WebElement emailElement;

	@FindBy(how = How.XPATH, using = phoneLocator)
	private WebElement phoneElement;

	@FindBy(how = How.XPATH, using = videoContainerLocator)
	private WebElement videoContainerElement;

	private List<WebElement> errorMessagesList() {
		return driver.findElements(By.xpath(errorMessageListLocator));
	}

	public SpringCMActionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed() {
		Helpers.waitForElementToBeDisplayed(driver, pageHeaderLocator);
		boolean status = false;
		try {

			status = pageHeaderElement.getText().equals("See SpringCM in Action")
					&& playVideoButtonElement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void clickPlayVideoButton() {
		playVideoButtonElement.click();
	}

	public boolean validationErrorsAreDisplayed() {
		boolean status = false;
		int i = 0;
		for (WebElement error : errorMessagesList()) {
			status = error.getText().equals(expectedErrorMessages[i]);
			i++;
			if (!status) {
				break;
			}
		}

		return status;
	}

	public void fillInPlayDemoFormAndClickPlay(String firstName, String lastName, String email, String phone) {
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		playVideoButtonElement.click();
	}

	public boolean videoPlayerIsDisplayed() {
		Helpers.waitForElementToBeDisplayed(driver, videoContainerLocator);
		return videoContainerElement.isDisplayed();
	}
}
