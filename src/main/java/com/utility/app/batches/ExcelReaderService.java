package com.utility.app.batches;

import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ExcelReaderService {
    @Autowired
    UploadExcelUtils uploadExcelUtils;

    public String readExcel(MultipartFile file) throws IOException, CsvException {
        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int rowNumber = 0;
            List<String> columns =new ArrayList<>();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    if(rowNumber==0){
                        columns.add(cellIterator.next().getStringCellValue());
                    } else {
                        Cell currentCell = cellIterator.next();
                        if (currentCell.getCellType() == CellType.STRING) {
                            System.out.print(currentCell.getStringCellValue() + "--");
                        } else if (currentCell.getCellType() == CellType.NUMERIC) {
                            System.out.print(currentCell.getNumericCellValue() + "--");
                        }
                    }
                }
                System.out.println();
                rowNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "xml";
    }

    public String readExcelFile(MultipartFile multipartFile) throws IOException {
        StringBuffer buffer = new StringBuffer("<items>");
        Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
//        Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(),false);
        Supplier<Stream<Row>> rowStreamSupplier = uploadExcelUtils.getRowStreamSupplier(sheet);

        Row headerRow = rowStreamSupplier.get().findFirst().get();
        List<String> headerCells = StreamSupport.stream(headerRow.spliterator(),false).map(Cell::getStringCellValue).collect(Collectors.toList());
//        rowStreamSupplier.get().skip(1).map(row ->{
//            buffer.append("</item>");
//            Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
//            List<String>cellVals = cellStream.map(cell -> {
//                return cell.getStringCellValue();
//            }).collect(Collectors.toList());
//            for(int i = 0 ;i <cellVals.size();i++){
//                String columnKey = headerCells.get(i);
//                buffer.append("<").append(columnKey).append(">");
//                buffer.append(cellVals.get(i));
//                buffer.append("</").append(columnKey).append(">");
//            }
//            buffer.append("</item>");
//        });
        buffer.append("</items>");
        return buffer.toString();
    }

}
