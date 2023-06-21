package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	static Properties prop;

	public  Properties readconfig(){
		// TODO Auto-generated method stub
		
		
		try {
			prop=new Properties();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File file;
		file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
			try {
				FileInputStream fis=new FileInputStream(file);
				try {
					prop.load(fis);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			return prop;

	}

}
