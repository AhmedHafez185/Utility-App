package com.utility.app.batches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/csv/")
public class CSVController {
    @Autowired
    CSVReaderService csvReader;
@Autowired
ExcelReaderService excelService;
    @PostMapping("upload")
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile patchFile) throws Exception {
        if (!patchFile.isEmpty()) {
            try {

                // convert MultipartFile to file
                File resultFileCSV = null;
                String timeStampFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh:mm:ss.SSS"));
                String uploadedBatchFileName = patchFile.getName();
                String xmlFormat = csvReader.readCSV(patchFile);
           //    String xmlFormat = excelService.readExcelFile(patchFile);

                String endTimeStampFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh:mm:ss.SSS"));
                System.out.println("Start Time : "+timeStampFormat +" , and End Time : "+endTimeStampFormat);
                return ResponseEntity.ok(xmlFormat);
            } catch (Exception e) {
                throw e;
            }

        } else {
            throw new Exception("Patch File is Empty File");
        }
    }
}
