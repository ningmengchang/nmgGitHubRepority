package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.glass.ui.TouchInputSupport;

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

public class ImportExcel {
	private int totalRows=0;
	private int totalCells = 0;
	public  void  loadScoreInfo(String xlsPath) throws IOException{
		FileInputStream fileIn = new FileInputStream("C:\\Users\\ningm\\Desktop\\导入模板.xlsx");
		//根据指定的文件输入流导入Excel从而产生Workbook对象
		Workbook wb = new XSSFWorkbook(fileIn);
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        // 循环Excel行数
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            // 循环Exce
            Map<String, Object> map = new HashMap<String, Object>();
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        String name = String.valueOf(cell.getNumericCellValue());
                        map.put("name", name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));// 名称
                    } else {
                        map.put("name", cell.getStringCellValue());// 名称
                    }
                }
            }
            // 添加到list
            userList.add(map);
        }
        System.out.println("结束");
	}
	public static void main(String[] args){
		ImportExcel importExcel=new ImportExcel();
		try {
			importExcel.loadScoreInfo("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
