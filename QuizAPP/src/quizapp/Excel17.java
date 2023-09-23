
package quizapp;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel17 {
   public static void main(String[] args) throws IOException {
      // Load Excel file
      FileInputStream file = new FileInputStream("sample.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheetAt(0);
      
      // Define the cell to check
      int rowNum = 11;
      int colNum = 7;
      XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
      
      // Get the cell font
      XSSFFont font = cell.getCellStyle().getFont();
      
      // Check if the font is Verdana
      boolean isVerdana = font.getFontName().equalsIgnoreCase("Verdana");
      
      if (isVerdana) {
         System.out.println("Cell (" + rowNum + "," + colNum + ") has Verdana font.");
      } else {
         System.out.println("Cell (" + rowNum + "," + colNum + ") does not have Verdana font.");
      }
      
      // Close the file
      file.close();
   }
}
