package com.hpe.digitalsafe.Helper;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public BrowserFactory() {
	}
	
	public static Properties globalinfo=ReadProperties.ReadPropeties();
	

	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "config/chromedriver.exe");
			
			driver=new ChromeDriver();			
		}
		else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", "config/IEDriverServer.exe");
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);
            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver startBrowserDefault(){

		if(globalinfo.getProperty("BROWSER").equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(globalinfo.getProperty("BROWSER").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "config/chromedriver.exe");
			driver=new ChromeDriver();			
		}
		else if(globalinfo.getProperty("BROWSER").equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", "config/IEDriverServer.exe");
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);
            driver = new InternetExplorerDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.get(globalinfo.getProperty("URL"));
		return driver;
	}

}
