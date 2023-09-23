
package quizapp;


import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel7_8_9 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("example.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int columnIndex = 1; // Column B
        boolean isAutoFit = sheet.getColumnWidth(columnIndex) == -1;
        if (isAutoFit) {
            System.out.println("Column " + (columnIndex + 1) + " is set to auto-fit.");
        } else {
            System.out.println("Column " + (columnIndex + 1) + " is not set to auto-fit.");
        }
        workbook.close();
        inputStream.close();
    }
}
