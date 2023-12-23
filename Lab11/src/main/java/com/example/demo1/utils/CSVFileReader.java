package com.example.demo1.utils;

import com.example.demo1.model.Book;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component("CSVFileReader")
public class CSVFileReader implements IFileReader {
    private final ResourceLoader resourceLoader;

    public CSVFileReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<Book> readFile(String filePath) {
        List<Book> bookList = new ArrayList<>();

        Resource resource = resourceLoader.getResource(filePath);
        try (InputStream inputStream = resource.getInputStream();
             InputStreamReader reader = new InputStreamReader(inputStream);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withSkipLines(1)
                     .build()) {

            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                Book book = new Book();
                book.setId(Integer.parseInt(row[0].trim()));
                book.setTitle(row[1].trim());
                book.setAuthor(row[2].trim());
                book.setYear(Integer.parseInt(row[3].trim()));

                bookList.add(book);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return bookList;
    }
}
