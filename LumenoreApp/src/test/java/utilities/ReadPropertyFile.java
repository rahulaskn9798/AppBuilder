package utilities;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPropertyFile {

	@Test
	public void readFile() throws IOException{
		FileReader fr = new FileReader("/Users/RahulJ/eclipse-workspace/LumenoreApp/src/test/resources/configfiles/config.properties");
		Properties p= new Properties();
		p.load(fr);
	}
	
	
}
