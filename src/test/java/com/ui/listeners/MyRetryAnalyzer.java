package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utilities.JSONUtility;
import com.utilities.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	//read from .properties file
 //private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	//read from json file.
 private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
 
 private static int currentAttempt=1;
	

	@Override
	public boolean retry(ITestResult result) {
		
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
		
	}
	
	

}
