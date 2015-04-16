package com.epam.khodyka.datadispatcher;

public interface DataDispatcher {
	
	String getStringData(String message);
	
	int getIntData(String message);
	
	long getLongData(String message);
	
	double getDoubleData(String message);
}
