package com.TestScenarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {

	@Test
	public void createexcelshhet() throws Exception {

		String path = "./testData/outputFile.xls";
		File f = new File(path);
		FileOutputStream fo = new FileOutputStream(f);

		WritableWorkbook ww = Workbook.createWorkbook(fo);
		WritableSheet ws = ww.createSheet("testing", 0);

		// temparory system will store the data into RAM location
		// to send to specified location use fileoutputstream & lable....

		Label a = new Label(2, 3, "Deepak");
		ws.addCell(a);

		Label b = new Label(8, 2, "Nagesh");
		ws.addCell(b);

		ww.write();
		ww.close();

	}

}
