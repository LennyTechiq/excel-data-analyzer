package com.lenny.Excel.Data.Analyzer.utility;

import com.lenny.Excel.Data.Analyzer.entity.ExcelData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileReader {

    public static List<ExcelData> readExcel(InputStream inputStream) throws IOException, InvalidFormatException, ParserConfigurationException, SAXException {
        List<ExcelData> dataList = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            DataFormatter dataFormatter = new DataFormatter();
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    ExcelData data = new ExcelData();
                    for (Cell cell : row) {
                        String cellValue = dataFormatter.formatCellValue(cell, formulaEvaluator);
                        switch (cell.getColumnIndex()) {
                            case 0:
                                data.setFirstName(cellValue);
                                break;
                            case 1:
                                data.setMiddleName(cellValue);
                                break;
                            case 2:
                                data.setLastName(cellValue);
                            // Add cases for more columns
                        }
                    }
                    dataList.add(data);
                }
            }
        }

        return dataList;
    }
}
