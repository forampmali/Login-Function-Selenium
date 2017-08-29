package DDT;

public class ReadExcelD {

	public static void main(String[] args) {

		ExcelData excel =new ExcelData("C:\\Users\\prashant\\workspace\\LoginFunctionality\\TestData\\inputdata.xlsx");
		System.out.println(excel.getData(0,0,0));
		
		
	}

}
