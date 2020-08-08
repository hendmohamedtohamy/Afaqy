package cairo360.cairo360;

import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class TestDataDefine {
		
		public String testdata( int x,int y) throws FileNotFoundException, IOException, InvalidFormatException
		{
			File f=new File(System.getProperty("user.dir")+
					"\\Datatest\\test-data.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(f);
			XSSFSheet sht=wb.getSheet("Sheet1");
			String testdata1=sht.getRow(x).getCell(y).getStringCellValue();
			return  testdata1;
		}



		public int count() throws IOException, InvalidFormatException 
		{
			File f=new File(System.getProperty("user.dir")+
					"\\Datatest\\test-data.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(f);
			XSSFSheet sht=wb.getSheet("Sheet1");
			int count=sht.getPhysicalNumberOfRows();
			return count;
		}

	}

