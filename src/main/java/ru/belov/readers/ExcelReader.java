package ru.belov.readers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
    private final File file;

    public ExcelReader(String fileName) {
        this.file = new File(fileName);
    }

    public void readFile() throws IOException, InvalidFormatException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(this.file)) {

//            String new_value = value;
//
//            if(value.equals("AGR") & col == 7)
//            {
//                new_value = "MAGNOX";
//                return new_value;
//            }
//            if(value.equals( "CNP-1000") & col == 7)
//            {
//                new_value = "CPR-1000";
//                return new_value;
//            }
//            if(value.indexOf("PWR") != -1)
//            {
//                new_value = "PWR";
//                return new_value;
//            }
//            if(value.indexOf("VVER") != -1)
//            {
//                new_value = "VVER-1000";
//                return new_value;
//            }
//            return new_value;

        } catch (IOException | InvalidFormatException e) {

        }

    }
}
