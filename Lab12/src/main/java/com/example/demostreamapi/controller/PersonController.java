package com.example.demostreamapi.controller;

import com.example.demostreamapi.database.InitData;
import com.example.demostreamapi.model.Person;
import com.example.demostreamapi.repository.PersonRepository;
import com.example.demostreamapi.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String getHome(Model model){
        return "getHome";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("people",personRepository.getAll());
        return "getAll";
    }
    @GetMapping("/sortPeopleByFullName")
    public  String sortPeopleByFullName(Model model){
        model.addAttribute("people",personRepository.sortPeopleByFullName());
        return "sortPeopleByFullName";
    }
    @GetMapping("/getSortedJobs")
    public String getSortedJobs(Model model) {
        model.addAttribute("jobs",personRepository.getSortedJobs());
        return "getSortedJobs";
    }
    @GetMapping("/getSortedCities")
    public String getSortedCities(Model model){
        model.addAttribute("cities",personRepository.getSortedCities());
        return "getSortedCities";
    }


    @GetMapping("/groupPeopleByCity")
    public String groupPeopleByCity(Model model) {
        model.addAttribute("peopleByCity", personRepository.groupPeopleByCity());
        return "groupPeopleByCity";
    }

    @GetMapping("/groupJobByCount")
    public String groupJobByCount(Model model) {
        model.addAttribute("jobCounts", personRepository.jobCounts());
        return "groupJobByCount";
    }

    @GetMapping("/aboveAverageSalary")
    public String aboveAverageSalary(Model model) {
        model.addAttribute("aboveAverageSalaryPeople", personRepository.aboveAverageSalary());
        return "aboveAverageSalary";
    }

    @GetMapping("/longestName")
    public String longestName(Model model) {
       model.addAttribute("longestName",personRepository.longestName());
        return "longestName";
    }



}
