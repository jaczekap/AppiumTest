package calculatortest;

import org.testng.annotations.Test;

import apps.CalculatorApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.CapabilitiesTool;
import utils.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class CalculationTests {

	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities cap;
	private URL url;
	private CalculatorApp calculator;

	@BeforeTest
	public void setUp() {
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub/");
			cap = CapabilitiesTool.getCapabilitiesFromFile("src/test/resources/capabilities.properties");
			driver = new AppiumDriver<MobileElement>(url, cap);
			calculator = new CalculatorApp(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void addTest() {
		calculator.getDigit("3").click();
		calculator.getOperator("+").click();
		calculator.getDigit("9").click();
		calculator.getOperator("=").click();
		assertTrue(calculator.getMainDisplay().getText().equalsIgnoreCase("12"));
	}
	
	@Test(dataProvider = "data")
	public void calculationsTest(String firstDigit, String operationSign, String secondDigit, String expectedResult) {
		calculator.getDigit(firstDigit).click();
		calculator.getOperator(operationSign).click();
		calculator.getDigit(secondDigit).click();
		calculator.getOperator("=").click();
		assertTrue(calculator.getMainDisplay().getText().equalsIgnoreCase(expectedResult));
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterTest
	public void tearDown( ) {
		
	}


	  @DataProvider(name = "data")
	  public Object[][] dataProvider() {
	    return new ExcelUtils("src/test/resources/calculator_test_data.xlsx", 0, true).dataProvider();
	 }
}
