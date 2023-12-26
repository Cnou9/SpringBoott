package com.example.demostreamapi.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.example.demostreamapi.model.Person;
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
    public List<Person> readFile(String filePath) {
        List<Person> people = new ArrayList<>();

        Path path = Paths.get(filePath);
        try {
            FileReader filereader = new FileReader(path.toFile());
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();

            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                Person person = new Person();
                person.setId(Integer.valueOf(row[0]));
                person.setFullname(row[1]);
                person.setJob(row[2]);
                person.setGender(row[3]);
                person.setCity(row[4]);
                person.setSalary(Integer.valueOf(row[5]));
                person.setBirthday(LocalDate.parse(row[6]));

                people.add(person);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return people;
    }
}