package Services;

import Entities.Employee;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class Utils {
    public static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void createExcel(ArrayList<Employee> employees, String pathname)  {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Salary");
        ArrayList<Employee> list = employees;

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
        style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

        row = sheet.createRow(rownum);

        // First Name
        cell = row.createCell(0, STRING);
        cell.setCellValue("First Name");
        cell.setCellStyle(style);
        // Second Name
        cell = row.createCell(1, STRING);
        cell.setCellValue("Second Name");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, STRING);
        cell.setCellValue("Salary");
        cell.setCellStyle(style);
        //Emplopyee Type
        cell = row.createCell(3, STRING);
        cell.setCellValue("Employee Type");
        cell.setCellStyle(style);

        // Data
        for (Employee emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            // First Name (A)
            cell = row.createCell(0, STRING);
            cell.setCellValue(emp.getFirstName());
            // Second Name (B)
            cell = row.createCell(1, STRING);
            cell.setCellValue(emp.getSecondName());
            // Salary (C)
            cell = row.createCell(2, NUMERIC);
            cell.setCellValue(emp.calculateSalary());
            //Employee Type
            cell = row.createCell(3, STRING);
            cell.setCellValue(emp.getClass().getSimpleName());
        }

        // Create Cell type of FORMULA
        row = sheet.createRow(list.size() + 1);
        cell = row.createCell(2, CellType.FORMULA);

// Set formula
        String formula = "SUM(C2:C" + list.size() + ")";
        cell.setCellFormula(formula);
        File file = new File(pathname);
        file.getParentFile().mkdirs();

        FileOutputStream outFile = null;
        try {
            outFile = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Created file: " + file.getAbsolutePath());

    }

    public static void menuOptions() {
        System.out.println("Select action: ");
        System.out.println("0 - to shutdown ");
        System.out.println("1 - Add New Employee");
        System.out.println("2 - Show Employees Info");
        System.out.println("3 - Salary calculation + Save to Excel");
        System.out.println("4 - Sort Employees by Salary rate Descending");
        System.out.println("5 - Sort Employees by Salary rate Ascending");
        System.out.println("6 - to print a list of available actions");
    }

}
