package com.hpe.digitalsafe.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadProperties {

	public static Properties ReadPropeties(){
		final Properties dsprop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("config/AppConfig.properties");
			dsprop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dsprop;
	}
	  
	
}
