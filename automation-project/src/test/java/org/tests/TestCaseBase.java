package org.tests;

public class TestCaseBase {

	public static void setup() {
		String chromeDriverPath = 
				"C:\\Users\\Vaibhav\\testometer_nov_23_java_wd\\automation-project\\drivers\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
	}
	public static void appWait(int i) {
		try {
			Thread.sleep(i*1000);
		}catch(Exception e) {
			
		}
	}
}
