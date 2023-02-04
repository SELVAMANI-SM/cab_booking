package cabbooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	public static Properties getPropertiesObject()throws IOException {
		FileInputStream Filestream = new FileInputStream("E:\\New folder (3)\\cabbooking\\src\\main\\resources\\config.properties\\properties");
		Properties properties = new Properties();
		properties.load(Filestream);
		
//		String className = properties.getProperty("className");
//		String url = properties.getProperty("url");
//		String userName = properties.getProperty("userName");
//		String userPassword = properties.getProperty("userPassword");
//		System.out.println(className+ " "+ url+" "+ userName+" "+userPassword);
		return properties;
		
		
	}
	public static String getUrl() throws IOException
	{
		return getPropertiesObject().getProperty("user");
	}
	public static String getUserName() throws IOException
	{
		return getPropertiesObject().getProperty("userName");
	}

	public static String getUserPassword() throws IOException
	{
		return getPropertiesObject().getProperty("userPassword");
	}

	public static String getClassName() throws IOException
	{
		return getPropertiesObject().getProperty("className");
	}


}
