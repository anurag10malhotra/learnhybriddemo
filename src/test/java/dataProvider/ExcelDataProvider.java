package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	
	public ExcelDataProvider()
	{
		File src=new File("./applicationTestData/TestData.xlsx");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception is"+ e.getMessage());
		}
	}
	
	
	public String getData(int sheetIndex,int row,int column)
	{
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;

	
	}
}
