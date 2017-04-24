package dataProvider;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	
	Properties pro;
	
	public ConfigDataProvider(){
	
	File src=new File("C:\\Users\\anurag\\workspace\\com.framework2.hybrid\\configuration\\config.properties");
	
	try {
		FileInputStream fis=new FileInputStream(src);
		
		pro=new Properties();	
		
		pro.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("exception is"+ e.getMessage());
	}

}
	
	public String getChromePath()
	{
		String chrome=pro.getProperty("chromePath");
		return chrome;
		
	}
	
	public String getIEPath()
	{
		String ie=pro.getProperty("iePath");
		return ie;
		
	}
	
	public String getFireFoxPath()
	{
		String firefox=pro.getProperty("firefox");
		return firefox;
		
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("url");
		return url;
		
	}
	
}
