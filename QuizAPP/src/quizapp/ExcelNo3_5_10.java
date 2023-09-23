
package quizapp;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelNo3_5_10 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("example.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowHeight = sheet.getRow(0).getHeight();
        System.out.println("Row height of row 1 is " + rowHeight);
        if(rowHeight==35)
        {
            System.out.println("Correct Answer");
        }
        workbook.close();
        inputStream.close();
    }
}

