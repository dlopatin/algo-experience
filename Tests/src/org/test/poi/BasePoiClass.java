package org.test.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

public class BasePoiClass {

	public void writeWorkbook(Workbook workbook, String fileName) throws IOException {
		FileOutputStream out = new FileOutputStream(new File("src/org/test/poi/" + fileName));
		workbook.write(out);
		workbook.close();
		out.close();
	}

}
