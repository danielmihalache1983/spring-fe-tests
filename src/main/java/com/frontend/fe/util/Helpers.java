package com.frontend.fe.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

	public static void switchToWidow(WebDriver driver, int windowIndex) {
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(windowIndex - 1));
	}

	public static void waitForElementToBeDisplayed(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
}
