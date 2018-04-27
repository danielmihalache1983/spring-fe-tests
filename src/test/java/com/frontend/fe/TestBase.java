package com.frontend.fe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class TestBase extends AbstractTestNGSpringContextTests{

	@Value("${site.url}")
	private String siteUrl;

	@Test
	public void init() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(siteUrl);
	}
}
