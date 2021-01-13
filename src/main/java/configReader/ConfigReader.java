package configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	//Without Environment Configuration
	
		public Properties init_prop()
		{
			prop=new Properties();
			
			FileInputStream FIS;
			
			try 
			{
				FIS = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
				prop.load(FIS);
			} 
			catch(FileNotFoundException e) 
			{
				e.getMessage();
			} 
			catch(IOException e)
			{
				e.getMessage();
			}
				
				
			return prop;
			
		}
		

}
