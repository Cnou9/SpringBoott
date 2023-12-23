//package com.example.demo1.utils;
//
//import com.example.demo1.model.Book;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Component("ExcelFileReader")
//@Slf4j
//public class ExcelFileReader implements IFileReader {
//    private final ResourceLoader resourceLoader;
//
//    public ExcelFileReader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
//    @Override
//    public List<Book> readFile(String filePath) {
//        List<Book> bookList = new ArrayList<>();
//
//        Resource resource = resourceLoader.getResource(filePath);
//        try {
//            InputStream inputStream = resource.getInputStream();
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            rowIterator.next(); // Skip header row
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                Cell idCell = row.getCell(0);
//                Cell titleCell = row.getCell(1);
//                Cell authorCell = row.getCell(2);
//                Cell yearCell = row.getCell(3);
//
//                Book book = new Book();
//                book.setId((int) idCell.getNumericCellValue());
//                book.setTitle(titleCell.getStringCellValue());
//                book.setAuthor(authorCell.getStringCellValue());
//                book.setYear((int) yearCell.getNumericCellValue());
//
//                bookList.add(book);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bookList;
//    }
//}
//
