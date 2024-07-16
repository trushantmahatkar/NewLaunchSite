package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet sh;
public static XSSFRow row;
public static XSSFCell cell;
public static CellStyle style;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		int rowCount= sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		  if (row == null) 
		    {
	            // Return 0 or handle the situation where row is null
	            wb.close();
	            fi.close();
	            return 0; // Or throw an exception or return -1 depending on your logic
	        }
		int cellCount= row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static String getCellData(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		  if (row == null) {
	            // Return 0 or handle the situation where row is null
	            wb.close();
	            fi.close();
	            return ""; // Or throw an exception or return -1 depending on your logic
	        }
		cell=row.getCell(colnum);
		String data;
		try 
		{
//			data= cell.toString();
			DataFormatter formatter= new DataFormatter();//formatter.formatCellValue(cell) --it will also give data  in string format
			data= formatter.formatCellValue(cell);//it will return data irrespective of cell type same as that of to String method
			wb.close();
			fi.close();
			return data;
		}
		catch(Exception e)
		{
			data="";
			return data;
		}
	}
	public static void setCellData(String xlfile, String xlsheet, int rownum,int colnum, String data) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		if (row == null) {
            // Handle case where row is null (could create a new row or throw an exception)
            // For now, assuming no creation of new row
            wb.close();
            fi.close();
            throw new IllegalArgumentException("Row " + rownum + " does not exist or is null.");
        }
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void greenColor(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		if (row == null) {
            // Handle case where row is null (could create a new row or throw an exception)
            // For now, assuming no creation of new row
            wb.close();
            fi.close();
            throw new IllegalArgumentException("Row " + rownum + " does not exist or is null.");
        }
		cell=row.createCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void redColor(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
	{
		fi =new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		if (row == null) {
            // Handle case where row is null (could create a new row or throw an exception)
            // For now, assuming no creation of new row
            wb.close();
            fi.close();
            throw new IllegalArgumentException("Row " + rownum + " does not exist or is null.");
        }
		cell=row.createCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
