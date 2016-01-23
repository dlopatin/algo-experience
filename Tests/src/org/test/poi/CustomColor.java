package org.test.poi;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class CustomColor extends BasePoiClass {

	@Test
	public void testCustomColor() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)).getIndex());
		Sheet sheet = workbook.createSheet();
		Cell cell = sheet.createRow(0).createCell(0);
		cell.setCellValue("Hello");
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(cellStyle);
		writeWorkbook(workbook, "testCustomColor.xlsx");
	}

}
