package com.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		
		File xlsxFile = new File(System.getProperty("user.dir")+ "//src//testData//"+fileName);
		XSSFWorkbook xssfWorkbook = null;
		try {
			
			
			
			
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
		} 
		
		
		
		
		catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
	XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
	
	Iterator<Row> rowIterator = xssfSheet.iterator();
	rowIterator.next();
		
	while(rowIterator.hasNext()) {
		 row = rowIterator.next();
		
		 emailAddressCell = row.getCell(0);
		 passwordCell=row.getCell(1);
		 user = new User(emailAddressCell.toString(), passwordCell.toString());
		userList.add(user);
	}
		
		try {
			xssfWorkbook.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return userList.iterator();
		
	}
}
