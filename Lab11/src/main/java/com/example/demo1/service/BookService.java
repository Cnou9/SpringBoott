package com.example.demo1.service;

import com.example.demo1.dao.BookDAO;
import com.example.demo1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Book getBookById(int id) {
        // Cách 1:
        return bookDAO.findById(id);

        // Cách 2:
//        for (Book book : bookDAO.findAll()) {
//            if (book.getId().equals(id)) {
//                return book;
//            }
//        }
//        return null;
    }
}
