/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;

/**
 *
 * @author hasil
 */
public class ReadFile {

    public JSONArray readExcel(String file_path) {
        JSONArray array = new JSONArray();
        try {

            Workbook workbook = WorkbookFactory.create(new File(file_path));
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter data = new DataFormatter();

            //read excel row and cell
            for (Row row : sheet) {
                JSONArray key = new JSONArray();

                for (Cell cell : row) {
                    String cell_value = data.formatCellValue(cell);
                    key.put(cell.getColumnIndex(), cell_value);

                }
                array.put(key);
            }
            workbook.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public JSONArray fillData(String file_path) throws Exception {
        JSONArray array = new JSONArray();
        jxl.Workbook workbook = null;
        workbook = (jxl.Workbook) WorkbookFactory.create(new File(file_path));
//        workbook = jxl.Workbook.getWorkbook(f);

        jxl.Sheet sheet = workbook.getSheet(0);

        for (int i = 0; i < sheet.getColumns(); i++) {
            jxl.Cell cell1 = sheet.getCell(i, 0);
            array.put(cell1.getContents());

        }

        for (int j = 1; j < sheet.getRows(); j++) {

            jxl.Cell cell = sheet.getCell(0, j);
            array.put(cell.getContents());

        }

        return array;

    }

}
