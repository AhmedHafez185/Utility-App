package com.utility.app.csv_reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaWsdlMappingType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CSVReaderService {

    public String readCSV(MultipartFile file) throws IOException, CsvException {
        Map<String, Object> currentRowData;
        CSVReader csvReader = getCSVReader(file);
        String xml = mapCSV(csvReader);
//        String xml = createXML(excelSheetRows);
        return xml;
    }

    private String createXML(List<Map<String, Object>> excelSheetRows) {

        StringBuffer buffer = new StringBuffer("<items>");
        System.out.println("Number of Rows : "+excelSheetRows.size()+" and number of columns : "+excelSheetRows.get(0).size());
        for (Map<String, Object> map : excelSheetRows) {
            buffer.append("<item>");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                buffer.append("<").append(entry.getKey()).append(">");
                buffer.append(entry.getValue());
                buffer.append("</").append(entry.getKey()).append(">");
            }
            buffer.append("</item>");
        }
        buffer.append("</items>");
        return buffer.toString();
    }

    private CSVReader getCSVReader(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        return new CSVReader(reader);
    }

    private String mapCSV(CSVReader csvReader) throws CsvException, IOException {

        StringBuffer buffer = new StringBuffer("<items>");
//        System.out.println("Number of Rows : "+excelSheetRows.size()+" and number of columns : "+excelSheetRows.get(0).size());
        String[] columns = csvReader.readNext();
        List<Map<String, Object>> excelSheetRows = new ArrayList<Map<String, Object>>();
        Map<String, Object> currentRowData = null;
        try {
            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
//                System.out.println("row : "+row.length);
                buffer.append("<item>");

                if (row.length == 0) {
                    break;
                }
                currentRowData = new HashMap<String, Object>();
                for (int i = 0; i < row.length; i++) {
                    String columnKey = columns[i];
//                        currentRowData.put(columnKey, row[i]);
                    buffer.append("<").append(columnKey).append(">");
                    buffer.append(row[i]);
                    buffer.append("</").append(columnKey).append(">");
                }
//                excelSheetRows.add(currentRowData);
                buffer.append("</item>");
            }
        } catch (Exception ex) {
            throw ex;
        }
        buffer.append("</items>");

         return buffer.toString();
    }
}
