package com.utility.app.batches;

import com.utility.app.utils.AppUtils;

public class FileParserFactory {
    public static FileParser getFileParser(String fileName) {
        String extension = AppUtils.getFileExtension(fileName);
        if (extension.equalsIgnoreCase("csv")) {
            return new CSVFileParser();
        } else if (extension.equalsIgnoreCase("xls")) {

        } else if (extension.equalsIgnoreCase("xls")) {

        }
        return null;
    }


}
