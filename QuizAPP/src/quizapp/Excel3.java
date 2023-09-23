//Write a code in java that checks width of specific coloumn using poi
package quizapp;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class Excel3 {

  public static void main(String[] args) throws IOException {
    // Specify the path and name of the Excel file
    String filePath = "C:/Users/Shreyas/.eclipse/file.xlsx";
    
    // Specify the name of the sheet and the index of the column to check
    String sheetName = "Sheet1";
    int columnIndex = 1; // Zero-based index of the column
    
    // Open the Excel file and get the workbook and sheet objects
    FileInputStream inputStream = new FileInputStream(filePath);
    Workbook workbook = WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheet(sheetName);
    
    // Get the width of the specified column
    
     int widthInCharacters = sheet.getColumnWidth(columnIndex) / 256;
    System.out.println("Column width in cm: " + widthInCharacters);
    
    if(widthInCharacters==30)
    {
        System.out.println("Correct Answer");
    }
    else
    {
        System.out.println("InCorrect Answer");
    }
    
    // Close the input stream and workbook
    inputStream.close();
    workbook.close();
  }

}

