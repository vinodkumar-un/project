package com.fs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppFactory {
	private static Properties props;

	public AppFactory() {
		InputStream is = null;
		
		if (props == null) {
			try {
				is = this.getClass().getResourceAsStream("appClasses.properties");
				props = new Properties();
				props.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Object getObject(String key) throws IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		String className = null;
		Object obj = null;
		if (props.containsKey(key)) {
			className = props.getProperty(key);
			obj = Class.forName(className).newInstance();
		}
		return obj;
	}
}
