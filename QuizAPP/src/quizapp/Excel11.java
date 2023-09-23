
package quizapp;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel11 {
   public static void main(String[] args) throws IOException {
      // Load Excel file
      FileInputStream file = new FileInputStream("sample.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheetAt(0);
      
      // Define the cell to check
      int rowNum = 1;
      int colNum = 0;
      XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
      
      // Get the cell style
      XSSFCellStyle style = cell.getCellStyle();
      
      // Check if the cell has blue background and italic effect
      boolean isBlueBackground = style.getFillForegroundColor() == IndexedColors.LIGHT_BLUE.getIndex();
      boolean isItalic = style.getFont().getItalic();
      
      if (isBlueBackground && isItalic) {
         System.out.println("Cell (" + rowNum + "," + colNum + ") has blue background and italic effect.");
      } else {
         System.out.println("Cell (" + rowNum + "," + colNum + ") does not have blue background and italic effect.");
      }
      
      // Close the file
      file.close();
   }
}


