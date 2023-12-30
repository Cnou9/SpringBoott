package com.example.demostreamapi.repository;

import com.example.demostreamapi.database.PersonDB;
import com.example.demostreamapi.model.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class PersonRepository implements PersonsitoryInterface{
    @Override
    public void printListPeople(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getFullname))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getFullname).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.personList.stream()
                .map(Person::getJob)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.personList.stream()
                .map(Person::getCity)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.personList.stream()
                .filter(p -> p.getGender().equalsIgnoreCase("female"))
                .map(Person :: getFullname)
                .collect(Collectors.toList());
    }

    @Override
    public Person highestEarner() {
        return PersonDB.personList.stream()
                .max(Comparator.comparing(Person::getSalary))
                .orElse(null);
    }

    @Override
    public List<Person> bornAfter1990() {
        return PersonDB.personList.stream()
                .filter(p -> p.getBirthday().getYear()>1990)
                .collect(Collectors.toList());
    }

    @Override
    public double averageSalary() {
        return PersonDB.personList.stream()
                .mapToInt(Person::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public double averageAge() {
        return PersonDB.personList.stream()
                .mapToInt(p -> -p.getBirthday().getYear()+ LocalDate.now().getYear())
                .average()
                .orElse(0);
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.personList.stream()
                .filter(p -> p.getFullname().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.personList.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("male"))
                .sorted(Comparator.comparingInt(person -> LocalDate.now().getYear() - person.getBirthday().getYear()))
                .collect(Collectors.toList());
    }

    @Override
    public Person longestName() {
        return PersonDB.personList.stream()
                .max(Comparator.comparingInt(person -> person.getFullname().length()))
                .orElse(null);
    }

    @Override
    public List<Person> aboveAverageSalary() {
        double averageSalary = averageSalary();
        return PersonDB.personList.stream()
                .filter(person -> person.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.personList.stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }


    @Override
    public List inSalaryRange(int start, int end) {
        return PersonDB.personList.stream()
                .filter(person -> person.getSalary() >= start && person.getSalary() <= end)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.personList.stream()
                .filter(person -> person.getFullname().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List sortByBirthYearDescending() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getBirthday).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List top5HighestPaid() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List inAgeRange(int start, int end) {
        int currentYear = LocalDate.now().getYear();
        return PersonDB.personList.stream()
                .filter(person -> currentYear - person.getBirthday().getYear() >= start && currentYear - person.getBirthday().getYear() <= end)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> jobCounts() {
        return PersonDB.personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));

    }



}
