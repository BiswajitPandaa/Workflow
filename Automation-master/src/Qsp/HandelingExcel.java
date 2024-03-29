package Qsp;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class HandelingExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/acti.xlsx");
		Workbook w= WorkbookFactory.create(fis);
	int count = w.getSheet("Sheet1").getLastRowNum();
	int count1 = w.getSheet("Sheet1").getRow(1).getLastCellNum();
	for(int i =0; i<count;i++)
	{
		for(int j =0; j<count1;j++) {
			String unpwd= w.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
		
			System.out.println(unpwd);
			
		}
		
	}
	

	}

}
