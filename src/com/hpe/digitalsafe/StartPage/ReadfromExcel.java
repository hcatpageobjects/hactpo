package com.hpe.digitalsafe.StartPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfromExcel {

	// variables

	private File myFile;
	private FileInputStream fis;

	private XSSFWorkbook wb = null;
	private XSSFSheet mySheet;

	// Dictionary for Column Names
	private ArrayList<String> columnNames = new ArrayList<String>();
	// Dictionary for Client Names
	private HashMap<String, Integer> clientNames = new HashMap<String, Integer>();
	private Boolean duplicateClients = false;
	private Boolean emtpyCell = false;

	// Constructor
	public ReadfromExcel(String sheetName, String location) {
		super();
		// this.clientName = clientName;
		this.myFile = new File(location);

		try {
			this.fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.mySheet = wb.getSheet(sheetName);
	}

	public Boolean getDuplicateClients() {
		return duplicateClients;
	}

	public Boolean getEmtpyCell() {
		return emtpyCell;
	}

	public void setColumnNames() {
		Row clientRow = mySheet.getRow(0);
		for (int i = 0; i < clientRow.getLastCellNum(); i++) {
			// System.out.println(clientRow.getCell(i).toString());
			// clientData.add(clientRow.getCell(i).toString());
			columnNames.add(clientRow.getCell(i).toString().toLowerCase().trim());
		}
	}

	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setClientsName(String columnName, String location) {

		int columnIndex = columnNames.indexOf(columnName);
		Row myRow;
		Cell mycell;
		String name = null;
		XSSFCellStyle style = wb.createCellStyle();

		style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		for (int i = 1; i <= mySheet.getLastRowNum(); i++) {
			myRow = mySheet.getRow(i); // sets the row value
			// System.out.println(myRow);
			try {
				mycell = myRow.getCell(columnIndex);
				name = mycell.getStringCellValue().toString();
				if (clientNames.get(name) != null) {
					System.out.println("Row: " + i + "is a duplicate ");
					duplicateClients = true;
					mycell.setCellStyle(style);
				} else {
					clientNames.put(name, i);
				}

			} catch (NoSuchElementException | NullPointerException e) {
				System.out.println("Row: " + i + "is empty: " + e);
			}
		}
		if (duplicateClients) {
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(location);
				wb.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, Integer> getClientsNameList(String colName, String location) {
		setColumnNames();
		setClientsName(colName, location);
		// Set<String> keys = clientNames.keySet();
		// for(String key:keys){System.out.println("readfrom excel keys: "+
		// key);}
		return clientNames;
	}

	// sets index number to find clients information
	public HashMap<String, String> getClientRowInformation(String clientName) {

		// Gets all the information for Key "clientName" which is the row number
		Row clientRow = mySheet.getRow(clientNames.get(clientName)); // example
																		// row=5
		HashMap<String, String> clientData = new HashMap<String, String>();
		String key = "";
		String value = "";

		for (int i = 0; i < clientRow.getLastCellNum(); i++) {
			System.out.println("length of row:" + clientRow.getLastCellNum());
			key = columnNames.get(i);
			// System.out.println(key);
			try {
				value = clientRow.getCell(i).toString();
				clientData.put(key, value);
			} catch (NoSuchElementException | NullPointerException e) {
				System.out.println("validating empty cells");
				emtpyCell = true;
				break;
			}
		}

		return clientData;
	}

	public void closeConnection() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
