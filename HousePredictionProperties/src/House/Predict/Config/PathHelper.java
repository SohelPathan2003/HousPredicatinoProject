package House.Predict.Config;

import java.io.File;
import java.io.FileReader;
import java.io.*;

public class PathHelper {
	public static File path=new File("");
	
	
	protected static FileReader filereader=null;;
	
	
	PathHelper() throws IOException{
		File file=new File("src\\DBHelper.properties");
		filereader=new FileReader(file.getAbsolutePath());
	}

}
