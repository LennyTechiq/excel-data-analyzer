package com.lenny.Excel.Data.Analyzer.controller;

import com.lenny.Excel.Data.Analyzer.entity.ExcelData;
import com.lenny.Excel.Data.Analyzer.utility.ExcelFileReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Controller
public class ExcelController {

    @GetMapping("/")
    public String showUploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try (InputStream inputStream = file.getInputStream()) {
            List<ExcelData> dataList = ExcelFileReader.readExcel(inputStream);

            // Extract column headers from the first row
            List<String> columnHeaders = new ArrayList<>();
            if (!dataList.isEmpty()) {
                ExcelData firstRow = dataList.get(0);
                columnHeaders.add(firstRow.getFirstName());
                columnHeaders.add(firstRow.getMiddleName());
                columnHeaders.add(firstRow.getLastName());
            }

            model.addAttribute("dataList", dataList.subList(1, dataList.size()));
            model.addAttribute("columnHeaders", columnHeaders);
        } catch (IOException | InvalidFormatException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            // handle exception
        }
        return "displayData";
    }

    private List<String> getColumnHeaders(Class<?> clazz) {
        List<String> columnHeaders = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> columnHeaders.add(field.getName()));
        return columnHeaders;
    }
}
