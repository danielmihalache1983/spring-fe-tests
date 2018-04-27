package com.frontend.fe;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.frontend.fe.webdriver.WebDriverFactory;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class TestBase extends AbstractTestNGSpringContextTests {

	@Autowired
	WebDriverFactory factory;

	WebDriver driver;

	@Value("${site.url}")
	private String siteUrl;

	@Test
	public void init() {
		driver = factory.getInstance();
		driver.get(siteUrl);
	}
}
