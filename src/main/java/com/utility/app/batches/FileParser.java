package com.utility.app.batches;

import com.opencsv.exceptions.CsvException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileParser {

    public String parseFile(MultipartFile multipartFile) throws IOException, CsvException, InterruptedException;
}
