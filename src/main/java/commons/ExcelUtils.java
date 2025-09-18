//package commons;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelUtils {
//    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = WorkbookFactory.create(fis);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        int rows = sheet.getPhysicalNumberOfRows();
//        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
//
//        Object[][] data = new Object[rows - 1][cols]; // bỏ header row
//
//        for (int i = 1; i < rows; i++) {  // bắt đầu từ row 1
//            for (int j = 0; j < cols; j++) {
//                Cell cell = sheet.getRow(i).getCell(j);
//                data[i - 1][j] = cell.toString();
//            }
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//}
