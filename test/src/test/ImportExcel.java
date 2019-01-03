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
		FileInputStream fileIn = new FileInputStream("C:\\Users\\ningm\\Desktop\\����ģ��.xlsx");
		//����ָ�����ļ�����������Excel�Ӷ�����Workbook����
		Workbook wb = new XSSFWorkbook(fileIn);
        // �õ���һ��shell
        Sheet sheet = wb.getSheetAt(0);
        // �õ�Excel������
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // �õ�Excel������(ǰ����������)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        // ѭ��Excel����
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            // ѭ��Exce
            Map<String, Object> map = new HashMap<String, Object>();
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        String name = String.valueOf(cell.getNumericCellValue());
                        map.put("name", name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1));// ����
                    } else {
                        map.put("name", cell.getStringCellValue());// ����
                    }
                }
            }
            // ��ӵ�list
            userList.add(map);
        }
        System.out.println("����");
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
