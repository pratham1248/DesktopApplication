//Adding coloumn after G
package quizapp;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2 {
    public static void main(String[] args) {
        try {
            // Open the Excel file
            FileInputStream file = new FileInputStream(new File("C:/Users/Shreyas/.eclipse/file.xlsx"));

            // Load the workbook
            Workbook workbook = WorkbookFactory.create(file);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Get the row containing column G (assuming it exists)
            Row rowG = sheet.getRow(0);
            Cell cellG = rowG.getCell(6);

            // Get the next cell (H) and check if it's null
            Cell cellH = rowG.getCell(7);
            if (cellH == null) {
                System.out.println("A new column has been added after column G.");
            } else {
                System.out.println("Column H already exists.");
            }

            // Close the workbook and file streams
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
