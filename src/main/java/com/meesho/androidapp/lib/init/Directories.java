package com.meesho.androidapp.lib.init;

public interface Directories 
{
	String dirPath = System.getProperty("user.dir");
	String dcFile = dirPath+"/src/main/resources/DCapabilities.properties";
	String srceenshotPath = dirPath+"/Screenshots/";
}
