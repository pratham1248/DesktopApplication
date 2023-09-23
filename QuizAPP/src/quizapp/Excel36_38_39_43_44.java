package quizapp;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel36_38_39_43_44 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("input.xlsx"); // change file name as needed
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // assuming the data is on the first sheet

            int columnToCheck = 1; // assuming we want to check column B

            DataFormatter formatter = new DataFormatter();
            boolean isDescending = true;
            Row prevRow = null;
            for (Row row : sheet) {
                if (prevRow != null) {
                    Cell currentCell = row.getCell(columnToCheck);
                    Cell prevCell = prevRow.getCell(columnToCheck);
                    String currentVal = formatter.formatCellValue(currentCell);
                    String prevVal = formatter.formatCellValue(prevCell);
                    if (currentVal.compareTo(prevVal) > 0) {
                        isDescending = false;
                        break;
                    }
                }
                prevRow = row;
            }

            if (isDescending) {
                System.out.println("The column is sorted in descending order.");
            } else {
                System.out.println("The column is not sorted in descending order.");
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


