package FinalLoginExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataconfig 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	// Find number of rows in excel file
	
	public ExcelDataconfig(String excelPath)
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

	// For Counting Column 
	public int getColCount(int sheetIndex)
	{
		int column=wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		return column;
	}

}



