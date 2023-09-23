// question that says copy content in E3 cell and paste it down in E10 cell is right or wrong
package quizapp;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    
    public static void main(String[] args) {
        
        String filepath = "C:/Users/Shreyas/.eclipse/file.xlsx";
        String sourceCell = "E3";
        String targetCell = "E10";
        boolean isValid = checkCopyPasteInstruction(filepath, sourceCell, targetCell);
        
        if (isValid) {
            System.out.println("The copy-paste instruction is valid.");
        } else {
            System.out.println("The copy-paste instruction is invalid.");
        }
    }
    
    private static boolean checkCopyPasteInstruction(String filepath, String sourceCell, String targetCell) {
        try (FileInputStream inputStream = new FileInputStream(filepath)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // assuming we're checking the first sheet
            Row sourceRow = sheet.getRow(Integer.parseInt(sourceCell.substring(1)) - 1);
            Cell sourceCellObj = sourceRow.getCell(getColumnIndex(sourceCell));
            if (sourceCellObj.getCellType() == CellType.BLANK) {
                System.out.println("Source is Blank");
                return false; // the source cell is blank
            }
            
            Row targetRow = sheet.getRow(Integer.parseInt(targetCell.substring(1)) - 1);
            Cell targetCellObj = targetRow.getCell(getColumnIndex(targetCell));
            String sourceCellContent = sourceCellObj.toString();
            String targetCellContent = targetCellObj.toString();
            if (targetCellObj.getCellType() == CellType.BLANK) {
                System.out.println("Target is Blank");
                return false; // the target cell is not blank, which means it's already been pasted into
                
            }
            if(!sourceCellContent.equals(targetCellContent))
            {
                return false;
            }
            
            // everything checks out, the instruction is valid
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false; // something went wrong
        }
    }
    
    private static int getColumnIndex(String cellRef) {
        String columnRef = cellRef.replaceAll("[0-9]", "");
        int columnNum = 0;
        for (int i = 0; i < columnRef.length(); i++) {
            columnNum *= 26;
            columnNum += columnRef.charAt(i) - 'A' + 1;
        }
        return columnNum - 1;
    }
}
