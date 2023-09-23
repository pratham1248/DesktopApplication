
package quizapp;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel37_40_41_42_45 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("input.xlsx"); // change file name as needed
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // assuming the data is on the first sheet

            int columnToCheck = 1; // assuming we want to check column B

            DataFormatter formatter = new DataFormatter();
            boolean isAscending = true;
            Row prevRow = null;
            for (Row row : sheet) {
                if (prevRow != null) {
                    Cell currentCell = row.getCell(columnToCheck);
                    Cell prevCell = prevRow.getCell(columnToCheck);
                    String currentVal = formatter.formatCellValue(currentCell);
                    String prevVal = formatter.formatCellValue(prevCell);
                    if (currentVal.compareTo(prevVal) < 0) {
                        isAscending = false;
                        break;
                    }
                }
                prevRow = row;
            }

            if (isAscending) {
                System.out.println("The column is sorted in ascending order.");
            } else {
                System.out.println("The column is not sorted in ascending order.");
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

