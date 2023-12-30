package com.example.lab15.utils;

import com.example.lab15.model.Car;
import com.example.lab15.utils.IFileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Primary
@Component
public class CSVFileReader implements IFileReader {
    @Override
    public List<Car> readFile(String filePath) {
        List<Car> carList = new ArrayList<>();

        Path path = Paths.get(filePath);
        try {
            FileReader filereader = new FileReader(path.toFile());
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();

            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                Car car = new Car();
                car.setId(Integer.valueOf(row[0]));
                car.setName(row[1]);
                car.setDescription(row[2]);
                car.setThumbnail(row[3]);
                car.setPrice(Integer.valueOf(row[4]));
                car.setRating(Double.valueOf(row[5]));
                car.setPriceDiscount(Integer.valueOf(row[6]));

                carList.add(car);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return carList;
    }
}