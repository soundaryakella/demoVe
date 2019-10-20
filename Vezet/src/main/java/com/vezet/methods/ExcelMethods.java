package com.vezet.methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelMethods {
	
	//get the no.of rows
	public static int getNoOfRowsFromExcel(String path,String sheetname) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
	//get the no.of column
	public static int getNoOfColumnsFromExcel(String path,String sheetname,int rownumber) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		String cellData = wb.getSheet(sheetname).getRow(rownumber).getCell(0).toString();
		if(cellData!=null)
		{
			return wb.getSheet(sheetname).getRow(rownumber).getLastCellNum();
		}
		else
		{
			return 0;
		}
	}
		//get the data from excel based on row and cell number
		public static String getCellDataFromExcel(String path,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		}
		
		//get the data from excel based on rowdata and columnheader
		public static String getRowData(String path,String sheetname,String rowData,String coloumnHeader) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
		{
			boolean flag=true;
			int rownum=0;
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			for(int i=0;i<wb.getSheet(sheetname).getRow(0).getLastCellNum();i++)
			{
				for(int j=0;j<=wb.getSheet(sheetname).getLastRowNum();j++)
				{
					String rowdata;
					try {
						rowdata=wb.getSheet(sheetname).getRow(j).getCell(i).getStringCellValue().toString();
						if(rowdata.equals(rowData))
						{
							rownum=j;
							System.out.println("row "+j);
							flag=false;	
						}
					}
					catch(Exception e)
					{

					}
					
				}	
			}
			int cellnum=0;;
			if(flag=false)
			{
			for(int i=0;i<wb.getSheet(sheetname).getRow(0).getLastCellNum();i++)
			{
				if(wb.getSheet(sheetname).getRow(0).getCell(i).toString().equals(coloumnHeader))
				{
					cellnum = i;
					System.out.println("cell "+i);
					break;	
				}
			}
			}
			wb.close();
			if(rownum!=0 && cellnum!=0) {
			return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
			}
			else
				return "";
		}
		
		//method to read the all cell values based on rowdata
		public static ArrayList<String> getRowData(String path,String sheetname,String rowData) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
		{
			int rownum=0;
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			for(int i=0;i<wb.getSheet(sheetname).getRow(0).getLastCellNum();i++)
			{
				for(int j=0;j<=wb.getSheet(sheetname).getLastRowNum();j++)
				{
					String rowdata;
					try {
						rowdata=wb.getSheet(sheetname).getRow(j).getCell(i).getStringCellValue().toString();
						if(rowdata.equals(rowData))
						{
							rownum=j;
							
							
						}
					}
					catch(Exception e)
					{

					}
					
				}
				
			}
			int cellnum=0;;
			ArrayList<String> li=new ArrayList();
			for(int i=0;i<wb.getSheet(sheetname).getRow(rownum).getLastCellNum();i++)
			{
				li.add(wb.getSheet(sheetname).getRow(rownum).getCell(i).toString());
			}
			wb.close();
			
			return li;
		}
		
		//method to write the data into the Excel based on row number and column number
		public static void writeDataByRowAndCellNumber(String path,String sheetname,int row,int cell,String data ) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			Row r = wb.getSheet(sheetname).getRow(row);
			wb.getSheet(sheetname).createRow(row).createCell(cell).setCellValue(data);
	        FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
			
			
		}
		
		//method to write data into the Excel based on rowdata and column header
		public static void writeDataByRowDataAndColHeader(String path,String sheetname,String rowData,String coloumnHeader,String data) throws IOException, EncryptedDocumentException, InvalidFormatException
		{
		boolean flag=true;
			int rownum=0;
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			for(int i=0;i<wb.getSheet(sheetname).getRow(0).getLastCellNum();i++)
			{
				for(int j=0;j<=wb.getSheet(sheetname).getLastRowNum();j++)
				{
					String rowdata;
					try {
						rowdata=wb.getSheet(sheetname).getRow(j).getCell(i).getStringCellValue().toString();
						if(rowdata.equals(rowData))
						{
							rownum=j;
							
							flag=false;	
						}
					}
					catch(Exception e)
					{

					}
					
				}	
			}
			int cellnum=0;;
			if(flag=true)
			{
			for(int i=0;i<wb.getSheet(sheetname).getRow(0).getLastCellNum();i++)
			{
				if(wb.getSheet(sheetname).getRow(0).getCell(i).toString().equalsIgnoreCase(coloumnHeader))
				{
					cellnum = i;
					break;	
				}
			}
			}
			
			if(rownum!=0 && cellnum!=0) {
			 wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
			 FileOutputStream fos = new FileOutputStream(path);
			 wb.write(fos);
			 fos.close();
			 
			}
		}
		
	}


