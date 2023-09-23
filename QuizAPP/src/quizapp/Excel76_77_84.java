
package quizapp;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel76_77_84 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("input.xlsx"); // change file name as needed
            Workbook workbook = WorkbookFactory.create(file);

            int row1 = 6; // row index of first cell
            int col1 = 0; // column index of first cell
            int row2 = 7; // row index of second cell
            int col2 = 0; // column index of second cell

            Cell cell1 = workbook.getSheetAt(0).getRow(row1).getCell(col1);
            CellStyle style1 = cell1.getCellStyle();

            Cell cell2 = workbook.getSheetAt(0).getRow(row2).getCell(col2);
            CellStyle style2 = cell2.getCellStyle();

            boolean formatsEqual = style1.equals(style2);
            System.out.println("Formatting of cell (" + row1 + ", " + col1 + ") and cell (" + row2 + ", " + col2 + ") is equal: " + formatsEqual);

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
