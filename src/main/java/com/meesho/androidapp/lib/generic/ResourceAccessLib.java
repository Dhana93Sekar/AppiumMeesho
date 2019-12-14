package com.meesho.androidapp.lib.generic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

public class ResourceAccessLib 
{
	
	public static String getPropertyValue(String path,String key)
	{
		String value=null;
		try {
			FileInputStream fis = new FileInputStream(path);
			Properties p = new Properties();
			p.load(fis);
			value = p.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
		public static String executeBatchCommmand(String command) {
		String id = null;
		try {
			String line;
			ArrayList<String> deviceUDID = new ArrayList<String>();
			Process p = Runtime.getRuntime().exec(command);

			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = bri.readLine()) != null) {
				deviceUDID.add(line);
			}
			System.out.println(deviceUDID);
			id = deviceUDID.get(1).replace("device", "").trim();
			bri.close();

		} catch (Exception err) {
			err.printStackTrace();
		}
		return id;
	}
	
}
