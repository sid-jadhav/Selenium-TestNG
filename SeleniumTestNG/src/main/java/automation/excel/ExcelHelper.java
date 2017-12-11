package automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	public final static int TestCase_ColumnNo=0;
	public final static int TestCase_Execution=1;
	/*	This function creates an excel sheet at given fileLoaction 
	 *  and with given fileName
	 */
	public void createXL(String fileName, String fileLocation){
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(new File(fileLocation+fileName));
			XSSFWorkbook xl= new XSSFWorkbook();
			XSSFSheet sheet= xl.createSheet("Dummy");
			XSSFRow row= sheet.createRow(0);
			Cell cell=row.createCell(0);
			cell.setCellValue("Sid");
			xl.write(fout);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/* This function returns String value in the given row and column cell  
	 * @param mySheet Sheet object 
	 * 		  row given row number
	 * 		  col given row column
	 */
	public synchronized String getCellData(XSSFSheet mySheet,int row,int col){
		XSSFRow r= mySheet.getRow(row);
		XSSFCell cell =r.getCell(col); 
		return cell.getStringCellValue();
	}
	/* This function return the row number 
	 * @param mySheet Is the object of sheet that we need to search in
	 * 		  testCaseId is what we need to search the rows with 
	 * 
	 */
	public synchronized int findRow(XSSFSheet mySheet,String testCaseId){
		int rowNo=0;
		while(rowNo<=mySheet.getLastRowNum()){
			//System.out.println(mySheet.getLastRowNum());
			XSSFRow row=mySheet.getRow(rowNo);
			if(row==null){
				//System.out.println("Empty Row");
			}else{
				if(row.getCell(0).getStringCellValue().contains(testCaseId))
				{
					return rowNo;
				}
			}
			rowNo++;
		}
		
		return -1;
	}
	/* This function returns Sheet object 
	 * @param fileName name of file to be loaded 
	 * 		  sheetName name of sheet thats object needs to be returned
	 */
	public synchronized XSSFSheet getSheet(String fileName,String sheetName){
		String path="C:\\Users\\LENOVO\\git\\Selenium-TestNG\\SeleniumTestNG\\src\\test\\resources\\ExcelData\\";
		FileInputStream fin;
		XSSFWorkbook xl;
		try {
			fin=new FileInputStream(new File(path+fileName));
			xl=new XSSFWorkbook(fin);
			return xl.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
