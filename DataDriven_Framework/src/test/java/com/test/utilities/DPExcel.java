package com.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPExcel {

    @DataProvider(name = "excelData", parallel = true)
    public Object[][] excelDataProvider() throws IOException {
        Object[][] arrObj = getExcelData(
                "D:\\Expleo\\TestNG\\DataDriven_Framework\\src\\test\\resources\\File.xlsx",
                "Sheet1");
        return arrObj;
    }

    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            XSSFRow row = sheet.getRow(0);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = row.getLastCellNum();

            data = new String[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString();
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }

        return data;
    }
}