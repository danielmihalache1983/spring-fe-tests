package com.frontend.fe.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frontend.fe.util.Helpers;

public class TopMenuPage extends Page {

	private final String searchButtonLocator = ".//div[@class='row-fluid ']//i[@class='fa fa-search']";
	private final String resourceButtonLocator = "(//*[@id='hs_menu_wrapper_my_menu'])[2]/ul/li[5]/a";
	private final String resourceLibraryButtonLocator = "(//*[@id='hs_menu_wrapper_my_menu'])[2]/ul/li[5]/a/../ul/li/a[text()='Resources Library']";
	private final String blogButtonLocator = "(//*[@id='hs_menu_wrapper_my_menu'])[2]/ul/li[5]/a/../ul/li/a[text()='Blog']";
	private final String eventsButtonLocator = "(//*[@id='hs_menu_wrapper_my_menu'])[2]/ul/li[5]/a/../ul/li/a[text()='Events']";
	private final String customerTrainingSiteLocator = "(//*[@id='hs_menu_wrapper_my_menu'])[2]/ul/li[5]/a/../ul/li/a[text()='Customer Training Site']";

	@FindBy(how = How.XPATH, using = searchButtonLocator)
	private WebElement searchButtonElement;
	@FindBy(how = How.XPATH, using = resourceButtonLocator)
	private WebElement resourceButtonElement;
	@FindBy(how = How.XPATH, using = resourceLibraryButtonLocator)
	private WebElement resourceLibraryButtonElement;
	@FindBy(how = How.XPATH, using = blogButtonLocator)
	private WebElement blogButtonElement;
	@FindBy(how = How.XPATH, using = eventsButtonLocator)
	private WebElement eventsButtonElement;
	@FindBy(how = How.XPATH, using = customerTrainingSiteLocator)
	private WebElement customerTrainingSiteElement;

	public TopMenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickSearchButton() {
		searchButtonElement.click();
	}

	public void hoverResourceMenuEntry() throws InterruptedException {
		Helpers.waitForElementToBeDisplayed(driver, resourceButtonLocator);
		TimeUnit.SECONDS.sleep(1);
		Actions action = new Actions(driver);
		action.moveToElement(resourceButtonElement).build().perform();
	}

	public boolean verifyResourcesSubmenuAreDisplayed() {
		boolean status = false;
		try {
			status = resourceLibraryButtonElement.isDisplayed() && blogButtonElement.isDisplayed()
					&& eventsButtonElement.isDisplayed() && customerTrainingSiteElement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void clickResourcesLibrary() {
		resourceLibraryButtonElement.click();
	}

}
