package assessment.cleartrip.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParserUtils {

	@SuppressWarnings({ "resource", "deprecation" })
	public static Map<String, String> parseExcelWorkBook(File excelSheet, String workSheetName) throws IOException{
	
		Map<String, String> data = new HashMap<String, String>();
		
		FileInputStream inputSteam = new FileInputStream(excelSheet);
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(inputSteam);
		XSSFSheet sheet = excelWorkBook.getSheet(workSheetName);
		
		for(int i=sheet.getFirstRowNum(); i<sheet.getLastRowNum(); i++){
			Row row = sheet.getRow(i);
			switch(row.getCell(1).getCellType()){
				case Cell.CELL_TYPE_NUMERIC:
					data.put(row.getCell(0).getStringCellValue(), String.valueOf(row.getCell(1).getNumericCellValue()));
					break;
				case Cell.CELL_TYPE_STRING:
					data.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
					break;
			}
				
		}
		
		return data;
		
	}
	
/*	public static void main(String args[]) throws Exception{
		ParserUtils parseUtils = new ParserUtils();
		File file = new File("C://Users//Shashikant_Tiwari//workspace//ClearTripTest//Config//TestData.xlsx");
		parseUtils.parseExcelWorkBook(file, "Testdata_cleartrip");
		
	
	}*/
	
}
