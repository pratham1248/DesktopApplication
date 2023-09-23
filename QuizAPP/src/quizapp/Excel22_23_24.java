
package quizapp;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel22_23_24 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("input.xlsx"); // change file name as needed
            Workbook workbook = WorkbookFactory.create(file);

            Cell cell = workbook.getSheetAt(0).getRow(22).getCell(10); // assuming the value is in cell A1
            int value = (int) cell.getNumericCellValue();

            System.out.println("Value in cell A1: " + value);
            if(value==500)
            {
                System.out.println("Correct Answer");
            }
            else
            {
                System.out.println("InCorrect Answer");
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
