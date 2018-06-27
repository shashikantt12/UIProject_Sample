package assessment.cleartrip.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataConfig {

	public static String url;
	public static String from;
	public static String to;
	public static String adultCount;
	public static String childCount;
	public static String infantCount;
	
	public static void prepareData() throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		File file = new File("C://Users//Shashikant_Tiwari//workspace//ClearTripTest//Config//TestData.xlsx");
		map = ParserUtils.parseExcelWorkBook(file, "Testdata_cleartrip");

		for (Map.Entry<String, String> data : map.entrySet()) {
			if(data.getKey().equalsIgnoreCase("url")){
				url = data.getValue();
			} else if(data.getKey().equalsIgnoreCase("from")){
				from = data.getValue();
			} else if(data.getKey().equalsIgnoreCase("to")){
				to = data.getValue();
			} else if(data.getKey().equalsIgnoreCase("adult")){
				adultCount = data.getValue();
			} else if(data.getKey().equalsIgnoreCase("child")){
				childCount = data.getValue();
			} else if(data.getKey().equalsIgnoreCase("infant")){
				infantCount = data.getValue();
			}
		}
	}
}
