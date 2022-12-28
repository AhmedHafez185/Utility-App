package com.utility.app.batches;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CSVFileParser implements FileParser{

    @Override
    public String parseFile(MultipartFile multipartFile) throws IOException, CsvException, InterruptedException {
        Map<String, Object> currentRowData;
        CSVReader csvReader = getCSVReader(multipartFile);
        String xml = mapCSV(csvReader);
        return xml;
    }
    private CSVReader getCSVReader(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        return new CSVReader(reader);
    }
    private String mapCSV(CSVReader csvReader) throws CsvException, IOException, InterruptedException {

        StringBuffer buffer = new StringBuffer("<items>");

        String[] columns = csvReader.readNext();
        List<Map<String, Object>> excelSheetRows = new ArrayList<Map<String, Object>>();
        Map<String, Object> currentRowData = null;
        try {
            List<String[]> rows = csvReader.readAll();
           CountDownLatch latch = new CountDownLatch(1);;
            AtomicInteger count = new AtomicInteger();
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int noOfThreads = 1;
            for (String[] row : rows) {
                noOfThreads++;
                latch = new CountDownLatch(noOfThreads);
                Thread.sleep(1000);
                RunnableRequest task1 = new RunnableRequest(columns,row ,latch);
                executorService.submit(task1);
                System.out.println("Progress Bar is : "+(count.get() / 51) *100 + " %");
                count.getAndIncrement();
//                System.out.println("row : "+row.length);
//                buffer.append("<item>");
//
//                if (row.length == 0) {
//                    break;
//                }
//                currentRowData = new HashMap<String, Object>();
//                for (int i = 0; i < row.length; i++) {
//                    String columnKey = columns[i];
////                        currentRowData.put(columnKey, row[i]);
//                    buffer.append("<").append(columnKey).append(">");
//                    buffer.append(row[i]);
//                    buffer.append("</").append(columnKey).append(">");
//                }
////                excelSheetRows.add(currentRowData);
//                buffer.append("</item>");
            }
            executorService.shutdown();
        } catch (Exception ex) {
            throw ex;
        }
        buffer.append("</items>");

        return buffer.toString();
    }
}
