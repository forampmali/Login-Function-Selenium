package DDT;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	// Find number of rows in excel file
	
	public ExcelData(String excelPath)
	{
		try {
			File scr =new File(excelPath);
			FileInputStream fis =new FileInputStream(scr);
			wb =new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
		System.out.println(e.getMessage());
		}
	}			
	
	public String getData(int sheetnumber, int row, int column)
	{
		sheet =	wb.getSheetAt(sheetnumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}	
	// For Counting Raw 
	public int getRawCount(int sheetIndex)
	{
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row= row+1;
		return row;
	}			

}



