package POM_CLasses;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataFetch 
{	
	public static void main(String [] args) throws IOException
	{
		FileOutputStream file = new FileOutputStream("D:\\Users\\trushantmahatkar\\Downloads\\testData.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet("DATA");
		XSSFRow rw= sh.createRow(1);
		XSSFCell cell= rw.createCell(0);
		cell.setCellValue("Welcome");
		System.out.println("File is created ......");
		wb.write(file);
		wb.close();
		file.close();	
	}

}
