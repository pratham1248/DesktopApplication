
package quizapp;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel25_26 {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("input.xlsx"); // change file name as needed
            Workbook workbook = WorkbookFactory.create(file);

            int startRow = 3; // change these values to specify the range of cells
            int endRow = 10;
            int col = 11; // column index (A=0, B=1, C=2, etc.)
            int answer[]=new int[endRow-startRow+1];   //ans
            int j=0;
            for (int i = startRow; i <= endRow; i++,j++) {
                Cell cell = workbook.getSheetAt(0).getRow(i).getCell(col);
                int value = (int) cell.getNumericCellValue();
                if(value!=answer[j])
                {
                    //return false;
                }
            }
            //return true;

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

