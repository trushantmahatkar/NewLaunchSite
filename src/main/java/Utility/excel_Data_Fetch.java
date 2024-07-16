package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_Data_Fetch
{
	public static String send_Character(int a, int b) throws IOException
	{
		String path="D:\\Users\\trushantmahatkar\\Downloads\\test.xlsx";
		FileInputStream file =new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet st = wb.getSheet("Sheet4");
		XSSFRow rw = st.getRow(a);
		XSSFCell cl = rw.getCell(b);
		return cl.getStringCellValue();
	}
}
