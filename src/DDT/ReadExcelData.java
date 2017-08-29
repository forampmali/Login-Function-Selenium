package DDT;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File scr =new File("C:\\Users\\prashant\\workspace\\LoginFunctionality\\TestData\\inputdata.xlsx");
		FileInputStream fis =new FileInputStream(scr);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheet =	wb.getSheetAt(0);
		// For Constant variable 
		//String data0  = sh.getRow(0).getCell(0).getStringCellValue();
		//System.out.println("Data from excel is " +data0);
		//Total no of raw count
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
		System.out.println("Total ROw is " +rowcount);
		
		//Total no of column count
		int colcount=sheet.getRow(0).getLastCellNum();
		System.out.println("Total Column is " +colcount);
		
		/*	Object data[][] = new Object[rowcount-1][colcount];
		for (int rNum = 2; rNum <= rowcount; rNum++)
		{
		for (int cNum = 0; cNum < colcount; cNum++) {
		System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
		data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); //Your sheet name
		}
		System.out.println();
		}
		return data;
		}	*/
		for(int rnum=0; rnum< rowcount; rnum++)
		{
			for(int colnum=0; colnum<colcount; colnum++)
			{
			String data =sheet.getRow(rnum).getCell(colnum).getStringCellValue();
			System.out.println("Test data from excel is "+data);
			}
		}
	wb.close();
	}

}
