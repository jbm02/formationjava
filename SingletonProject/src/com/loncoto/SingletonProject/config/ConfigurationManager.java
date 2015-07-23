package com.loncoto.SingletonProject.config;

public class ConfigurationManager {
	private String applicationName;
	private String applicationVersion;
	private static ConfigurationManager instance = null;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	private ConfigurationManager() {
		applicationName = "SingletonPower";
		applicationVersion = "1.0";
	}

	public static ConfigurationManager getInstance() {
		if (instance == null) {
			instance = new ConfigurationManager();	
		}
		return instance;
	}
}