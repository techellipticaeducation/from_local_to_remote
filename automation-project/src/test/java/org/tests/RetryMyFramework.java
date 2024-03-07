package org.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMyFramework implements IRetryAnalyzer{

	int counter = 1;
	int retryCounter = 3;
	public boolean retry(ITestResult result) {
		if(retryCounter >= counter) {
			counter++;
			return true;
		}
		return false;
	}

	
}
