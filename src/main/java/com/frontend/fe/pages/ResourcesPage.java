package com.frontend.fe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frontend.fe.util.Helpers;

public class ResourcesPage extends Page {

	private final String resourcesContainerLocator = ".//div[@class='grid']";
	private final String mediaTypesDropdownLocator = "(//ul[@class='portfolio-filters js'])[2]";

	private final String mediaTypesEntryAll = "(//ul[@class='portfolio-filters js'])[2]/li/ul/li/a[text()='all']";
	private final String mediaTypesEntryDatasheets = "(//ul[@class='portfolio-filters js'])[2]/li/ul/li/a[text()='Datasheets & Tip Sheets']";
	private final String mediaTypesEntryeBook = "(//ul[@class='portfolio-filters js'])[2]/li/ul/li/a[text()='eBook']";
	private final String mediaTypesEntryeReports = "(//ul[@class='portfolio-filters js'])[2]/li/ul/li/a[text()='Reports']";
	private final String reportContentLocator = ".//div[contains (@class ,'portfolio-item mix report ')]";

	@FindBy(how = How.XPATH, using = resourcesContainerLocator)
	private WebElement resourcesContainerElement;
	@FindBy(how = How.XPATH, using = mediaTypesDropdownLocator)
	private WebElement mediaTypesDropdownElement;
	@FindBy(how = How.XPATH, using = mediaTypesEntryAll)
	private WebElement mediaTypesEntryAllElement;
	@FindBy(how = How.XPATH, using = mediaTypesEntryDatasheets)
	private WebElement mediaTypesEntryDatasheetsElement;
	@FindBy(how = How.XPATH, using = mediaTypesEntryeBook)
	private WebElement mediaTypesEntryeBookElement;
	@FindBy(how = How.XPATH, using = mediaTypesEntryeReports)
	private WebElement mediaTypesEntryeReportsElement;

	private List<WebElement> reportContentElements() {
		return driver.findElements(By.xpath(reportContentLocator));
	}

	public ResourcesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed() {
		boolean status = false;
		try {
			status = resourcesContainerElement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void clickMediaTypes() {
		mediaTypesDropdownElement.click();
	}

	public boolean verifyMediaTypesListIsDisplayed() {
		boolean status = false;
		status = mediaTypesEntryAllElement.isDisplayed() && mediaTypesEntryDatasheetsElement.isDisplayed()
				&& mediaTypesEntryeBookElement.isDisplayed();
		return status;
	}

	public void selectReports() {
		mediaTypesEntryeReportsElement.click();
	}

	public boolean verifyReportContentIsDisplayed() {
		Helpers.waitForElementToBeDisplayed(driver, reportContentLocator);
		boolean status = false;
		for (WebElement result : reportContentElements()) {
			status = result.isDisplayed();
			if (!status) {
				break;
			}
		}
		return status;
	}

}
