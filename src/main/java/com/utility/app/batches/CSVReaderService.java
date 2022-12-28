package com.utility.app.batches;

import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class CSVReaderService {

    public String readCSV(MultipartFile file) throws IOException, CsvException, InterruptedException {

        FileParser fileParser = FileParserFactory.getFileParser(file.getOriginalFilename());
        String xmlFormat = fileParser.parseFile(file);
        return xmlFormat;
    }
}
