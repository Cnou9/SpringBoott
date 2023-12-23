package com.example.demo1.controller;

import com.example.demo1.model.Book;
import com.example.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    // GET : http://localhost:8080/books
//    @ResponseStatus(HttpStatus.CREATED) // Trả về status code 201
//    @ResponseBody
//    @GetMapping("/books")
//    public List<Book> getBooks() {
//        return bookList;
//    }

//    @GetMapping("/home")
//    public String getHome() {
//        return "home";
//    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.CREATED);
    }

    // GET : http://localhost:8080/books/1
    // GET : http://localhost:8080/books/2
    // 1, 2 là ID của book
    @ResponseBody
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
}