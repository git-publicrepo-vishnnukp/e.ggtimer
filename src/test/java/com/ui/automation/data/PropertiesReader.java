package com.ui.automation.data;

import static com.ui.automation.common.Constants.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ui.automation.common.Constants;

public class PropertiesReader {

	Properties properties = new Properties();
	Properties dataProperties = new Properties();
	String propertyFileName;
	String envPropertiesPath;
	String dataPropertiesPath;
	InputStream inputStream;

	public PropertiesReader(String env) {
		envConfigs(env);
	}

	private void envConfigs(String env) {

		switch (env.toUpperCase()) {

		case "DEV":
			propertyFileName = envDevPropFileName;
			break;

		case "QA":
			propertyFileName = envQaPropFileName;
			break;

		case "PROD":
			envPropertiesPath = envPropsDirectory.replace(propFileName, envProdPropFileName);
			dataPropertiesPath = dataPropsDirectory.replace(propFileName, dataProdPropFileName);
			loadProperties(envPropertiesPath, Constants.env.toUpperCase());
			loadProperties(dataPropertiesPath, Constants.data.toUpperCase());
			break;

		}
	}

	private void loadProperties(String propertyPath, String type) {

		if (propertyPath != null) {
			try {

				if (type.equals("ENV")) {

					inputStream = new FileInputStream(propertyPath);
					properties.load(inputStream);

				} else if (type.equals("DATA")) {
					inputStream = new FileInputStream(propertyPath);
					dataProperties.load(inputStream);
					properties.putAll(dataProperties);
				}

			} catch (IOException e) {
				System.err.println("Unable to load the properties file " + e);
			}
		}
	}

	public String getKeyValue(String key) {
		return properties.getProperty(key);
	}

}