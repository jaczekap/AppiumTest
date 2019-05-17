package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class CapabilitiesTool {
	
	
	public static DesiredCapabilities getCapabilitiesFromFile(String filePath) {
		Properties props = new Properties();
		Map<String, String> caps = new HashMap<String, String>();
		try {
			InputStream in = new FileInputStream(filePath);
			props.load(in);
			props.forEach((a, b) -> {String key = (String)a; String value = (String)b; caps.put(key, value);});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DesiredCapabilities(caps);
	}
}
