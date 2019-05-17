package apps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class CalculatorApp {

	private Map<String, WebElement> digits;
	private Map<String, WebElement> operators;
	
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_00")
	private WebElement number_0;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_01")
	private WebElement number_1;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_02")
	private WebElement number_2;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_03")
	private WebElement number_3;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_04")
	private WebElement number_4;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_05")
	private WebElement number_5;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_06")
	private WebElement number_6;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_07")
	private WebElement number_7;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_08")
	private WebElement number_8;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_09")
	private WebElement number_9;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_add")
	private WebElement addSign;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_sub")
	private WebElement subSign;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_mul")
	private WebElement mulSign;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_div")
	private WebElement divSign;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/bt_equal")
	private WebElement equalSign;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/txtCalc")
	private WebElement mainDisplay;
	@FindBy(id = "com.sec.android.app.popupcalculator:id/txtCalc_RealTimeResult")
	private WebElement realTimeResultDisplay;
	
	public CalculatorApp(MobileDriver<MobileElement> driver) {
		
		PageFactory.initElements(driver, this);
		
		operators = new HashMap<String, WebElement>();
		operators.put("+", addSign);
		operators.put("-", subSign);
		operators.put("*", mulSign);
		operators.put("/", divSign);
		operators.put("=", equalSign);
		
		digits = new HashMap<String, WebElement>();
		digits.put("number_0", number_0);
		digits.put("number_1", number_1);
		digits.put("number_2", number_2);
		digits.put("number_3", number_3);
		digits.put("number_4", number_4);
		digits.put("number_5", number_5);
		digits.put("number_6", number_6);
		digits.put("number_7", number_7);
		digits.put("number_8", number_8);
		digits.put("number_9", number_9);
		digits.put("number_0", number_0);
		
	}
	
	public WebElement getDigit(String digit) {
		return digits.get("number_" + digit);
	}
	
	public WebElement getOperator(String sign) {
		return operators.get(sign);
	}

	public WebElement getMainDisplay() {
		return mainDisplay;
	}

	public WebElement getRealTimeResultDisplay() {
		return realTimeResultDisplay;
	}
	
	

}
