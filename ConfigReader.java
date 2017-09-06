package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class reads base settings from the config.properties file
 */
public class ConfigReader {
	private String login = "";
	private String password = "";
	private boolean useAssert = true;
	private String driverPath = "";
	private String browser ="";

	/**
	 * Class constructor loads settings from the file and saves to fields
	 */
	public ConfigReader() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cant't read config.properties file!");
			return;
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cant't read config.properties file!");
			return;
		}
		login = p.getProperty("LOGIN");
		password = p.getProperty("PASSWORD");
		browser = p.getProperty("BROWSER");
		driverPath = p.getProperty("DRIVER_PATH");
		try {
			useAssert = Boolean.parseBoolean(p.getProperty("USE_ASSERT"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't read useAssert property");
		}
	}

	/**
	 * Method to get the user name
	 *
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}

	public String getBrowser() {
		return browser;
	}
	/**
	 * Method to get the path to Firefox profile
	 *
	 * @return firefoxPath
	 */
	public String getDriverPath() {
		return driverPath;
	}
	
	/**
	 * Method to get the Assert usage
	 *
	 * @return useAssert
	 */
	public boolean isUseAssert() {
		return useAssert;
	}

}
