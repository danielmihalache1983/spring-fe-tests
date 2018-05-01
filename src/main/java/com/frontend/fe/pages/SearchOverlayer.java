package com.frontend.fe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frontend.fe.util.Helpers;

public class SearchOverlayer extends Page {

	private final String searchFieldLocator = ".//input[@class = 'sj-search-bar-input sj-search-bar-input-common']";
	private final String searchResultsLocator = ".//div[@class='sj-result-list']//h3/a";
	private final String searchResultListLocator = ".//div[@class='sj-result-list']";

	@FindBy(how = How.XPATH, using = searchFieldLocator)
	private WebElement searchFieldElement;

	@FindBy(how = How.XPATH, using = searchResultListLocator)
	private WebElement searchResultListElement;

	private List<WebElement> searchResultsList() {
		return driver.findElements(By.xpath(searchResultsLocator));
	}

	public SearchOverlayer(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDisplayed() {
		boolean status = false;
		try {
			status = searchFieldElement.isDisplayed()
					&& searchFieldElement.getAttribute("placeholder").equals("Type to search");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void fillInSearchFieldWith(String search_term) {
		searchFieldElement.sendKeys(search_term);
	}

	public boolean verifyTermIsDisplayedInSearchField(String search_term) {
		return searchFieldElement.getAttribute("value").equals(search_term);
	}

	public boolean verifySearchTermIsDisplayedInEachResultOnFirstPage(String search_term) {
		Helpers.waitForElementToBeDisplayed(driver, searchResultListLocator);
		boolean status = false;
		for (WebElement result : searchResultsList()) {
			if (result.getText().toLowerCase().contains(search_term.toLowerCase())) {
				status = true;
			} else {
				status = false;
				break;
			}
		}
		return status;
	}

	public void clickResultLinkThatContainsText(String string) {
		for (WebElement result : searchResultsList()) {
			if (result.getText().toLowerCase().contains(string.toLowerCase())) {
				result.click();
				break;
			}
		}
	}
}
