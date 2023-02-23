package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	private static Utilities instance;
	private Utilities() {
	}
	public static Utilities getInstance() {
		if(instance==null) {
			instance=new Utilities();
		}
		return instance;
	}
	public String readPropertyFile(String key) throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}
	public String readExcelFile(String sheetname,String teamNameorPlayerName) throws IOException {
		File file=new File("C:\\Users\\ayyappan.g\\eclipse-workspace\\ApiTestingCucumberFramework\\src\\test\\resources\\ExcelData\\TeamDetails.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet;
		if(sheetname.equalsIgnoreCase("Team")) {
			sheet = workbook.getSheet("Team");
			String teamId = null;
			boolean status=false;
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for(int i=0;i<physicalNumberOfRows;i++)
			{
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					String string = cell.toString();
					if(string.contains(teamNameorPlayerName)) {
						teamId=row.getCell(j-1).toString();
						status=true;
						break;
					}
				}
				if(status) {
					break;
				}
			}
			return teamId;
		}else if(sheetname.equalsIgnoreCase("Player")) {
			sheet = workbook.getSheet("Player");
			String playerId = null;
			boolean status=false;
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for(int i=0;i<physicalNumberOfRows;i++)
			{
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					String string = cell.toString();
					if(string.contains(teamNameorPlayerName)) {
						playerId=row.getCell(j-1).toString();
						status=true;
						break;
					}
				}
				if(status) {
					break;
				}
			}
			return playerId;
		}
		return null;
	}

}
