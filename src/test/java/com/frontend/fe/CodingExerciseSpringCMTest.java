package com.frontend.fe;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frontend.fe.pages.ContractManagementPage;
import com.frontend.fe.pages.HomePage;
import com.frontend.fe.pages.ResourcesPage;
import com.frontend.fe.pages.SearchOverlayer;
import com.frontend.fe.pages.SpringCMActionPage;
import com.frontend.fe.pages.TopMenuPage;
import com.frontend.fe.util.DataProviders;
import com.frontend.fe.util.Helpers;

public class CodingExerciseSpringCMTest extends TestBase {

	HomePage homePage;
	TopMenuPage topMenu;
	SearchOverlayer searchOverlayer;
	ContractManagementPage contractManagementPage;
	SpringCMActionPage springCmInActionPage;
	ResourcesPage resourcesPage;

	@BeforeClass
	public void initPage() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		topMenu = PageFactory.initElements(driver, TopMenuPage.class);
		searchOverlayer = PageFactory.initElements(driver, SearchOverlayer.class);
		contractManagementPage = PageFactory.initElements(driver, ContractManagementPage.class);
		springCmInActionPage = PageFactory.initElements(driver, SpringCMActionPage.class);
		resourcesPage = PageFactory.initElements(driver, ResourcesPage.class);
	}

	@Test(description = "Search Contract Management in SpringCM", priority = 1)
	public void searchContractManagement() {
		String search_term = "Contract Management";

		assertTrue(homePage.isDisplayed());
		topMenu.clickSearchButton();
		assertTrue(searchOverlayer.isDisplayed());
		searchOverlayer.fillInSearchFieldWith(search_term);
		assertTrue(searchOverlayer.verifyTermIsDisplayedInSearchField(search_term));
		assertTrue(searchOverlayer.verifySearchTermIsDisplayedInEachResultOnFirstPage(search_term));
	}

	@Test(description = "See SpringCM in Action", dataProviderClass = DataProviders.class, dataProvider = "CSV", priority = 2)
	public void seeSpringCMInAction(String firstName, String lastName, String email, String phone) {
		searchOverlayer.clickResultLinkThatContainsText("Contract Management Software | SpringCM");
		assertTrue(contractManagementPage.isDisplayed(), "Contract Management software page is not displayed");
		contractManagementPage.clickProductDemoButton();
		Helpers.switchToWidow(driver, 2);
		assertTrue(springCmInActionPage.isDisplayed(), "SpringCM in Action page is not displayed");
		springCmInActionPage.clickPlayVideoButton();
		assertTrue(springCmInActionPage.validationErrorsAreDisplayed(), "Validation Errors are wrong or not displayed");
		springCmInActionPage.fillInPlayDemoFormAndClickPlay(firstName, lastName, email, phone);
		assertTrue(springCmInActionPage.videoPlayerIsDisplayed());
	}

	@Test(description = "Find Report in SpringCM Resource Library", priority = 3)
	public void findReportInSpringCMResourceLibrary() throws InterruptedException {
		Helpers.switchToWidow(driver, 1);
		topMenu.hoverResourceMenuEntry();
		topMenu.verifyResourcesSubmenuAreDisplayed();
		topMenu.clickResourcesLibrary();
		resourcesPage.isDisplayed();
		resourcesPage.clickMediaTypes();
		resourcesPage.verifyMediaTypesListIsDisplayed();
		resourcesPage.selectReports();
		resourcesPage.verifyReportContentIsDisplayed();
	}
}
