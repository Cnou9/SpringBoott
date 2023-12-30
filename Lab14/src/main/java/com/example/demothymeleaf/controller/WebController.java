package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    List<Student> studentList=List.of(
            new Student(1,"Cường1","1@gmail.com","01",10),
            new Student(2,"Cường2","2@gmail.com","02",9),
            new Student(3,"Cường3","3@gmail.com","03",9),
            new Student(4,"Cường4","4@gmail.com","04",8),
            new Student(5,"Cường5","5@gmail.com","05",9),
            new Student(6,"Cường6","6@gmail.com","06",10)

    );

    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(required = false) String rank){//Model trong ui
        Student student= new Student(1,"Cường","1@123","0000",10);
        model.addAttribute("student" /*key*/,student);

        List<Student> students=new ArrayList<>();
        if(rank!=null){
            if(rank.equalsIgnoreCase("gioi")){
                students=studentList.stream()
                        .filter(s -> s.getScore() > 8)
                        .toList();
            } else if (rank.equalsIgnoreCase("kha")){
                students=studentList.stream()
                        .filter(s -> s.getScore()<=8)
                        .toList();
            }
        } else{
            students=studentList;
        }
        model.addAttribute("studentList" /*key*/,students);
        return "index";
    }

    @GetMapping("/student/{id}")
    public String getStudentDetailPage(@PathVariable int id,Model model){
        Student student=studentList.stream()
                .filter(s -> s.getId() ==  id)
                .findFirst()
                .orElse(null);
        model.addAttribute("student",student);
        return "student-detail";
    }

    @GetMapping("/blog")
    public String getBlogPage(){
        return "admin/blog";
    }

}
