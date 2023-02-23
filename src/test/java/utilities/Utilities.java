package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.Constants;

public class Utilities {
	private static Utilities instance;
	private Utilities() {
	}
	public static Utilities getInstance() {
		if(instance==null) {
			instance=new Utilities();
		}
		return instance;
	}
	public String readPropertyFile(String key) throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}
	public void loadProperties() throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties(); 
		properties.load(stream);
		Constants.App_url=properties.getProperty("appurl");
		Constants.Browser=properties.getProperty("browser");
		Constants.username=properties.getProperty("username");
		Constants.password=properties.getProperty("password");
	}

}
